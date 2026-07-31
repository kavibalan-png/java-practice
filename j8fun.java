interface Demo5 {
    // Abstract Method
    void show();
    // Default Method
    default void display() {
        System.out.println("Display Method");
    }
    // Static Method
    static void test() {
        System.out.println("Static Method");
    }
}
public class j8fun{
        public static void main(String[] args) {
        // Lambda Expression
        Demo5 d = () -> System.out.println("Hello from show()");
        // Abstract Method
        d.show();
        // Default Method
        d.display();
        // Static Method
        Demo5.test();
    }
}