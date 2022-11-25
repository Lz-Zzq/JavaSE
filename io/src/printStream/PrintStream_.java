package printStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

//字节打印流
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        out.println("Hello");
        out.write("heloo".getBytes());
        //修改输出位置
        System.setOut(new PrintStream("F:\\F1.txt"));

        System.out.println("helooHf;laksjdhpoiwe");
        out.close();
    }
}
class PrintWriter_{
    public static void main(String[] args) throws Exception{
//        PrintWriter p = new PrintWriter(new FileWriter("F:\\F2.txt"));
        PrintWriter p = new PrintWriter(new FileWriter("F:\\F2.txt"));
        p.println("ninini");
        p.write("Hi,你好北京");
        p.close();
    }
}
