package com.liu.qqclient.service;

import com.liu.qqcommon.Message;
import com.liu.qqcommon.MessageType;
import com.liu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class UserClientService {
    //可能会在其他地方使用user信息
    private User u = new User();
    //因为Socket子啊其他地方也可以使用,因此作出属性"
    private Socket socket;

    //根据userId和pwd到服务器验证该用户是否合法
    public boolean checkUser(String userId, String pwd) {
        boolean b = false;
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);

        //链接到服务器,发送u对象
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            //读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                //创建一个和服务器保持通信的线程
                ClientConnectServerThread clientConnectServerThread =
                        new ClientConnectServerThread(socket);
                //启动客户端线程
                clientConnectServerThread.start();
                //这里为了后面客户端的扩展,我们将线程放入到集合管理
                ManageClientConnectServerThread.addClientConnectionServerThread(userId,clientConnectServerThread);
                b = true;

            } else {
                //如果登陆失败,我们就不能启动和服务器通信的线程,关闭socket
                socket.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    //向服务器请求在线用户列表
    public void onlineFriendList(){
        //发送一个Message,类型MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());

        //发送给服务器
        //应该得到当前线程的Socket 对应的 ObjectOutputStream对象
        try {
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectionServerThread(u.getUserId()).getSocket().getOutputStream());
            //发送一个Message对象,向服务端要求在线用户
            outputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}