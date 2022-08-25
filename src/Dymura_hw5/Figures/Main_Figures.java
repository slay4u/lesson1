package Dymura_hw5.Figures;

public class Main_Figures {
    public static void main(String[] args) {
        Figure [] figures = new Figure[5];
        figures[0] = new Circle(13.9);
        figures[1] = new Square(11.3);
        figures[2] = new Triangle(11.3, 9.5, 14.2);
        figures[3] = new Square(23.6);
        figures[4] = new Triangle(10.1, 6.4, 4.6);
        double allS = 0;
        for (int i = 0; i < figures.length; i++) {
            allS += figures[i].square();
        }
        System.out.println("All squares are: " + allS);
    }
}
