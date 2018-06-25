package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 这是一个Spring的配置类，该类与spring-config.xml的作用是等效的。<p/>
 * "@Configuration"注解表示这是一个配置类，这个类中定义的bean会加载到spring容器中。
 * "@ComponentScan"用来配置哪个包中用注解标识的类会被spring自动扫描后装入bean容器，如果没有
 * 配置参数，则默认当前类所在的包及其子包中的类会被自动扫描。
 */
@Configuration
@ComponentScan(basePackages = {"aop"})
public class AopConfig {
}
