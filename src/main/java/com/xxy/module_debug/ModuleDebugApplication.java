package com.xxy.module_debug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//打开注解会自动扫描到定时器
//@EnableScheduling
@SpringBootApplication
public class ModuleDebugApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleDebugApplication.class, args);
	}

}
