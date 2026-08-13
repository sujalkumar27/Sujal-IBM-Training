const mongoose = require("mongoose");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");


// User Schema
const userSchema = new mongoose.Schema(
    {
        name: {
            type: String,
            required: true,
            trim: true
        },

        email: {
            type: String,
            required: true,
            unique: true,
            lowercase: true,
            trim: true
        },

        password: {
            type: String,
            required: true,
            minlength: 6
        }
    },
    {
        timestamps: true
    }
);


// Hash password before saving
userSchema.pre("save", async function (next) {

    // If password was not changed, don't hash again
    if (!this.isModified("password")) {
        return next();
    }

    // Hash password
    this.password = await bcrypt.hash(this.password, 10);

    //next();
});


// Generate JWT token
userSchema.methods.generateAuthToken = function () {

    const token = jwt.sign(
        {
            _id: this._id.toString()
        },
        process.env.JWT_SECRET,
        {
            expiresIn: "7d"
        }
    );

    return token;
};


// Check password
userSchema.methods.checkPassword = async function (password) {

    return await bcrypt.compare(
        password,
        this.password
    );
};


const User = mongoose.model("User", userSchema);

module.exports = User;