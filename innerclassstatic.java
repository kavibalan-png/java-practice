class Car {
    static String company = "BMW";

    static class Engine {

        void start() { //normal method
            System.out.println("Engine Started");
            System.out.println("Company : " + company);
        }
    }
}
public class innerclassstatic {

    public static void main(String[] args) {

        Car.Engine engine = new Car.Engine();

        engine.start();
    }
}