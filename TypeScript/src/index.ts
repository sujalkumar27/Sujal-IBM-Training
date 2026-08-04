interface User {
    id: number;
    name: string;
    email?: string; // Optional property

    area(side: number): void;
}


class Student implements User {

    id: number;
    name: string;
    email?: string;  //optional variable

    // Parameterized constructor
    constructor(id: number = 0, name: string = "Guest", email?: string) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    area(side: number): void {
        console.log("Area of square =", side * side);
    }


    display(): void {
        console.log("ID:", this.id);
        console.log("Name:", this.name);
        console.log("Email:", this.email ?? "Email not provided");
    }
}


// Using default constructor values
const user1 = new Student();
user1.display();

// Using parameterized constructor
const user2 = new Student(101,"sujal","sujal@gmail.com");
user2.display();


// Calling interface method
user2.area(5);