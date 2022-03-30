import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number ");
        int number = input.nextInt();
        int count = 0;
        int N = 2;
        String result = "";
        while(count < number){

            boolean check = true;
            for( int i = 2; i < N; i++){
                if(N % i == 0){
                    check = false;
                    break;
                }

            }
            if(check){
                result += " " + N;
                count++;
            }
            N++;


        }
        System.out.println(result);
    }
}
