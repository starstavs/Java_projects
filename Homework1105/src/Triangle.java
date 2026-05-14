public class Triangle extends Shape {
    private double width;

    Triangle(double width, double height){
       this.width = width;
       this.height = height;
       CalculateFigureShape();
    }

    public double getWidth() {
        return width;
    }

    private void CalculateFigureShape() {
        shapeFigure = (width * height)/2;
    }
}
