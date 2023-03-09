const bcrypt = require('bcrypt')
const passport = require('passport')

const User = require('../models/user')


const register = async (req, res) => {
    const password = req.body.password
    const username = req.body.username
    const email = req.body.email
    
    const userPresent = await User.findOne({email: email})

    if (userPresent) {
        res.status(200).json({
            err: {
                email: "Email already registered!"
            }
        })
    } else {
        User.create({
            username: username,
            email: email,
            password: await bcrypt.hash(password, 10)
        }).then(_ => {
            res.status(201).json({
                message: "Congratulations! Your account has been successfully created."
            })
        })
    }
}

const signin = (req, res, next) => {
    passport.authenticate('local', (err, user, info) => {
        if (err) {
            return next(err)
        }
        if (!user) {
            res.status(200).json(info)
        } else {
            req.logIn(user, err => {
                if (err) { 
                    return next(err)
                } else {
                    res.status(200).json({ message: "Login Success", expiry: Date.now() + 1000*24*60*60})
                    next()
                }
            })
            
        }
    })(req, res, next)
}

const signOut = (req, res) => {
    req.session.destroy(error => {
        if (error) {
            res.status(400).json({err: error})
        } else {
            res.status(200).json({message: "Logout Success"})
        }
    })
}

module.exports = {
    register,
    signin,
    signOut
}