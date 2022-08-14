package Dymura_hw4;

public class Animal {
    protected String name;
    private static int count;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public static void counter(){
        System.out.println("User created " + count + " animals.");
    }

    public void run(int length){
        System.out.println("Animal called " + name + " ran " + length + " meters.");
    }

    public void swim(int length){
        System.out.println("Animal called " + name + " swam " + length + " meters.");
    }
}
