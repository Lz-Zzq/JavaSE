package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //链接本机9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回 = " + socket);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] buff = new byte[1024];
        int len;
        while ((len = inputStream.read(buff)) != -1){
            System.out.println(new String(buff,0,len));
        }

        socket.shutdownInput();

        inputStream.close();
        outputStream.close();

    }
}
