public class Animal {
    public String name;
    public double weight;
    public Animal(){

    }

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void makeSound(){
        System.out.println("Animals can make sound");
    }
    public String toString() {
        return "My name is " + name +
                " and I weight " + weight + " kg";
    }
}
