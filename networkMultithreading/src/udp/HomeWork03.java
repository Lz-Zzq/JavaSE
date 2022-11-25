package udp;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HomeWork03 {
    public static void main(String[] args) {

    }

    @Test
    public void server() throws Exception {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        socket.receive(datagramPacket);

        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);

        FileInputStream fileInputStream = new FileInputStream("F:\\qit.txt");

        if (!"高山流水".equals(s)) {
            System.out.println("没有");
        }

        byte[] bytes1 = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes1)) != -1){

        }


        DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length,InetAddress.getByName("YH"),9998);
        socket.send(datagramPacket1);

        socket.close();



    }


    @Test
    public void client() throws Exception {
        DatagramSocket socket = new DatagramSocket(9998);
        System.out.println("请输入您需要下载的音乐: ");

//        Scanner scanner = new Scanner(System.in);
        String next = "高山流水";
        byte[] buf = next.getBytes();

        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName("YH"), 9999);
        socket.send(datagramPacket);


        socket.receive(datagramPacket);

        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        socket.close();



    }
}
