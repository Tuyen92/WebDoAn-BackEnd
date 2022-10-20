package com.demo.WebKhoaLuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class WebKhoaLuanApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebKhoaLuanApplication.class, args);
	}

}
