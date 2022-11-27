package com.liu.qqserver.server;

import com.liu.qqcommon.Message;
import com.liu.qqcommon.MessageType;
import com.liu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class QQServer {

    private ServerSocket ss = null;


    //创建一个集合,存放多个用户,如果是这些用户登陆,就认为是合法的
    //这里我们也可以使用ConcurrentHashMap  HashMap没有处理线程安全,多线程不安全
    private static HashMap<String,User> validUsers = new HashMap<>();

    static { //在静态代码块,初始化 validUsers

        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("100","123456"));
        validUsers.put("300",new User("100","123456"));
        validUsers.put("至尊宝",new User("至尊宝","123456"));
        validUsers.put("紫霞仙子",new User("紫霞仙子","123456"));
        validUsers.put("菩提老祖",new User("菩提老祖","123456"));

    }

    //验证用户是否有效的方法
    private boolean checkUser(String userId,String passwd){
        User user = validUsers.get(userId);
        //说明userId没有存在validUser 的key中  或者 密码错误
        if(user ==  null || !user.getPasswd().equals(passwd)){
            System.out.println("请检查用户名和密码");
            return false;
        }
        return true;
    }

    public QQServer() {
        System.out.println("服务端在9999端口监听...");
        try {
            ss = new ServerSocket(9999);

            while (true) { //持续监听
                Socket socket = ss.accept();

                ObjectInputStream objectInputStream =
                        new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream =
                        new ObjectOutputStream(socket.getOutputStream());

                User u = (User) objectInputStream.readObject();
                //创建一个Message客户端,准备回复客户端
                Message message = new Message();


                //验证
                if(checkUser(u.getUserId(),u.getPasswd())){

                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复客户端
                    outputStream.writeObject(message);
                    //创建一个线程,和客户端保持通信,该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, u.getUserId());
                    //启动线程
                    serverConnectClientThread.start();
                    //把线程对象,放入到集合中进行管理
                    ManageClientThreads.addClientThread(u.getUserId(),serverConnectClientThread);
                }else{ //登陆失败
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    outputStream.writeObject(message);
                    //关闭socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //如果扶额u其推出了while,说明服务器不在监听,因此关闭ServerSocket
            try {
                ss.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
