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

import com.gbr.entities.Contact;
import com.gbr.services.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	private List<Contact>getAll(){
		return contactService.getAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	private Contact get(@PathVariable("id")Long id) {
		return contactService.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void create(@RequestBody Contact contact) {
		contactService.create(contact);
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable("id")Long id , @RequestBody Contact contact) {
		contactService.update(id, contact);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id")Long id) {
		 contactService.findById(id)
		 	.map(contact -> {
		 		contactService.delete(id);
		 		return Void.TYPE;
		 	}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
		 
	}
}
