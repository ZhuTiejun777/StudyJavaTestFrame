package LittlePractice;

import java.io.*;

public class Test17 {

    static String readFile = "C:\\Users\\Administrator\\Desktop\\KWL000SN_KWL00028_20201105_1.txt";
    static String wirteFile = "C:\\Users\\Administrator\\Desktop\\KWL000SN_KWL00028_20201106_7.txt";
    public static void main(String[] args) throws IOException {
        /*FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;*/
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            /*fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream);*/
            fileReader = new FileReader(readFile);
            bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter(wirteFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            String string = null;
            // 读取文件内容，并将其打印
            while((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
                bufferedWriter.write(string + "|1|1\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
