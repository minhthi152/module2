public class Students {
//    static int number;
    public static String className = "C0222H1";
    public static int id = 1;
    public String name;
    public int age;
    private int studentId;

    public Students(String name, int age) {
        studentId = id++;
        this.name = name;
        this.age = age;
    }
    public void display(){
        System.out.println(className + "-" + studentId + ": " + name + " - " + age + " tuoi");
    }
//    public static void showInfo(){
//        System.out.println(className + name);
//    }
    public static void main(String[] args) {
        Students s1 = new Students("Thi", 15);
        Students s2 = new Students("Hang", 12);
        Students s3 = new Students("Ngan", 6);
        s1.display();
        s2.display();
        s3.display();
    }
    static {
        System.out.println("Static go first");
        int number = 7;
        System.out.println("Value of number: " + number);

    }


}
