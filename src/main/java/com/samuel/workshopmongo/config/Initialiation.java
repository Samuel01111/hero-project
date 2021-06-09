package com.samuel.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.samuel.workshopmongo.domain.Hero;
import com.samuel.workshopmongo.repository.HeroRepository;
@Configuration
public class Initialiation implements CommandLineRunner {
	
	@Autowired
	private HeroRepository heroRepository;

	@Override
	public void run(String... args) throws Exception {
		
		heroRepository.deleteAll();
		
		Hero hero1 = new Hero("SMK", "Fire", 2, "Agilidade, fuga", "kdmaodkmwaowkmdaokwdma.jpg");
		Hero leo = new Hero("léu", "Water", 1, "Sabe correr", "rainbow.png");
		Hero natans = new Hero("oliveira", "Fire", 2, "Liderança, agilidade", "natan.jpg");
		
		heroRepository.saveAll(Arrays.asList(hero1, leo, natans));
		
	}
}
