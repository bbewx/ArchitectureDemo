/*
 * 创建 Administrator 2017-05-23 19:37
 */
package com.wjl.test1.publish;

import com.wjl.test1.service.WebServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.xml.ws.Endpoint;

/**
 * 用于发布WebService的Servlet。<p/>
 * 使用Servlet3.0提供的@WebServlet注解将继承HttpServlet类的普通Java类标注为一个Servlet。
 * 将value属性设置为空字符串，这样WebServicePublishServlet就不提供对外访问的路径。
 * loadOnStartup属性设置WebServicePublishServlet的初始化时机。
 */
@WebServlet(value="",loadOnStartup=0)
public class WebServicePublishServlet extends HttpServlet {

    /* (non-Javadoc)
    * @see javax.servlet.GenericServlet#init()
    * 在WebServicePublishServlet初始化时发布WebService
    */
    @Override
    public void init() throws ServletException {
        //WebService的发布地址
        String address = "http://127.0.0.1:8888/WebService";
        //发布WebService，WebServiceImpl类是WebServie接口的具体实现类
        Endpoint.publish(address, new WebServiceImpl());
        System.out.println("使用WebServicePublishServlet发布webservice成功!");
    }
}
