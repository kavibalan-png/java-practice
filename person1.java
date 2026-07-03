class Person {
    String name = "Rahul";
}
class Student extends Person {
    String name = "Arun";

    void display() {
        System.out.println("Parent Name: " + super.name);
        System.out.println("child Name: " + name);
    }
}
public class person1 {
    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}