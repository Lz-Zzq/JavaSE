package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //在本机9999端口监听,等待链接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端9999端口等待接听");

        //当没有客户端接收9999端口,程序会阻塞
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());

        //通过socket.getInputStream() 读取客户端写入到数据通道数据,显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = bufferedReader.readLine();
        System.out.println(str);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("已经收到,谢谢 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //关闭流与socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();


    }
}
