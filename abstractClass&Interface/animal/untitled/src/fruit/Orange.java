package fruit;

public class Orange extends Fruit{
    public String name;

    public Orange(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String howToEat() {
        return " should be juiced";
    }
}
