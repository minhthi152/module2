public class Test {
    public static void main(String[] args) {
        Point a = new Point(3.5f,7.5f);
        System.out.println(a.toString());

        MovablePoint b = new MovablePoint(4.5f, 6.4f, 5f, 7.5f);
        System.out.println(b.toString());
        b.move();
        System.out.println(b.toString());
        b.move();

        System.out.println(b.toString());
        b.move();
        System.out.println(b.toString());

    }
}
