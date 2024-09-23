package com.appvenir.rezulab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.appvenir.rezulab.App;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class App{

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
