package Dymura_hw5.Figures;

public class Square extends Figure implements Basic {
    public Square(double a) {
        super(a);
    }

    @Override
    public double square() {
        double S;
        S = Math.pow(a, 2);
        System.out.println("Square of square is: " + S);
        return S;
    }
}
