package buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "F:\\b.txt";
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
            bufferedWriter.write("hello,Nigger");
            bufferedWriter.newLine();
            bufferedWriter.write("hello,Nigger");
            bufferedWriter.newLine();
            bufferedWriter.write("hello,Nigger");
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            bufferedWriter.close();
        }
    }

}
