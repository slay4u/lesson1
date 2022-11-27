package Dymura_hw9;

import java.util.Arrays;

public class ValueCalculator implements Runnable{
    private final int sizeArray = 3000000;
    private double[] array = new double[sizeArray];
    private final int halfArray = sizeArray / 2;

    ValueCalculator(){}

    ValueCalculator(double[] array) {
        this.array = array;
    }

    void doCalc() throws InterruptedException {
        long start = System.currentTimeMillis();
        double[] array1 = new double[halfArray];
        double[] array2 = new double[halfArray];
        Arrays.fill(array, 1);
        System.arraycopy(array, 0, array1, 0, halfArray);
        System.arraycopy(array, halfArray, array2, 0, halfArray);
        Thread thread1 = new Thread(new ValueCalculator(array1));
        Thread thread2 = new Thread(new ValueCalculator(array2));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(array1, 0, array, 0, halfArray);
        System.arraycopy(array2, 0, array, halfArray, halfArray);
        System.out.println("Time spent on calculating from start to finish is " + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    @Override
    public void run() {
        for (int i = 0; i < halfArray; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
