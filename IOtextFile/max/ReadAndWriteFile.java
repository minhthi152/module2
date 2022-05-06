import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();

            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine())!=null){
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File does not exist or contains inappropriate content!");
            e.printStackTrace();
        }


        return numbers;
    }
//    Tạo phương thức writeFile trong lớp ReadAndWriteFile
//    để ghi giá trị lớn nhất cần tìm vào trong File
    public void writeFile(String filePath, int max){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter br = new BufferedWriter(writer);
            br.write("Max value is: " + max);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//Tạo lớp FindMaxValue và tạo phương thức
// findMax với đối số là một List<Integer>
    public static int findMax(List<Integer> numbers){
        int max = numbers.get(0);
        for(int i = 1; i < numbers.size(); i++){
            if(max < numbers.get(i)){
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile file1 = new ReadAndWriteFile();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a file path: ");
        String filePath = input.nextLine();
        List<Integer> numbers = file1.readFile(filePath);
        int max = findMax(numbers);
        file1.writeFile(filePath, max);

    }
}
