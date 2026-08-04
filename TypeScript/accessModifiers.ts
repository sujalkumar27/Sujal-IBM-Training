class Employee {

    // public property
    public name: string;

    // private property
    private salary: number;

    // protected property
    protected department: string;

    constructor(name: string, salary: number, department: string) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    // public method
    public displayDetails(): void {
        console.log("Name:", this.name);
        console.log("Salary:", this.salary);
        console.log("Department:", this.department);
    }
   // private method
    private calculateBonus(): number {
        return this.salary * 0.10;
    }

    // public method calling private method
    public showBonus(): void {
        console.log("Bonus:", this.calculateBonus());
    }
}


// Creating object
const emp = new Employee(
    "Sujal",
    50000,
    "IT"
);


// Accessing public property
console.log(emp.name);

// Calling public method
emp.displayDetails();

// Calling public method which uses private method
emp.showBonus();

// These will give errors:

// console.log(emp.salary); 
// ❌ Error: salary is private


// console.log(emp.department);
// ❌ Error: department is protected