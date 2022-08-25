package Dymura_hw5.Game;

public class Human implements Participant{
    protected double maxRun, maxJump;
    protected String name;

    public Human(double maxRun, double maxJump, String name) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.name = name;
    }

    @Override
    public double getMaxRun() {
        return maxRun;
    }

    @Override
    public double getMaxJump() {
        return maxJump;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double run(double a) {
        if (a > maxRun) {
            return -99;
        } else return maxRun;
    }

    @Override
    public double jump(double a) {
        if (a > maxJump) {
            return -99;
        } else return maxJump;
    }
}
