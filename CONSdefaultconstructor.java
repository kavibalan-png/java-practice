class StudentDefault {
    String name;
    int age;

    // Default Constructor
    StudentDefault() {
        name = "Unknown";
        age = 0;
    }

    // Method to display values
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class CONSdefaultconstructor {
    public static void main(String[] args) {
        // Object creation → constructor automatically called
        StudentDefault s1 = new StudentDefault();
        // calling method
        s1.display();
    }
}