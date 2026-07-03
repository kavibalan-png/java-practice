class Person1 {
    String name = "Rahul";
}

class Student extends Person1 {
    String name = "Arun";

    void display() {
        System.out.println("Parent Name: " + super.name);
        System.out.println("child Name: " + name);
    }
}

public class Person {
    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}