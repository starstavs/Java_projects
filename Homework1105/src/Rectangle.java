public class Rectangle extends Shape {

    private double width;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        CalculateFigureShape();
    }


    private void CalculateFigureShape() {
        shapeFigure = width * height;
    }
}
