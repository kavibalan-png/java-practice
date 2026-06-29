// Parent Class
class Animal {

    void eat() {
        System.out.println("Animal is eating.");
    }
}

// Child Class
class Mammal extends Animal {

    void walk() {
        System.out.println("Mammal is walking.");
    }
}

// Grandchild Class
class kog extends Mammal {

    void bark() {
        System.out.println("Dog is barking.");
    }
}

// Main Class
public class MultilevelInheritanceExample {

    public static void main(String[] args) {

        kog d = new kog();

        d.eat();    // Inherited from Animal
        d.walk();   // Inherited from Mammal
        d.bark();   // Dog's own method
    }
}