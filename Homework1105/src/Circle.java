public class Circle extends Shape {
    private static final double pi = 3.14;



    Circle(double radius) {
        height = radius;
        CalculateFigureShape();
    }


    private void CalculateFigureShape() {
        shapeFigure = pi * height* height;
    }


}
