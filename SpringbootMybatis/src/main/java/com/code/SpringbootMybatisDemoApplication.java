package com.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 配置根类。<p/>
 *
 * "@EnableTransactionManagement"注解表示开启事务管理工作，这样spring会扫描项目中的
 * "@Transaction"注解（一般在Service类中）。
 */
@SpringBootApplication
@EnableTransactionManagement
public class SpringbootMybatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisDemoApplication.class, args);
	}
}
