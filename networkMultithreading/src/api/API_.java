package api;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //根据指定主机名 获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("YH");
        System.out.println("Host1 = " + host1);

        //根据域名返回 InetAddress对象,比如www.baidu.com 对应
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("Host2 = " + host2);

        //通过InetAddress对象,获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println("Host2 对应的ip = " + hostAddress);

        //通过InetAddress 对象,获取对应主机名/域名
        String hostName = host2.getHostName();
        System.out.println("host2对应的主机名/域名 = " + hostName);
    }
}
