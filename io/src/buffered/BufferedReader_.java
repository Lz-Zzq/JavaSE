package buffered;

import java.io.BufferedReader;
                                            import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("F:\\a.txt"));
            int len = 0;
            char[] buff = new char[1024];
//            while ((len = bufferedReader.read(buff)) != -1){
//                System.out.println(new String(buff,0,len));
//            }
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            assert bufferedReader != null;
            bufferedReader.close();
        }
    }
}
