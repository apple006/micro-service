package com.itliusir.micro;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 使用@ServletComponentScan 注解后，Listener 可以直接通过@WebListener
 * 注解自动注册，无需其他代码。
 * */
@ServletComponentScan
@Configuration
@SpringBootApplication
public class MicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}
}
