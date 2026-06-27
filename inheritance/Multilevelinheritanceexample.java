//Parent Class
class Animal {

    void eat() {
        System.out.println("Animal is eating.");
    }
}
//Child Class
class Mammal extends Animal {

    void walk() {
        System.out.println("Mammal is walking.");
    }
}
//Grandchild Class
class Dog extends Mammal {

    void bark() {
        System.out.println("Dog is barking.");
    }
}
//Main Method
public class Multilevelinheritanceexample{
    public static void main(String[] args) {

        Dog d = new Dog();

        d.eat();
        d.walk();
        d.bark();
    }
}