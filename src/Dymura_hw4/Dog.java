package Dymura_hw4;

public class Dog extends Animal{
    private static int count;

    public Dog(String name){
        super(name);
        count++;
    }

    public static void counter(){
        System.out.println("User created " + count + " dogs.");
    }

    @Override
    public void run(int length){
        if (length > 500){
            System.out.println("Dogs can't run so far.");
        } else if (length <= 0) {
            System.out.println("Wrong number.");
        } else {
            System.out.println("A dog called " + name + " ran " + length + " meters.");
        }
    }

    @Override
    public void swim(int length){
        if (length > 10){
            System.out.println("Dogs can't swim so far.");
        } else if (length <= 0) {
            System.out.println("Wrong number.");
        } else {
            System.out.println("A dog called " + name + " swam " + length + " meters.");
        }
    }
}
