package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("serverSocket开始监听8888");
        Socket socket = serverSocket.accept();
        System.out.println("serverSocket监听到目标");

        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\qie.jpg");

        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buff)) != -1) {
            fileOutputStream.write(buff, 0, len);
        }

        socket.shutdownInput();

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("收到图片");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        fileOutputStream.close();
        inputStream.close();
        bufferedWriter.close();
        serverSocket.close();


    }
}
