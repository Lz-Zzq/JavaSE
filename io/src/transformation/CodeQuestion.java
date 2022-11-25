package transformation;

import org.testng.annotations.Test;

import java.io.*;

public class CodeQuestion {
    public static void main(String[] args) {

    }
    @Test
    public void reader() throws IOException  {
        String filePath = "F:\\a.txt";
        //把FileInputStream转换成BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "GBK"));
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();
    }

    @Test
    public void writer() throws IOException {
        String filePath = "F:\\a.txt";
        //把FileInputStream转换成BufferedReader

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
        bufferedWriter.write("Hi,韩顺平教育");
        bufferedWriter.close();
    }
}
