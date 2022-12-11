package Dymura_hw10;

public class Main {
    public static void main(String[] args) {
        ThreadSafeList<Double> list = new ThreadSafeList<>();
        new Thread(() -> list.add(100.2)).start();
        new Thread(() -> list.add(91.5)).start();
        new Thread(() -> list.add(14.9)).start();
        new Thread(() -> list.add(1.2)).start();
        System.out.println(list);
        new Thread(() -> list.remove(14.9)).start();
        new Thread(() -> list.remove(91.5)).start();
        new Thread(() -> list.get(1)).start();
        System.out.println(list);
        Double t = list.get(1);
        System.out.println(t);

        PetrolStation station = new PetrolStation();
        station.doRefuel(500.0);
        station.doRefuel(10.0);
        station.doRefuel(500.0);
    }
}
