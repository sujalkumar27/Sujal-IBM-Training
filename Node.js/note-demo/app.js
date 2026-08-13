// app.js

// Import required modules
const express = require("express");
const bodyParser = require("body-parser");
const mongoose = require("mongoose");
require("dotenv").config();


// Create Express application
const app = express();


// Set EJS as the view engine
app.set("view engine", "ejs");


// Middleware to read form data
app.use(bodyParser.json());

app.use(bodyParser.urlencoded({
    extended: true
}));


// Connect to MongoDB Atlas
mongoose.connect(process.env.MONGODB_URI)
    .then(() => {
        console.log("Connected to MongoDB Atlas");
    })
    .catch((error) => {
        console.log("MongoDB connection error:", error);
    });


// Create Note Schema
const noteSchema = new mongoose.Schema({

    noteContent: {
        type: String,
        required: true
    }

});


// Create Note Model
const Note = mongoose.model("Note", noteSchema);


// ==========================================
// GET ALL NOTES
// ==========================================

app.get("/", async (req, res) => {

    try {

        // Get all notes from MongoDB
        const notes = await Note.find();

        // Send notes to home.ejs
        res.render("home", {
            data: notes
        });

    } catch (error) {

        console.log("Error getting notes:", error);

        res.status(500).send("Error getting notes");

    }

});


// ==========================================
// ADD NOTE
// ==========================================

app.post("/", async (req, res) => {

    try {

        // Get note content from form
        const noteContent = req.body.noteContent;

        // Create a new note
        const newNote = new Note({
            noteContent: noteContent
        });

        // Save note to MongoDB
        await newNote.save();

        // Redirect to home page
        res.redirect("/");

    } catch (error) {

        console.log("Error adding note:", error);

        res.status(500).send("Error adding note");

    }

});


// ==========================================
// UPDATE NOTE
// ==========================================

app.post("/update", async (req, res) => {

    try {

        // Get note ID and updated content
        const noteId = req.body.noteId;
        const noteContent = req.body.noteContent;


        // Update note in MongoDB
        await Note.findByIdAndUpdate(
            noteId,
            {
                noteContent: noteContent
            }
        );


        // Go back to home page
        res.redirect("/");

    } catch (error) {

        console.log("Error updating note:", error);

        res.status(500).send("Error updating note");

    }

});


// ==========================================
// DELETE NOTE
// ==========================================

app.post("/delete", async (req, res) => {

    try {

        // Get note ID
        const noteId = req.body.noteId;


        // Delete note from MongoDB
        await Note.findByIdAndDelete(noteId);


        // Go back to home page
        res.redirect("/");

    } catch (error) {

        console.log("Error deleting note:", error);

        res.status(500).send("Error deleting note");

    }

});


// ==========================================
// START SERVER
// ==========================================

app.listen(3000, () => {

    console.log("App is running on port 3000");

});