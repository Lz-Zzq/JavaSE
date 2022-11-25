package udp;

import java.net.*;

public class UDPSenderB {
    public static void main(String[] args) throws Exception {
        //创建DatagramSocket对象 准备在9998端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        //将需要发送的数据,封装到DatagramPacket对象
        byte[] data = "hello,明天吃火锅".getBytes();
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("YH"), 9999);

        socket.send(packet);

        byte[] da = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(da, da.length);
        socket.receive(datagramPacket);

        int length = datagramPacket.getLength();
        byte[] data1 = datagramPacket.getData();
        System.out.println(new String(data1,0,length));

        //关闭资源
        socket.close();
        System.out.println("B端退出");


    }
}
