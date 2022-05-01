public class Bien {

    public void sayHello() {
        int n;                 // Đây là biến local
        System.out.println("Gia tri cua n la: " + n);
    }

    public static void main(String[] args) {
        Bien bienLocal = new Bien();
        bienLocal.sayHello();
        
    }
}