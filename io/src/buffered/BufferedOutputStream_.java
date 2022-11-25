package buffered;

import java.io.*;

public class BufferedOutputStream_ {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        String srcFilePath = "F:\\928171.jpg";
        String destFilePath = "F:\\921171.jpg";
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
            byte[] buff = new byte[1024];
            int len = 0;
            //当返回-1时,就表示文件读取完毕
            while ((len = bufferedInputStream.read(buff)) != -1) {
                bufferedOutputStream.write(buff,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bufferedOutputStream.close();
                bufferedInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
