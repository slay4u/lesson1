package Dymura_hw4;

public class Main {
    public static void main(String[] args) {
        Animal ani = new Animal("Cool");
        ani.swim(50);
        Cat catFirst = new Cat("Mzk");
        catFirst.run(100);
        catFirst.run(300);
        catFirst.swim(2);
        Dog dogFirst = new Dog("Rust");
        dogFirst.run(300);
        dogFirst.run(600);
        Dog dog = new Dog("Dusty");
        dog.swim(5);
        dog.swim(12);

        Animal.counter();
        Cat.counter();
        Dog.counter();
    }
}
