package com.terminalchat.chatinterminal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ChatinterminalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatinterminalApplication.class, args);
	}

	@Bean
	public ApplicationRunner logPort(Environment env) {
		return args -> {
			String port = env.getProperty("local.server.port", env.getProperty("server.port"));
			System.out.println("Application started on port: " + port);
		};
	}

}
