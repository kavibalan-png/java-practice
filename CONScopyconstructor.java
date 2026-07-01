Student2 {
    String name;

    Student2(String n) {
        name = n;
    }
class
    Student2(Student2 s) {
        name = s.name;
    }
}


class Student2 {
    String name;
    int age;

    // Parameterized Constructor
    Student2(String n, int a) {
        name = n;
        age = a;
    }

    // Copy Constructor
    Student2(Student2 s) {
        name = s.name;
        age = s.age;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class copyconstructor {
    public static void main(String[] args) {

        // Original object
        Student2 s1 = new Student2("John", 20);

        // Copy object
        Student2 s2 = new Student2(s1);

        s1.display();
        s2.display();
    }
}

