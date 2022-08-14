package Dymura_hw4;

public class Cat extends Animal{
    private static int count;

    public Cat(String name){
        super(name);
        count++;
    }

    public static void counter(){
        System.out.println("User created " + count + " cats.");
    }

    @Override
    public void run(int length){
        if (length > 200){
            System.out.println("Cats can't run so far.");
        } else if (length <= 0) {
            System.out.println("Wrong number.");
        } else {
            System.out.println("A cat called " + name + " ran " + length + " meters.");
        }
    }

    @Override
    public void swim(int length){
        System.out.println("Cats can't swim.");
    }
}
