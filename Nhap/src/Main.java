import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        writeFile();
        readFile();
    }

    public static void writeFile() {
        File file = new File("D:\\module2\\Nhap\\file1.csv");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String name = "hello,hi,thi,hang";
            br.write(name);
            br.flush();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFile(){
        File file = new File("D:\\module2\\Nhap\\file1.csv");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

