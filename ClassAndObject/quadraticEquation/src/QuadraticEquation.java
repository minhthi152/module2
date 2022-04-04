public class QuadraticEquation {
    private double a, b, c;

    //Constructor
    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }
    public double getDiscriminant(){
        double delta = this.b * this.b - 4 * this.a * this.c;
        return delta;
    }
    public double getRoot1(){
        double r1 = (- this.b + Math.pow((this.getDiscriminant()), 0.5))/(2*this.a);
        return r1;
    }
    public double getRoot2(){
        double r2 = (- this.b - Math.pow((this.getDiscriminant()), 0.5))/(2*this.a);
        return r2;
    }
    public double getDoubleRoot(){
        return (- this.b)/(2 * this.a);
    }


}
