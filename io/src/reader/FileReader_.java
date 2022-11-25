package reader;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    /*
    字符读取文字
     */
    @Test
    public void reader() {
        String filePath = "F:\\a.txt";
        FileReader fileReader = null;
        int data = 0;
        //1.创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert filePath != null;
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /*
    字符数组读取文件
     */
    @Test
    public void readFile02() {
        String filePath = "F:\\a.txt";
        FileReader fileReader = null;
        int data = 0;
        //1.创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取
            char[] buff = new char[1024];
            while ((data = fileReader.read(buff)) != -1) {
                System.out.print(new String(buff, 0, data));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert filePath != null;
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
