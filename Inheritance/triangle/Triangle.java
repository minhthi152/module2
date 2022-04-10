public class Triangle extends Shape {
    private double side1, side2, side3;
    public Triangle(){
        side1 = 1;
        side2 = 1;
        side3 = 1;
    }

    public Triangle(String color) {
        super(color);

    }
    public void setSide(double side1, double side2, double side3) {
        if(this.side1 + this.side2 > this. side3 && this.side2 + this.side3 > this. side1 && this.side1 + this.side3 > this.side2){
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }else{
            System.out.println("Your triangle doesn't exist");
        }
    }
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    public double getArea(){
        if(this.side1 + this.side2 > this. side3
                && this.side2 + this.side3 > this. side1
                && this.side1 + this.side3 > this.side2){
            double p = getPerimeter()/2;
            return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
        }
            return -1;
    }
    @Override
    public String toString() {
        if(this.side1 + this.side2 > this. side3
                && this.side2 + this.side3 > this. side1
                && this.side1 + this.side3 > this.side2){
            return "This is a triangle with side lengths " + side1 + "cm, " + side2 + "cm, " + side3 + "cm. " +
                    "It has a perimeter of " + getPerimeter() + "cm " +
                    " and an area of " + getArea() + "cm2. "
                    + super.toString();
        }
            return "Your triangle doesn't exist";

    }
}
