interface Pet {
    void play();
}

interface Trainable {
    void train();
}

class Animal12 {
    void eat() {
        System.out.println("Animal is eating");
    }
}
class Dog extends Animal12 {

    void bark() {
        System.out.println("Dog is barking");
    }
}
class PetDog extends Dog implements Pet, Trainable {

    public void play() {
        System.out.println("Dog is playing with owner");
    }

    public void train() {
        System.out.println("Dog is getting trained");
    }
}

public class hybrid {
    public static void main(String[] args) {

        PetDog d = new PetDog();

        d.eat();     // from Animal
        d.bark();    // from Dog
        d.play();    // from Pet interface
        d.train();   // from Trainable interface
    }
}