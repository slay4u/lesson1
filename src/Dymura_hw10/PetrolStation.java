package Dymura_hw10;

public class PetrolStation {
    private Double amount = 1000.0;

    void doRefuel(Double newAmount) {
        Runnable run = () -> {
            synchronized (amount) {
                int time = (int) ((Math.random() * (10 - 3 + 1) + 3) * 1000);
                if (amount >= newAmount) {
                    try {
                        Thread.sleep(time);
                        amount = amount - newAmount;
                        System.out.println("Refueling completed, new amount of gas is: " + amount + " .");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Not enough gas to complete refuel.");
                }
            }
        };
        new Thread(run).start();
    }
}
