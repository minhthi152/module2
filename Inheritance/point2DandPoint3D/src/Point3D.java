public class Point3D extends Point2D{
public float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }
    public float getZ() {
        return z;
    }
    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public float[] getXYZ(){
        return new float[]{getX(), getY(), getZ()};
    }

    @Override
    public String display() {
        return "(" + getX() + ";" + getY() + ";" + getZ() + ")" ;
    }
}
