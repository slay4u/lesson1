package Dymura_hw5.Figures;

public class Triangle extends Figure implements Basic {
    public Triangle(double a) {
        super(a);
    }

    @Override
    public double square() {
        double S;
        S = (Math.pow(a, 2) * Math.sqrt(3)) / 4;
        System.out.println("Square of triangle is: " + S);
        return S;
    }
}
