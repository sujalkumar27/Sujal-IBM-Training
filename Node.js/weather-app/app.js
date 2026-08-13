const express = require("express");
require("dotenv").config();

const app = express();


// Tell Express to use EJS for HTML pages
app.set("view engine", "ejs");


// Function to get weather from OpenWeatherMap
async function getWeather(city) {

    try {

        const response = await fetch(
            `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${process.env.WEATHER_KEY}&units=metric`
        );

        // Check if city/API request is invalid
        if (!response.ok) {
            throw new Error(`Weather API error: ${response.status}`);
        }

        // Convert response to JSON
        const data = await response.json();

        // Return required information
        return {
            city: data.name,
            temperature: data.main.temp,
            feelsLike: data.main.feels_like,
            humidity: data.main.humidity,
            forecast: data.weather[0].description
        };

    } catch (error) {

        console.log("Error:", error.message);

        return {
            error: "Unable to fetch weather data"
        };
    }
}


// Home page
app.get("/", (req, res) => {

    // Show the HTML page
    res.render("index", {
        weather: null
    });

});


// Weather route
app.get("/weather", async (req, res) => {

    // Get city entered by the user
    const city = req.query.city;

    // If no city is entered
    if (!city) {

        return res.render("index", {
            weather: null,
            error: "Please enter a city name"
        });

    }

    // Get weather information
    const weatherData = await getWeather(city);

    // Display the result
    res.render("index", {
        weather: weatherData,
        error: null
    });

});


// Start server
app.listen(3000, () => {

    console.log("Weather server is running on port 3000");

});