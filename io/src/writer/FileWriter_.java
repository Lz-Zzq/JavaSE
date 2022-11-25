package writer;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void writer(){
        FileWriter writer = null;
        File file = new File("F:\\a.txt");
        char[] chars = {'a','b','c'};
        try {
            writer = new FileWriter(file);
//            writer.write('H');
//            writer.write("h");
//            writer.write(chars);
            writer.write("韩顺平教育".toCharArray(),0,3);
            writer.write("韩顺平教育",0,3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
