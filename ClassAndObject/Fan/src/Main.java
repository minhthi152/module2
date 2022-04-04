public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        System.out.println(fan1.toString());

        Fan fan2 = new Fan();
        fan1.setOn(false);
        fan1.setRadius(5);
        fan1.setColor("white");
        System.out.println(fan2.toString());
    }
}
