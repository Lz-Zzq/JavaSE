package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //在本机9999端口监听,等待链接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端9999端口等待接听");

        //当没有客户端接收9999端口,程序会阻塞
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());

        //通过socket.getInputStream() 读取客户端写入到数据通道数据,显示
        InputStream inputStream = socket.getInputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buff)) != -1) {
            System.out.println(new String(buff, 0, len));
        }
        socket.shutdownInput();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("已经收到,谢谢".getBytes());
        socket.shutdownOutput();
        //关闭流与socket
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();


    }
}
