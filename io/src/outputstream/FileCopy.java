package outputstream;

import org.testng.annotations.Test;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {


    }

    @Test
    public void Copy(){
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(new File("F:\\928177.jpg"));
            outputStream = new FileOutputStream(new File("F:\\928171.jpg"));
            byte[] buff = new byte[1024];
            int readLen = 0;
            while ((readLen = inputStream.read(buff)) != -1){
                //一边读一边写,读取可能会读取过多
                outputStream.write(buff,0,readLen);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            assert inputStream != null;
            assert outputStream != null;
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
