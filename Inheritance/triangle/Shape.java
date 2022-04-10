public class Shape {
protected String color;
public Shape(){

}

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "It is filled with " + this.color;
    }
}
