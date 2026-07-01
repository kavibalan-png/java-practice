class Student {
    String name;
    int age;

    Student() {
        name = "Unknown";
        age = 0;
    }

    Student(String n, int a) {
        name = n;
        age = a;
    }
}
class Student {
    String name;
    int age;

    // Constructor 1 (Default)
    Student() {
        name = "Unknown";
        age = 0;
    }
    // Constructor 2 (Parameterized - 1 parameter)
    Student(String n) {
        name = n;
        age = 18; // default age
    }
    // Constructor 3 (Parameterized - 2 parameters)
    Student(String n, int a) {
        name = n;
        age = a;
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("----------------");
    }
}
public class CONSconstructoroverloading {
    public static void main(String[] args) {

        // calls default constructor
        Student s1 = new Student();

        // calls constructor with 1 parameter
        Student s2 = new Student("John");

        // calls constructor with 2 parameters
        Student s3 = new Student("David", 22);
        s1.display();
        s2.display();
        s3.display();
    }
}

