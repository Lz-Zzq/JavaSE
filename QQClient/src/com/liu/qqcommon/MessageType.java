package com.liu.qqcommon;

/**
 * 表示消息类型有哪些
 */
public interface MessageType {
    //在接口中定义了一些常量
    //不同的常量的值表示不同的消息类型
    //表示登陆成功
    String MESSAGE_LOGIN_SUCCEED = "1";
    //表示登陆失败
    String MESSAGE_LOGIN_FAIL = "2";
    //普通信息报
    String MESSAGE_COMM_MES = "3";
    //要求返回在线用户列表
    String MESSAGE_GET_ONLINE_FRIEND = "4";
    //返回在线用户列表
    String MESSAGE_RET_ONLINE_FRIEND = "5";
    //客户端请求退出
    String MESSAGE_CLIENT_EXIT = "6";
}
