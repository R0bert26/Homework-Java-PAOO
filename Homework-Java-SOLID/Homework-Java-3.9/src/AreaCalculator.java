import java.util.List;

public class AreaCalculator {

    private List<Shape> shapes;

    public AreaCalculator(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public double totalArea() {
        return shapes.stream()
                .mapToDouble(Shape::area)
                .sum();
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }
}
