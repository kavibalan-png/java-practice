class Student1 {
    String name;
    int age;

    // Parameterized Constructor
    Student1(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class CONSparameterconstructor {
    public static void main(String[] args) {

        // values pass pannrom constructor ku
        Student1 s1 = new Student1("John", 20);

        s1.display();
    }
}
