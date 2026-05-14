public class Shape {
    protected double shapeFigure;
    protected double height;


    Shape() {
    }

    public double getShapeFigure() {
        return shapeFigure;
    }

    @Override
    public String toString() {
        return "Shape = " + getShapeFigure();
    }
}
