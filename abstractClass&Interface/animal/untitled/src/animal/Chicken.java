package animal;

import edible.Edible;

public class Chicken extends Animal implements Edible {
    public String name;

    public Chicken(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return " could be fried";
    }

}