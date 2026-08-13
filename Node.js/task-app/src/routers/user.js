const express = require("express");
const User = require("../models/user");
const auth = require("../middleware/auth");

const router = express.Router();


// POST /users
router.post("/", async (req, res) => {

    try {
        console.log("Post is working");

        const user = new User(req.body);

        await user.save();

        const token = user.generateAuthToken();

        res.status(201).send({
            user: {
                _id: user._id,
                name: user.name,
                email: user.email
            },
            token
        });

    } catch (error) {

        res.status(400).send({
            error: error.message
        });
    }
});


// POST /users/login
router.post("/login", async (req, res) => {

    try {

        const { email, password } = req.body;

        const user = await User.findOne({ email });

        if (!user) {
            return res.status(400).send({
                error: "Invalid email or password"
            });
        }

        const isMatch = await user.checkPassword(password);

        if (!isMatch) {
            return res.status(400).send({
                error: "Invalid email or password"
            });
        }

        const token = user.generateAuthToken();

        res.send({
            user: {
                _id: user._id,
                name: user.name,
                email: user.email
            },
            token
        });

    } catch (error) {

        res.status(500).send({
            error: error.message
        });
    }
});


// GET /users/me
router.get("/me", auth, async (req, res) => {

    res.send({
        _id: req.user._id,
        name: req.user.name,
        email: req.user.email
    });

});


module.exports = router;