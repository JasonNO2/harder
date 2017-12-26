package org.jason;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
@MapperScan("org.jason.mapper")
public class SampleApplication {
	private static final Logger logger = LogManager.getLogger(SampleApplication.class);
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SampleApplication.class);
	}
	public static void main(String[] args) {
		System.setProperty("log_dir", System.getProperty("user.dir"));
		logger.info("程序启动");
		SpringApplication.run(SampleApplication.class, args);
	}
}
