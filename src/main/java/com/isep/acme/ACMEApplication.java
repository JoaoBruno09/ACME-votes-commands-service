package com.isep.acme;

import com.isep.acme.rabbit.RpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

@SpringBootApplication
@EntityScan("com.isep.acme.model")
public class ACMEApplication {

	@Autowired
	private RpcClient rpcClient;
	public static void main(String[] args) {
		SpringApplication.run(ACMEApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady(ApplicationReadyEvent event) throws Exception {
		rpcClient.getProducts();
	}
	@Bean
	public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
		return new BufferedImageHttpMessageConverter();
	}
}
