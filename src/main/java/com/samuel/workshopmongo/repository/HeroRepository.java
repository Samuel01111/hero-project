package com.samuel.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.samuel.workshopmongo.domain.Hero;

@Repository
public interface HeroRepository extends MongoRepository<Hero, String> {

	@Query("{ 'skills': { $regex: ?0, $options: 'i' } }")
	List<Hero> findBySkills(String skills);
}
