const express = require('express')
const mongoose = require('mongoose')
const cors = require('cors')
const passport = require('passport')
const session = require('express-session')
const MongoStore = require('connect-mongo')
require('dotenv').config()

const app = express()
const PORT = process.env.PORT || 3000

// Connection to MONGODB
const DB_URL = process.env.DEV_TYPE === "DEV" ? process.env.DEV_DB : process.env.PROD_DB
mongoose.connect(DB_URL).then(() => {
    console.log(`Connection established with ${process.env.DEV_TYPE} DB!`)
}).catch(err => {
    console.log(`Error connecting to ${process.env.DEV_TYPE} DB: ${err}`)
})

// Initialise passport local
const initailizePassport = require('./src/configs/passport-local-config')
initailizePassport(passport)

// CORS configuration
app.use(cors({
    origin: process.env.FRONT_END,
    methods: ['GET','POST','DELETE','UPDATE','PUT','PATCH'],
    credentials: true
}))

// req.body configuration
app.use(express.json())

// Initialise Express session
app.use(session({
    secret: process.env.SESSION_SECRET,
    resave: false,
    saveUninitialized: false,
    store: MongoStore.create({
        mongoUrl: DB_URL,
        ttl: 24*60*60,
        autoRemove: 'native'
    }),
    cookie: {
        httpOnly: false,
        maxAge: 1000*24*60*60,
    }
}))

// Initialise Passport.js
app.use(passport.initialize())
app.use(passport.session())

// Initialising Routes
app.use("/api/user", require('./src/routes/userRoute'))

// Starting the server
app.listen(PORT, err => {
    if (!err) {
        console.log(`Server is running on port ${PORT}`)
    } else {
        console.log(`Server is not running. ${err}`)
    }
})