package com.samuel.workshopmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.samuel.workshopmongo.domain.Hero;
import com.samuel.workshopmongo.resources.util.URL;
import com.samuel.workshopmongo.service.HeroService;

@RestController
@RequestMapping(value = "/heroes")
public class HeroResource {

	@Autowired
	private HeroService service;

	@GetMapping
	public ResponseEntity<List<Hero>> findAll() {
		List<Hero> heroes = service.findAll();

		return ResponseEntity.ok().body(heroes);
	}

	@GetMapping(value = "/skillsearch")
	public ResponseEntity<List<Hero>> findBySkills(@RequestParam(value = "skill", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Hero> list = service.findBySkills(text);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Hero hero) {
		Hero obj = service.insert(hero);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getHeroName())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@GetMapping(value = "/{heroName}")
	public ResponseEntity<Hero> findByName(@PathVariable String heroName) {
		Hero obj = service.findByName(heroName);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{heroName}")
	public ResponseEntity<Void> deleteByName(@PathVariable String heroName) {
		service.deleteByName(heroName);
		return ResponseEntity.noContent().build();
	}

}
