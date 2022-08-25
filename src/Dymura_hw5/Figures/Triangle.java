package Dymura_hw5.Figures;

public class Triangle implements Figure {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double square() {
        double S, p;
        p = (a + b + c) / 2;
        S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("Square of triangle is: " + S);
        return S;
    }
}
