package com.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 根类。<p/>
 * "@SpringBootApplication"解决根类头上配置太多的问题。相当于@SpringBootConfiguration，
 * "@EnableAutoConfiguration，@ComponentScan"的集合，并具有默认属性。
 */
//@RestController
@SpringBootApplication
public class SpringbootDemoApplication {

//    @RequestMapping("/")
//	String index() {
//	    return "Hello Springboot";
//    }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}
