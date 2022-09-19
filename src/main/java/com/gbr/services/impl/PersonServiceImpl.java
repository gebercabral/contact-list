package com.gbr.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbr.entities.Contact;
import com.gbr.entities.Person;
import com.gbr.repositories.ContactRepository;
import com.gbr.repositories.PersonRepository;
import com.gbr.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	@Override
	public Optional<Person> findById(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public void create(Person person) {
		personRepository.save(person);
		
		for(Contact contact :person.getContacts()) {
			contact.setPerson(person);
		}
		if(person.getContacts().size() > 0)
			contactRepository.saveAll(person.getContacts());
	}

	private void populate(Person personBase, Person person) {
		
		if(person.getName()!= null && !person.getName().trim().isEmpty()) {
			personBase.setName(person.getName());
		}
		
		if(person.getNickName()!= null && !person.getNickName().trim().isEmpty()) {
			personBase.setNickName(person.getNickName());
		}
		
		 personBase.getContacts().clear();
		    
	    for(Contact contact :person.getContacts()) {
			contact.setPerson(personBase);
		}
	    
	    personBase.getContacts().addAll(person.getContacts());
	}
	
	@Override
	public void update(Long id ,Person person) {
		Person personBase = personRepository.findById(id).get();
		
		populate(personBase, person);
		
		personRepository.save(personBase);
		
	}

	@Override
	public void delete(Long id) {
		personRepository.deleteById(id);
	}

	
}
