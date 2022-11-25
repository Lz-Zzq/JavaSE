package outputstream;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void fileWriter(){
        File file = new File("F:\\a.txt");

        FileOutputStream fileOutputStream = null;
        try {
            //当写入内容时候会覆盖当前的内容,后方追加true,可设置为追加方式
            fileOutputStream = new FileOutputStream(file);
            //插入单个字符 char与int自动转换
            fileOutputStream.write('H');
            //插入字符串,转换为字节数组
            fileOutputStream.write("hello,world!".getBytes());
            //插入部分
            fileOutputStream.write("hello,world!".getBytes(),0,"hello.world!".length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            assert fileOutputStream != null;
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
