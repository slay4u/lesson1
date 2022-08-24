package Dymura_hw5.Figures;

public class Main_Figures {
    public static void main(String[] args) {
        Basic [] basics = new Basic[5];
        basics[0] = new Circle(13.9);
        basics[1] = new Square(11.3);
        basics[2] = new Triangle(11.3, 9.5, 14.2);
        basics[3] = new Square(23.6);
        basics[4] = new Triangle(10.1, 6.4, 4.6);
        double allS = 0;
        for (int i = 0; i < basics.length; i++) {
            allS += basics[i].square();
        }
        System.out.println("All squares are: " + allS);
    }
}
