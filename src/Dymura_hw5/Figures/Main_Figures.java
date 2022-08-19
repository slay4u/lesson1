package Dymura_hw5.Figures;

public class Main_Figures {
    Figure circle = new Circle(11.3);
    Figure triangle = new Triangle(11.3);
    Figure square = new Square(11.3);
    Figure [] figures = new Figure[3];

    public void squares(){
        double allS = 0;
        for (int i = 0; i < figures.length; i++) {
            if (figures.equals(circle)) {
                allS += ((Circle) circle).square();
            } else if (figures.equals(triangle)) {
                allS += ((Triangle) triangle).square();
            } else {
                allS += ((Square) square).square();
            }
        }
        System.out.println("All squares are: " + allS);
    }

    public static void main(String[] args) {
        Circle circle = new Circle(11.3);
        circle.square();
        Triangle triangle = new Triangle(11.3);
        triangle.square();
        Square square = new Square(11.3);
        square.square();
        Figure [] figures = new Figure[3];
        figures[0] = circle;
        figures[1] = triangle;
        figures[2] = square;

    }
}
