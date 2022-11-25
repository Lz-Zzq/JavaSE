package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //创建了DatagramSocket对象,准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //构建一个DatagramPacket对象,准备接收数据
        //在前面讲解协议时,老师说过一个数据包最大64k
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //调用方法接收, 将通网络传输的DatagramPacket对象
        //填充到packet对象
        //老师提示:当有数据包发送到本机的9999端口,就会阻塞等待.
        System.out.println("接收端A 等待接收数据...");
        socket.receive(packet);

        //可以把packet进行拆包,取出数据,
        int length = packet.getLength(); //实际接收的数据字节长度
        byte[] data = packet.getData(); //接收到数据
        String s = new String(data,0,length);
        System.out.println(s);

        byte[] buff = "好的明天见".getBytes();
        DatagramPacket packet1 = new DatagramPacket(buff,buff.length, InetAddress.getByName("YH"),9998);
        socket.send(packet1);

        socket.close();
        System.out.println("A端口退出");




    }
}
