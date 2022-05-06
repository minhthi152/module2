import java.io.*;

public class BinaryReadExample {
    public static void main(String[] args) {
        try {
            File file = new File("file1.txt");
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
//            byte[] param = "Hello".getBytes();
            byte[] param=new byte[]{48,101,108,108,111};
            bos.write(param);
           // bos.write("\n".getBytes());
        //    bos.write("Thi here".getBytes());
            bos.close();


//            DataOutputStream dos = new DataOutputStream(fos);
//            dos.write("Hello".getBytes());
//            dos.write("\n".getBytes());
//            dos.write("Thi here".getBytes());

//            fos.write("Hello".getBytes());
//            fos.write("\n".getBytes());
//            fos.write("Thi here".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fis = new FileInputStream("D:\\module2\\New folder\\readAndWriteBinary\\file2.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            int ch;
            while ((ch = bis.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}