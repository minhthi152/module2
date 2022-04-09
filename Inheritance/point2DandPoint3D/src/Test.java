import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3,5);
        System.out.println(point2D.display());
        Point3D point3D =  new Point3D(4,6,7);
        System.out.println(point3D.display());
        point3D.setXYZ(1,2,3);
        System.out.println(Arrays.toString(point3D.getXYZ()));

    }
}
