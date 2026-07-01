// Abstract Class
abstract class Employee {

    // Abstract Method
    abstract void calculateSalary();

    // Normal Method
    void companyName() {
        System.out.println("Company: ABC Technologies");
    }
}

// Child Class Developer
class Developer extends Employee {

    void calculateSalary() {
        System.out.println("Developer Salary: Rs.50,000");
    }
}

// Child Class Manager
class Manager extends Employee {

    void calculateSalary() {
        System.out.println("Manager Salary: Rs.80,000");
    }
}

// Main Class
public class EmployeeSystem {

    public static void main(String[] args) {

        Developer dev = new Developer();
        dev.companyName();
        dev.calculateSalary();

        System.out.println();

        Manager mgr = new Manager();
        mgr.companyName();
        mgr.calculateSalary();
    }
}