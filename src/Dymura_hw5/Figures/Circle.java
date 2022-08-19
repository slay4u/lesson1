package Dymura_hw5.Figures;

public class Circle extends Figure implements Basic {
    public Circle(double a) {
        super(a);
    }

    @Override
    public double square() {
        double S;
        S = Math.PI * Math.pow(a, 2);
        System.out.println("Square of circle is: " + S);
        return S;
    }
}
