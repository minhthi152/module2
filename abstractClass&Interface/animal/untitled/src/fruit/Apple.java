package fruit;

public class Apple extends Fruit{
    public String name;

    public Apple(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String howToEat() {
        return " could be slided";
    }
}
