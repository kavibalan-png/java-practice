class Animal_ {
    Animal_(String name) {
        System.out.println("Animal " + name);
    }
}

class dog extends Animal_ {
    dog() {
        super("Tommy");
        System.out.println("Dog Constructor");
    }
}

public class superclass {
    public static void main(String[] args) {
        dog d = new dog();
    }
}
