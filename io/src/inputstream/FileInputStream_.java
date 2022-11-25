package inputstream;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String filePath = "F:\\hello.txt";
        int read = 0;
        //创建FileInputStream对象,用于读取文件
        FileInputStream fileInputStream = null;
        byte[] buff = new byte[8];
        try {
            //创建FileInputStream
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节数据,如果没有输入可用,此方法将阻止.
            //如何返回-1,表示读取完毕
//            while ((read = fileInputStream.read()) != -1) {
//                //字节流读取中文会出现乱码
//                System.out.println((char) read);
//            }

            while ((read = fileInputStream.read(buff)) != -1) {
                //读取正常,返回实际读取的字节数
                //如果返回-1,读取完毕,如果读取正常,返回实际读取的字节数
                System.out.println(new String(buff,0,read));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
