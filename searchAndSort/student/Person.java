package student;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private float weight;

    public Person(String name, int age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public static Person[] getPersons() {

        Person person1 = new Person("Johnny", 12, 18.9f);
        Person person2 = new Person("Timmy", 12, 18.9f);
        Person person3 = new Person("Katy", 7, 22.5f);
        Person person4 = new Person("Henderson", 33, 77f);
        Person person5 = new Person("Pitchfork", 12, 55.5f);
        Person person6 = new Person("Spitzitout", 70, 60.2f);
        Person person7 = new Person("Elphonso", 54, 54.5f);
        Person person8 = new Person("Peterson", 27, 45.5f);
        Person person9 = new Person("Oceandew", 18, 58.4f);
        Person person10 = new Person("Kyle", 6, 15f);
        Person[] persons = {person1, person2, person3, person4, person5, person6, person7, person8, person9, person10};

        return persons;
    }

    public static void main(String[] args) {
    }

    @Override
    public int compareTo(Person o) {

        return this.name.compareTo(o.getName());
//        int result = this.age - o.age;
//        if (result != 0)
//            return result;
//        result = Double.compare(this.weight, o.weight);
//        if (result != 0)
//            return result;
//        return this.name.compareTo(o.name);

//        int resultAge = this.age - o.age;
//        if (resultAge == 0) {
//            int resultWeight =Double.compare(this.weight,o.weight)  ;
//            if (resultWeight == 0) {
//                return this.name.compareTo(o.name);
//            }
//            return resultWeight;
//        }
//        return resultAge;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }


    public class BinarySearch {
        public static int binarySearch(Person[] arr, String name) {
            int low = 0, high = arr.length - 1;
            System.out.println(high);
            while (high >= low) {
                int mid = (low + high) / 2;
                System.out.println(mid);
                if (name.compareTo(arr[mid].getName())==0) {
                    return mid;

                } else if (name.compareTo(arr[mid].getName())>0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            binarySearch(Person[] persons,"Timmy");
        }
    }


}