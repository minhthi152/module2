import java.util.Comparator;
import java.util.Objects;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge() > o2.getAge()){
            return 1;
        }else if(Objects.equals(o1.getAge(), o2.getAge())){
            return 0;
        }
        return -1;
    }
}
