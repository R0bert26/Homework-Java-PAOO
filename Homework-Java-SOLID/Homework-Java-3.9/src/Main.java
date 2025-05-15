import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Shape circle = new Circle(3);
        Shape square = new Square(4);
        Shape rectangle = new Rectangle(2, 5);

        AreaCalculator calculator = new AreaCalculator(Arrays.asList(circle, square, rectangle));
        System.out.println("Total area of shapes: " + calculator.totalArea());
    }
}
