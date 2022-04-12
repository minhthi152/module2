import animal.Animal;
import animal.Chicken;
import animal.Tiger;
import edible.Edible;
import fruit.Apple;
import fruit.Fruit;
import fruit.Orange;

public class Test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger("Titi");
        System.out.println(((Tiger)animals[0]).getName());
        animals[1] = new Chicken("Gaga");
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if(animal instanceof Chicken){
                Edible edible = (Chicken) animal;
                System.out.println(((Chicken) animal).getName()+edible.howToEat());
        }
        }
        Fruit[] fruits = new Fruit[3];
        fruits[0] = new Orange("Tropical orange");
        fruits[1] = new Apple("South Africa apple");
        fruits[2] = new Apple("Meow Apple");
        for(Fruit fruit : fruits){
            if(fruit instanceof Orange){
                Edible edible = (Orange) fruit;
                System.out.println(((Orange) fruit).getName() + edible.howToEat());
            }else if(fruit instanceof Apple){
                Edible edible = (Apple) fruit;
                System.out.println(((Apple) fruit).getName() + edible.howToEat());
            }
        }


    }
}
