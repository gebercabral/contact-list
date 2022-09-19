package com.gbr.services;

import java.util.List;
import java.util.Optional;

import com.gbr.entities.Person;

public interface PersonService {
	
	public List<Person> getAll();
	public Optional<Person> findById(Long id);
	public void create(Person person);
	public void update(Long id, Person person);
	public void delete(Long id);
}
