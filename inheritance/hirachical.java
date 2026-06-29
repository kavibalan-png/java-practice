class Car {

    // Properties (Instance Variables)
    String brand;
    String color;

    // Method
    void displayCar() {
        System.out.println("Car Brand : " + brand);
        System.out.println("Car Color : " + color);
    }
}

public class hirachical {
    public static void main(String[] args) {

        // Object Creation
        Car car1 = new Car();

        // Assigning values
        car1.brand = "Toyota";
        car1.color = "White";

        // Calling method
        car1.displayCar();
    }
}