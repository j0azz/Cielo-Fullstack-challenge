package com.example.cielo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.cielo", "com.example.cielo.config"})
public class CieloApplication {

	public static void main(String[] args) {
		SpringApplication.run(CieloApplication.class, args);
	}

}
