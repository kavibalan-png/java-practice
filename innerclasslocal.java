class A {
    void show() {
        // Local Inner Class (inside method)
        class B {
            void display() {
                System.out.println("Hello from Local Inner Class");
            }
        }
        // object create inside method
        B b = new B();
        b.display();
    }
}
public class innerclasslocal {
        public static void main(String[] args) {
        A obj = new A();
        obj.show();
    }
}
