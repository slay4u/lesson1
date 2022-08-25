package Dymura_hw5.Game;

public class Run_Track implements Obstacle{
        protected double length;
        protected String name;

        public Run_Track(double length, String name) {
                this.length = length;
                this.name = name;
        }

        @Override
        public String getName() {
                return name;
        }

        @Override
        public double overcome() {
                return length;
        }
}
