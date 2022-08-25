package Dymura_hw5.Game;

public class Wall implements Obstacle{
        protected double height;
        protected String name;

        public Wall(double height, String name) {
                this.height = height;
                this.name = name;
        }

        @Override
        public String getName() {
                return name;
        }

        @Override
        public double overcome() {
                return height;
        }
}
