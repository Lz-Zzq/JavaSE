package com.liu.qqclient.service;

import java.util.HashMap;

/**
 * 该类管理客户端链接到服务器的线程类
 */
public class ManageClientConnectServerThread {
    //我们把多个线程放入到HashMap集合中,key 就是用户id,value 就是一个线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程加入到集合
    public static void addClientConnectionServerThread(String userId,ClientConnectServerThread clientConnectServerThread){
        hm.put(userId,clientConnectServerThread);
    }

    //通过userId可以得到对应线程
    public static ClientConnectServerThread getClientConnectionServerThread(String userId){
        return hm.get(userId);
    }

}
