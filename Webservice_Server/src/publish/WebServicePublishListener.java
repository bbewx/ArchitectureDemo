/*
 * 创建 Administrator 2017-05-23 17:38
 */
package publish;

import service.WebServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

/**
 * 用于发布WebService的监听器。<p/>
 * 使用Servlet3.0提供的@WebListener注解将实现了ServletContextListener接口的
 * WebServicePublishListener类标注为一个Listener。<p/>
 * 将Web应用部署到服务器运行时，在初始化Web应用上下文时，就会发布WebService了。
 */
@WebListener
public class WebServicePublishListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //WebService的发布地址
        String address = "http://127.0.0.1:8080/WS_Server/WebService";
        //发布WebService，WebServiceImpl类是WebServie接口的具体实现类
        Endpoint.publish(address, new WebServiceImpl());
        System.out.println("使用WebServicePublishListener发布webservice成功!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
