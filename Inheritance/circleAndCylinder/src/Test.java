public class Test {
    public static void main(String[] args) {
        System.out.println("-----Test Circle-----");
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(5,"red");
        System.out.println(circle);

        System.out.println("-------Test Cylinder-----");
        Cylinder cylinder = new Cylinder(5);
        System.out.println(cylinder);
        cylinder = new Cylinder(10, "green", 10);
        System.out.println(cylinder);
    }

}
