import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your number: ");
        Scanner scanner = new Scanner(System.in);
        int num123;
        num123 = scanner.nextInt();
        int num1 = num123 / 100;
        int num23 = num123 % 100;
        int num2 = num23 / 10;
        int num3 = num23 % 10;
        String words = "";
        String words2 = "";

//        words = getWords(num1, words) + "hundred and ";
        switch(num2){
            case 0:
                words2 = "";
                break;
            case 1:
                switch(num3){
                    case 0:
                        words2 = "Ten";
                        break;
                    case 1:
                        words2 = "Eleven";
                        break;
                    case 2:
                        words2 = "Twelve ";
                        break;
                    case 3:
                        words2 = "Thirteen ";
                        break;
                    case 4:
                        words2 = "Fourteen ";
                        break;
                    case 5:
                        words2 = "Fifteen ";
                        break;
                    case 6:
                        words2 = "Sixteen ";
                        break;
                    case 7:
                        words2 = "Seventeen ";
                        break;
                    case 8:
                        words2 = "Eighteen ";
                        break;
                    case 9:
                        words2 = "Nineteen ";
                        break;
                }

                break;
            case 2:
                words2 = "Twenty ";
                break;
            case 3:
                words2 = "Thirty ";
                break;
            case 4:
                words2 = "Forty ";
                break;
            case 5:
                words2 = "Fifty ";
                break;
            case 6:
                words2 = "Sixty ";
                break;
            case 7:
                words2 = "Seventy ";
                break;
            case 8:
                words2 = "Eighty ";
                break;
            case 9:
                words2 = "Ninety ";
                break;
        }
        if(num123 < 0 || num123 >=1000){
            System.out.println("Out of number");
        }
        else if(num123 >= 0 && num123 <=9){
            System.out.println(getWords(num3,words));
        }else if(num123 == 10){
            System.out.println("Ten");

        }else if(num123 > 10 && num123 <=19){
            System.out.println(words2);

        }else if(num123 >=20 && num123 <= 99){
            words = words2 + getWords(num3, words);
            System.out.println(words);
        }else if(num123 >=100 && num2 == 1){
            words = getWords(num1, words) + "Hundred And " + words2;
            System.out.println(words);
        }
        else{
            words =  getWords(num1, words) + "Hundred And " + words2 + getWords(num3, words);
            System.out.println(words);
        }

    }

    private static String getWords(int num, String words) {
        switch (num) {
            case 0:
                words = "Zero ";
                break;
            case 1:
                words = "One ";
                break;
            case 2:
                words = "Two ";
                break;
            case 3:
                words = "Three ";
                break;
            case 4:
                words = "Four ";
                break;
            case 5:
                words = "Five ";
                break;
            case 6:
                words = "Six ";
                break;
            case 7:
                words = "Seven ";
                break;
            case 8:
                words = "Eight ";
                break;
            case 9:
                words = "Nine ";
                break;
        }
        return words;
    }

}
