public class Cat extends Animal {

    public boolean fur;


    public Cat(boolean fur) {
        this.fur = fur;
    }

public Cat(String name, double weight,boolean fur) {
    super(name, weight);
    this.fur = fur;
}

    public boolean isFur() {
        return fur;
    }

    public void setFur(boolean fur) {
        this.fur = fur;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow meow");
    }

    @Override
    public String toString() {
        return "Hello, " + super.toString() + ". I " + (isFur()? "have fur" : "dont have fur") ;
    }
}
