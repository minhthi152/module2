public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan(){
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
//    public void setOn(boolean on){
//        this.on = on;
//    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }
//    public int getSpeed(){
//        return this.speed;
//    }
//    public boolean getOn(){
//        return this.on;
//    }
//    public double getRadius(){
//        return this.radius;
//    }
//    public String getColor(){
//       return this.color;
//    }

    public String toString(){
        if(this.on){
            return  "Fan is on, speed = " + this.speed + ", color = " + this.color + ", radius = " + this.radius;
        }
            return  "Fan is off, color = " + this.color + ", radius = " + this.radius;
    }


}
