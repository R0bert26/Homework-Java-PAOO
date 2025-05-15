import java.util.List;

public class DrawingService {

    private List<Shape> shapes;

    public DrawingService(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void renderShapes() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }
}
