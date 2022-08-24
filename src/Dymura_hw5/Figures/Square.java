package Dymura_hw5.Figures;

public class Square implements Basic {
    private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double square() {
        double S;
        S = Math.pow(a, 2);
        System.out.println("Square of square is: " + S);
        return S;
    }
}
