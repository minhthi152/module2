import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 1;
        int N = 2;
        String result = "";
        while(count < 100){

            boolean check = true;
            for( int i = 2; i < N; i++){
                if(N % i == 0){
                    check = false;
                    break;
                }

            }
            if(check){
                result += " " + N;

            }
            count++;
            N++;


        }
        System.out.println(result);
    }
}

