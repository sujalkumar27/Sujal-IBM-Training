"use strict";
class Student {
    id;
    name;
    email; //optional variable
    // Parameterized constructor
    constructor(id = 0, name = "Guest", email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    area(side) {
        console.log("Area of square =", side * side);
    }
    display() {
        console.log("ID:", this.id);
        console.log("Name:", this.name);
        console.log("Email:", this.email ?? "Email not provided");
    }
}
// Using default constructor values
const user1 = new Student();
user1.display();
// Using parameterized constructor
const user2 = new Student(101, "sujal", "sujal@gmail.com");
user2.display();
// Calling interface method
user2.area(5);
