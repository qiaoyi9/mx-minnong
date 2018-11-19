package com.mx.minnong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.mx.minnong.mapper")
@EnableCaching
public class MinnongApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinnongApplication.class, args);
	}
}
