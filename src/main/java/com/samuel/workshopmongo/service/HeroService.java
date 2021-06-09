package com.samuel.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuel.workshopmongo.domain.Hero;
import com.samuel.workshopmongo.repository.HeroRepository;
import com.samuel.workshopmongo.service.exceptions.ObjectNotFoundException;
@Service
public class HeroService {
	
	@Autowired
	private HeroRepository repo;
	
	public List<Hero> findAll() {
		return repo.findAll();
	}
	public Hero findByName(String heroName) {
		Optional<Hero> user = repo.findById(heroName);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));

	}
	public List<Hero> findBySkills(String txt) {
		return repo.findBySkills(txt);
	}
	
	public Hero insert(Hero hero) {
		return repo.insert(hero);
	}
	
	public void deleteByName(String heroName) {
		findByName(heroName);
		repo.deleteById(heroName);
	}

}
