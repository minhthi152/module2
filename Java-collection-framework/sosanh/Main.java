import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Thi", 24, "Hue");
        Student s2 = new Student("Hang", 30, "Da Nang");
        Student s3 = new Student("Ngan", 26, "Ha Noi");
        Student s4 = new Student("Triet", 27, "Sai Gon");

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        System.out.println("Before sorting: ");
        for (Student s: studentList) {
            System.out.println(s.toString());
        }

        Collections.sort(studentList);
        System.out.println("After sorting by name: ");
        for (Student s: studentList) {
            System.out.println(s.toString());
        }
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(studentList,ageComparator);
        System.out.println("After sorting by age: ");
        for (Student s: studentList) {
            System.out.println(s.toString());
        }

    }
}
