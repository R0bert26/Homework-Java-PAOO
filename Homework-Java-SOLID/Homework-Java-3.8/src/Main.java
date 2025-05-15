import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        DrawingService drawingService = new DrawingService(Arrays.asList(circle, rectangle));
        drawingService.renderShapes();
    }
}
