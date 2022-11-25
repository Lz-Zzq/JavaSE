package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //链接本机9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回 = " + socket);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello server 字符流");
        //使用字符流一定记得刷新
        bufferedWriter.newLine();
        bufferedWriter.flush();


        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String len = bufferedReader.readLine();
        System.out.println(len);
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();

    }
}
