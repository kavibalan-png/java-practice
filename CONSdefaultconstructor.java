class Student {
    String name;
    int age;
    // Default Constructor
    Student() {
        name = "Unknown";
        age = 0;
    }
    // Method to display values
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
public class Main {
    public static void main(String[] args) {
        // Object creation → constructor automatically called
        Student s1 = new Student();
        // calling method
        s1.display();
    }
}