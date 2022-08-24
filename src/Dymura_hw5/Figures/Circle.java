package Dymura_hw5.Figures;

public class Circle implements Basic {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double square() {
        double S;
        S = Math.PI * Math.pow(r, 2);
        System.out.println("Square of circle is: " + S);
        return S;
    }
}
