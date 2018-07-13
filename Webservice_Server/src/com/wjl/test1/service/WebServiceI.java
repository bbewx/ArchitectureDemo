package com.wjl.test1.service;/*
 * 创建 Administrator 2017-05-23 17:21
 */

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 定义SEI(WebService EndPoint Interface(终端))。<p/>
 * 使用@WebService注解标注WebServiceI接口。
 */
@WebService
public interface WebServiceI {
    @WebMethod
    String sayHello(String name);

    @WebMethod
    String save(String name,String pwd);
}
