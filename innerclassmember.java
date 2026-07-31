class A {
    int x = 100;

    class B {
        void display() {
            System.out.println("x:" + x);
        }
    }
}

public class innerclassmember {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B(); // must use 'a.new B()' to create inner class instance
        b.display();
    }
}
