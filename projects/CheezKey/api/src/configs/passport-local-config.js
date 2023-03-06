const LocalStrategy = require('passport-local').Strategy
const bcrypt = require('bcrypt')

const User = require("../models/user")


const authenticateUser = async (email, password , done) => {
    const user = await User.findOne({email: email})
    if (user === null) {
        return done(null, false, { err: "Email not registered" })
    }

    try {
        if (await bcrypt.compare(password, user.password)) {
            return done(null, user)
        } else {
            return done(null, false, {err: 'Password incorrect'})
        }
    } catch (err) {
        return done(err)
    }
}

const initalize = (passport) => {
    passport.use(new LocalStrategy({usernameField: 'email'}, authenticateUser))
    
    passport.serializeUser((user, done) => {
        done(null, {id: user.id, name: user.username})
    })

    passport.deserializeUser((user, done) => {
        done(null, User.findById(user.id))
    })
}

module.exports = initalize