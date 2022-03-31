import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] students = {"Christian", "Micheal", "Thi", "Marco", "Phil", "Alex", "Kiersten"};
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name's student: ");
        String input_name = input.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length; i++){
            if (students[i].equals(input_name)){
                System.out.println("Position of "+ input_name +" in the list is: " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist){
            System.out.println("Not found" + input_name + " in the list");
        }

    }
}
