package InterviewBible;

import java.io.*;

public class FileTest {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
        if (!file.exists()) {
            System.out.println(file.createNewFile());
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\test.txt"));
            bufferedWriter.write("testtest\r\n");
            bufferedWriter.write("tsettest\r\n");
            bufferedWriter.write("testtest\r\n");
            bufferedWriter.write("testtest\r\n");
            bufferedWriter.close();

        } catch (Exception exception) {
            exception.getStackTrace();
        }


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\test.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // 一次读入一行数据
                System.out.println(line);
            }
            reader.close();
        } catch (Exception exception) {
            exception.getStackTrace();
        }



/*        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\test.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = {1,15,6};
        bufferedInputStream.read(bytes);
        bufferedInputStream.close();*/
    }
}
