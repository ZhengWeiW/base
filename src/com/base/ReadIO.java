package com.base;

import java.io.*;

public class ReadIO {
    public static void main(String[] args) throws FileNotFoundException {
        File destinationFile = new File("C:\\Users\\zhengww\\Desktop\\ES\\315050.txt");
        InputStream fis = new FileInputStream("C:\\Users\\zhengww\\Desktop\\ES\\315050_20240606.log");


        BufferedOutputStream bufferedOutputStream = null;
        try {
            // 创建输入流读取源文件内容
            // 创建输出流将内容追加到目标文件末尾
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationFile, true));
            // 追加文件内容
            //int bytesRead;
            int charsRead;
            byte[] buffer = new byte[1024 * 10];
            while ((charsRead = fis.read(buffer)) != -1) {
                System.out.printf("-----------"+fis);
                bufferedOutputStream.write(buffer, 0, charsRead);
            }
            bufferedOutputStream.flush();
        } catch (IOException e) {


        } finally {
            // 关闭流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
