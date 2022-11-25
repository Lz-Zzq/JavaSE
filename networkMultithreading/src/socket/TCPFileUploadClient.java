package socket;

import com.sun.xml.internal.ws.util.StreamUtils;
import org.testng.annotations.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("链接到服务端,返回 = " + socket);

        FileInputStream fileInputStream = new FileInputStream("F:\\921171.jpg");
        OutputStream outputStream = socket.getOutputStream();

        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, len);
        }

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println("服务端" + s + "开始退出");

        fileInputStream.close();
        bufferedReader.close();
        outputStream.close();
        socket.close();

    }
}
