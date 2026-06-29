class Shape {
    void draw() {
        System.out.println("Drawing Shape");
    }
}

class Circle extends Shape {
    void area() {
        System.out.println("Circle Area");
    }
}

class Square extends Shape {
    void area() {
        System.out.println("Square Area");
    }
}

public class ShapeExamplehierachical {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();
        circle.area();

        Square square = new Square();
        square.draw();
        square.area();
    }
}
