package com.wjl.test0;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by Administrator on 2018/7/13.
 */
@WebService
public class ServiceTest {

    /**
     * 对外发布的接口方法，供客户端调用。
     * @param name 字符串
     * @return 字符串
     */
    public String handler(String name) {
        return "我的名字是" + name;
    }

    public static void main(String[] args) {
        String addr = "http://127.0.0.1:9001/Service/ServiceTest";
        Endpoint.publish(addr, new ServiceTest());
        System.out.println("Service Success");
    }
}
