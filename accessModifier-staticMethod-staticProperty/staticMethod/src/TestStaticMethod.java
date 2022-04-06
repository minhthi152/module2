public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student s1 = new Student(111, "Thi");
        Student s2 = new Student(222, "Ngan");
        Student s3 = new Student(333, "Hang");
        s1.display();
        s2.display();
        s3.display();

    }
}
