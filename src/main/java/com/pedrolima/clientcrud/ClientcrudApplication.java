package com.pedrolima.clientcrud;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;
import com.pedrolima.clientcrud.entities.Client;
import com.pedrolima.clientcrud.repositories.ClientRepository;

@SpringBootApplication
public class ClientcrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientcrudApplication.class, args);
	}

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Faker faker = new Faker();
		
		Client c1 = new Client(null,
				faker.harryPotter().character(),
				"513.210.250-68" ,
				7000.00,
				faker.date().birthday(18, 60).toInstant(),
				Math.toIntExact(Math.round(Math.random()*10)));
		Client c2 = new Client(null,
				faker.harryPotter().character(),
				"349.736.810-59" ,
				6500.00,
				faker.date().birthday(18, 60).toInstant(),
				Math.toIntExact(Math.round(Math.random()*10)));
		Client c3 = new Client(null,
				faker.harryPotter().character(),
				"104.924.880-53" ,
				5000.00,
				faker.date().birthday(18, 60).toInstant(),
				Math.toIntExact(Math.round(Math.random()*10)));
		Client c4 = new Client(null,
				faker.harryPotter().character(),
				"060.524.750-13" ,
				8700.00,
				faker.date().birthday(18, 60).toInstant(),
				Math.toIntExact(Math.round(Math.random()*10)));
		Client c5 = new Client(null,
				faker.harryPotter().character(),
				"513.210.250-68" ,
				10000.00,
				faker.date().birthday(18, 60).toInstant(),
				Math.toIntExact(Math.round(Math.random()*10)));
		Client c6 = new Client(null,
				faker.harryPotter().character(),
				"913.280.440-76" ,
				2525.00,
				faker.date().birthday(18, 60).toInstant(),
				Math.toIntExact(Math.round(Math.random()*10)));
		Client c7 = new Client(null,
				faker.harryPotter().character(),
				"788.164.250-59" ,
				5647.00,
				faker.date().birthday(18, 60).toInstant(),
				Math.toIntExact(Math.round(Math.random()*10)));
		Client c8 = new Client(null,
				faker.lordOfTheRings().character(),
				"505.848.760-84" ,
				3468.00,
				faker.date().birthday(18, 60).toInstant(),
				Math.toIntExact(Math.round(Math.random()*10)));
		Client c9 = new Client(null,
				faker.lordOfTheRings().character(),
				"156.158.960-86" ,
				2258.00,
				faker.date().birthday(18, 60).toInstant(),
				Math.toIntExact(Math.round(Math.random()*10)));
		Client c10 = new Client(null,
				faker.lordOfTheRings().character(),
				"032.925.450-21" ,
				1687.00,
				faker.date().birthday(18, 60).toInstant(),
				Math.toIntExact(Math.round(Math.random()*10)));
		clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
		
	}

}
