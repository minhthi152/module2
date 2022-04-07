public class ShapeTest {
    public static void main(String[] args) {
        System.out.println("----Test Shape ------");
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("red", false);
        System.out.println(shape);

        System.out.println("----Test Cirle ------");
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(3.5);
        System.out.println(circle);
        circle = new Circle("black", false, 3.5);
        System.out.println(circle);

        System.out.println("---------Test Rectangle-----");
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        rectangle = new Rectangle(5,7);
        System.out.println(rectangle);
        rectangle = new Rectangle("yellow", true, 20, 50);
        System.out.println(rectangle);

        System.out.println("----------Test Square---------");
        Square square = new Square();
        System.out.println(square);
        square = new Square(5);
        System.out.println(square);
        square = new Square("blue", true, 5.2);
        System.out.println(square);



    }
}
