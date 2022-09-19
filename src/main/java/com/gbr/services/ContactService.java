package com.gbr.services;

import java.util.List;
import java.util.Optional;

import com.gbr.entities.Contact;

public interface ContactService{
	
	public List<Contact> getAll();
	public Optional<Contact> findById(Long id);
	public void create(Contact contact);
	public void update(Long id, Contact contact);
	public void delete(Long id);
	
}
