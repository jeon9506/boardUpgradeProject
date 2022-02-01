package com.basic.boardUpgradeProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardUpgradeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardUpgradeProjectApplication.class, args);
	}

}