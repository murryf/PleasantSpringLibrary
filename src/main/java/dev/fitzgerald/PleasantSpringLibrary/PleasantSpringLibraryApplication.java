package dev.fitzgerald.PleasantSpringLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "dev.fitzgerald") // where to find and scan the whole code body in the dev.fitzgerald package
@EntityScan(basePackages = "dev.fitzgerald.entities") // where to scan entities
@EnableJpaRepositories(basePackages = "dev.fitzgerald.repos") //where to scan repos

public class PleasantSpringLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PleasantSpringLibraryApplication.class, args);
	}

}
