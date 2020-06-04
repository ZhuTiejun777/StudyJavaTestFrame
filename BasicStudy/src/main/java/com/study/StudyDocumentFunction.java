package com.study;

import java.io.*;


/**
 * FileReader、InputStreamReader、BufferedReader读写文件方法
 */

public class StudyDocumentFunction {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        // file(内存)----输入流---->【程序】----输出流---->file(内存)
        File file = new File("d:/temp", "addfile.txt");
        try {
            file.createNewFile(); // 创建文件
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 向文件写入内容(输出流)
        String str = "亲爱的小南瓜！";
        byte bt[] = new byte[1024];
        bt = str.getBytes();
        try {
            FileOutputStream in = new FileOutputStream(file);
            try {
                in.write(bt, 0, bt.length);
                in.close();
                // boolean success=true;
                // System.out.println("写入文件成功");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            // 读取文件内容 (输入流)
            FileInputStream out = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(out);
            int ch = 0;
            while ((ch = isr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        try{
            // 实例化File类
            File file2 = new File("filename.txt");
            if(!file2.exists()){
                file2.createNewFile();
            }
            // 实例化PrintWriter类
            PrintWriter pw = new PrintWriter(file2);
            // 写入文件
            pw.println("这是一个测试文件");
            pw.println(1234567);
            pw.close();
            System.out.println("完成");
        } catch (IOException e){
            e.printStackTrace();
        }

        // 读取文件操作
        FileReader fr = new FileReader("filename.txt");
        int ch = 0;
        while((ch = fr.read())!=-1 ) {
            System.out.print((char) ch);
        }
        // 读取文件操作
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ming.txt")));
        String data = null;
        while((data = br.readLine())!=null) {
            System.out.println(data);
        }

        // 写入操作,定义缓冲流变量
        BufferedReader br1 = null;
        try{
            // 实例化BufferedReader类
            // new FileReader("filename.txt")输入要写入的文件路径
            // FileReader fr3 = new FileReader("filename.txt");
            br1 = new BufferedReader(new FileReader("filename.txt"));
            String line;
            // 进行读的操作br1.readLine()
            while((line = br1.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}


