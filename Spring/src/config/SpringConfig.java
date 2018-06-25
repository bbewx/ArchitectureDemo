package config;

import aop.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 这是一个Spring的配置类，该类与spring-config.xml的作用是等效的。<p/>
 *
 * "@Configuration"注解表示这是一个配置类，这个类中定义的bean会加载到spring容器中。<br/>
 *
 * "@ComponentScan"用来配置哪个包中用注解标识的类会被spring自动扫描后装入bean容器，如果没有
 * 配置参数，则默认当前类所在的包及其子包中的类会被自动扫描。等效于XML中的：
 * <context:component-scan base-package="aop"></context:component-scan><br/>
 *
 * "@EnableAspectJAutoProxy"声明自动为spring容器中那些配置@aspectJ切面的bean创建代理，
 * 等效于XML中的：
 * <aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy><br/>
 *
 * "@ImportResource"如果采用java与xml的混合配置模式，则采用该注解导入xml配置文件。
 */
@Configuration
@ComponentScan(basePackages = {"aop"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@ImportResource({"classpath:spring-config.xml"})
public class SpringConfig {

    @Autowired
    public SpringConfig(Bicycle b) {
        b.setName("美利达");
    }
}
