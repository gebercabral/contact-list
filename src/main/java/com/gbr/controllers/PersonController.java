package com.gbr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gbr.entities.Person;
import com.gbr.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Person>getAll(){
		return personService.getAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Person get(@PathVariable("id")Long id) {
		return personService.findById(id)
			.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Person person) {
		personService.create(person);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable("id")Long id , @RequestBody Person person) {
		personService.update(id, person);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id")Long id) {
		 personService.findById(id)
		 	.map(person -> {
		 		personService.delete(id);
		 		return Void.TYPE;
		 	}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"));
		 
	}
}
