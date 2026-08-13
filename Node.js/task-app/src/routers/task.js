const express = require("express");
const Task = require("../models/task");
const auth = require("../middleware/auth");

const router = express.Router();


// All task routes require authentication
router.use(auth);


// ======================================
// CREATE TASK
// POST /tasks
// ======================================

router.post("/", async (req, res) => {

    try {

        const task = new Task({
            description: req.body.description,
            completed: req.body.completed || false,
            owner: req.user._id
        });


        await task.save();


        res.status(201).send(task);

    } catch (error) {

        res.status(400).send({
            error: error.message
        });
    }
});


// ======================================
// GET TASKS
// GET /tasks
// ======================================

router.get("/", async (req, res) => {

    try {

        const match = {
            owner: req.user._id
        };


        // Filter by completed
        if (req.query.completed !== undefined) {

            match.completed =
                req.query.completed === "true";
        }


        // Pagination
        const limit = parseInt(req.query.limit) || 10;

        const skip = parseInt(req.query.skip) || 0;


        // Sorting
        let sort = { createdAt: -1 };


        if (req.query.sortBy) {

            const [field, direction] =
                req.query.sortBy.split(":");


            sort = {};

            sort[field] =
                direction === "desc" ? -1 : 1;
        }


        const tasks = await Task.find(match)
            .sort(sort)
            .skip(skip)
            .limit(limit);


        res.send(tasks);

    } catch (error) {

        res.status(500).send({
            error: error.message
        });
    }
});


module.exports = router;