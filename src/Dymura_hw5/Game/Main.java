package Dymura_hw5.Game;

public class Main {
    public static void main(String[] args) {
        Participant [] participants = new Participant[3];
        participants[0] = new Cat(100, 1, "Andy");
        participants[1] = new Human(200, 2, "Jake");
        participants[2] = new Robot(300, 3, "Rocky");
        Obstacle [] obstacles = new Obstacle[4];
        obstacles[0] = new Run_Track(50, "Run1");
        obstacles[1] = new Wall(1.5, "Wall1");
        obstacles[2] = new Run_Track(250, "Run2");
        obstacles[3] = new Wall(2.5, "Wall2");
        double num, num1;
        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j].getClass().equals(Run_Track.class)) {
                    num = participants[i].run(obstacles[j].overcome());
                    if (num == -99) {
                        System.out.println("Participant " + participants[i].getName() + " failed obstacle " +
                                obstacles[j].getName() + " on distance " + obstacles[j].overcome());
                        System.out.println("Passed only " + participants[i].getMaxRun());
                        break;
                    } else System.out.println("Participant " + participants[i].getName() +
                            " went through obstacle " + obstacles[j].getName() + " on distance " + num);
                } else {
                    num1 = participants[i].jump(obstacles[j].overcome());
                    if (num1 == -99) {
                        System.out.println("Participant " + participants[i].getName() + " failed obstacle " +
                                obstacles[j].getName() + " on distance " + obstacles[j].overcome());
                        System.out.println("Passed only " + participants[i].getMaxJump());
                        break;
                    } else System.out.println("Participant " + participants[i].getName() +
                            " went through obstacle " + obstacles[j].getName() + " on distance " + num1);
                }
            }
        }
    }
}
