const express = require('express')

const userController = require('../services/userService')
const authMiddleware = require('../middlewares/authMiddleware')
const router = express.Router()

router.post('/signup',authMiddleware.checkNotAuthenticated, userController.register)
router.post('/login',authMiddleware.checkNotAuthenticated, userController.signin)

router.delete('/logout',authMiddleware.checkAuthenticated, userController.signOut)

module.exports = router