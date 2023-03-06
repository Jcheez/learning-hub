const checkAuthenticated = (req, res, next) => {
    if (req.isAuthenticated()) {
        return next()
    } else {
        res.status(200).json({message: "Not authenticated"})
    }
}

const checkNotAuthenticated = (req, res, next) => {
    if (req.isAuthenticated()) {
        res.status(200).json({message: "Already authenticated"})
    } else {
        return next()
    }
}

module.exports = {
    checkAuthenticated,
    checkNotAuthenticated
}