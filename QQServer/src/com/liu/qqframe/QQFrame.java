package com.liu.qqframe;

import com.liu.qqserver.server.QQServer;

/**
 * 该类创建一个QQServer对象,相当于启动一个后台的服务
 */
public class QQFrame {
    public static void main(String[] args) {
        new QQServer();
    }
}
