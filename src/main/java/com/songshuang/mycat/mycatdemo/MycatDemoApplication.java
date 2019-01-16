package com.songshuang.mycat.mycatdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.songshuang.mycat.mycatdemo.dao.repository")
public class MycatDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycatDemoApplication.class, args);
	}

}

