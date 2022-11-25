package file;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {


    }

    @Test
    void create01() {
        String filePath = "F:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void create02(){
        String fileName = "news2.txt";
        File file = new File("F:\\");
        File file1 = new File(file, fileName);
        try {
            file1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
