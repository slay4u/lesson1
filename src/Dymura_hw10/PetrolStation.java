package Dymura_hw10;

import java.util.concurrent.Semaphore;

public class PetrolStation {
    private volatile Double amount = 1000.0;
    private static final Semaphore semaphore = new Semaphore(3, true);

    void doRefuel(Double newAmount) {
        Runnable run = () -> {
            try {
                semaphore.acquire();
                int time = (int) ((Math.random() * (10 - 3 + 1) + 3) * 1000);
                synchronized (amount) {
                    if (amount >= newAmount) {
                        amount = amount - newAmount;
                        System.out.println("Refueling completed, new amount of gas is: " + amount + " .");
                    } else {
                        System.out.println("Not enough gas to complete refuel.");
                    }
                }
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        };
        new Thread(run).start();
    }
}
