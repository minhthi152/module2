package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVUtils {
    public static <T> void write(String path, List<T> items){
        try {
            PrintWriter pw = new PrintWriter(path);
            for (Object item: items) {
                pw.println(item.toString());
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path + "invalid");
        }
    }

    public static List<String> read(String path){
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new IllegalArgumentException(path + "invalid");
        }
    }
}
