require("dotenv").config();

const express = require("express");

const connectDB = require("./db/mongoose");

const userRouter = require("./routers/user");
const taskRouter = require("./routers/task");


const app = express();


// Middleware
app.use(express.json());


// Routes
app.use("/users", userRouter);
app.use("/tasks", taskRouter);


// Start server
const startServer = async () => {

    try {

        await connectDB();

        const port = process.env.PORT || 3000;

        app.listen(port, () => {

            console.log(
                `Server is running on port ${port}`
            );

        });

    } catch (error) {

        console.error(
            "Server could not start"
        );

        process.exit(1);
    }
};


startServer();


module.exports = app;