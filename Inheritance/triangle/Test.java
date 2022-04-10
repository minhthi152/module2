public class Test {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle();
        triangle1.setColor("red");
        triangle1.setSide(1,2,9);
        System.out.println(triangle1.toString());
        System.out.println(triangle1.getArea());

        Triangle triangle2 = new Triangle();
        triangle2.setColor("blue");
        triangle2.setSide(6, 8, 10);
        System.out.println(triangle2.toString());
    }
}
