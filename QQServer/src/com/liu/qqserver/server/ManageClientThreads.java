package com.liu.qqserver.server;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 该类用于管理和客户端通信的线程
 */
public class ManageClientThreads {
    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    //添加线程对象到hm集合
    public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread){

        hm.put(userId, serverConnectClientThread);

    }

    //根据userId 返回ServerConnectClientThread线程
    public static ServerConnectClientThread  serverConnectClientThread (String userId){
        return hm.get(userId);
    }

    //编写返回用户列表方法
    public static String getOnlineUser(){
        //集合遍历,遍历HashMap的key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()){
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }
}
