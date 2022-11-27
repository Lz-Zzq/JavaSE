package com.liu.qqclient.service;

import com.liu.qqcommon.Message;
import com.liu.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 客户端链接服务器线程
 */
public class ClientConnectServerThread extends Thread {
    //该线程需要持有socket
    private Socket socket;

    //构造器可以接受一个Socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为Thread需要在后台和服务器通信,因此我们while循环
        while (true) {
            try {
                System.out.println("客户端线程,等待从读取从服务器端发送的消息");
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象,线程会阻塞在这里
                Message message = (Message) objectInputStream.readObject();
                //判断这个message类型,然后做相对应的业务处理
                //如果读取到的是服务端,返回的在线用户列表
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出在线列表信息,并显示
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("=====当前在线用户列表======");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户: " + onlineUsers[i]);
                    }
                } else {
                    System.out.println("是其他类型的message,暂时不处理6");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
