package animal;

public class Tiger extends Animal {
    public String name;

    public Tiger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }
}
