package com.liu.qqserver.server;

import com.liu.qqcommon.Message;
import com.liu.qqcommon.MessageType;
import sun.java2d.loops.TransformHelper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId; //连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() { //这里线程处于run的状态,可以发送/接收消息
        while (true) {
            try {
                System.out.println("服务端和客户端" + userId + "保持通信,读取数据:");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用Message 根据message的类型,做响应的业务处理
                if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    System.out.println(message.getSender() + "在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回message
                    //构建一个Message对象,返回给客户端
                    Message message1 = new Message();
                    message1.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(onlineUser);
                    message1.setGetter(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
