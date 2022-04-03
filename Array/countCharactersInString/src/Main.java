import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = input.nextLine();

        int count = 0;
        char letter;

            System.out.println("Enter a letter: ");
            letter = input.next().charAt(0);
        for(int i = 0; i < sentence.length(); i++){
            if(letter == sentence.charAt(i)){
                count++;
            }
        }
        if(count == 0){
            System.out.printf("Letter %s is not found in the sentence!", letter);

        }else{
            System.out.printf("There %s %d letter %s in the sentence.", count == 1? "is" : "are", count, letter);
        }
        
    }
}
