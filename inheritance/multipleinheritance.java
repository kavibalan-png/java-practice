class A {

    void display() {
        System.out.println("Display from A");
    }
}

class B extends A {

    void display() {
        System.out.println("Display from B");
    }
}

class C extends A {

    void display() {
        System.out.println("Display from C");
    }
}

// Suppose Java allowed this
class D extends B,C {

}

public class multipleinheritance{

    public static void main(String[] args) {

        D obj = new D();
        obj.display();
    }
}