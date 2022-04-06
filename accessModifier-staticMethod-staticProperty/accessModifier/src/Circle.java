public class Circle {
    private double radius = 1;
    private String color = "red";
    Circle(){

    }
    Circle(double radius){
        this.radius = radius;

    }
    protected double getRadius(){
        return this.radius;
    }
     double getArea(){
        return Math.PI * Math.pow(this.radius, 2);

    }
}
