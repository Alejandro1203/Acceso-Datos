package org.example.springapirest;

import org.example.springapirest.model.Manufacturer;
import org.example.springapirest.repository.ManufacturerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringApiRestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringApiRestApplication.class, args);
		var repo = context.getBean(ManufacturerRepository.class);

		repo.save(new Manufacturer( "manufacturer1", 1000, 1990));
	}

}
