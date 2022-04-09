public class Cylinder extends Circle {
    public double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    //    public Cylinder(double height) {
//        this.height = height;
//    }

//    public Cylinder(double radius, String color, double height) {
//        super(radius, color);
//        this.height = height;
//    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return super.getArea() * getHeight();
    }

    @Override
    public String toString() {
        return "A cylinder has a Volume of " +getVolume() + " is a subclass of "+ super.toString();
    }
}
