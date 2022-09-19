package com.gbr.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbr.entities.Contact;
import com.gbr.repositories.ContactRepository;
import com.gbr.services.ContactService;

@Service
public class ContactServiceImpl implements ContactService{
   
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public List<Contact> getAll() {
		return contactRepository.findAll();
	}

	@Override
	public Optional<Contact>findById(Long id) {
		return contactRepository.findById(id);
	}

	@Override
	public void create(Contact contact) {
		contactRepository.save(contact);
		
	}

	@Override
	public void update(Long id, Contact contact) {
		Contact contactBase = contactRepository.findById(id).get();
		populate(contactBase, contact);
		contactRepository.save(contactBase);
	}

	@Override
	public void delete(Long id) {
		contactRepository.deleteById(id);
		
	}
	
	private void populate(Contact contactBase, Contact contact) {
		
		if(contact.getTitle()!= null && !contact.getTitle().trim().isEmpty()) {
			contactBase.setTitle(contact.getTitle());
		}
		
		if(contact.getEmail()!= null && !contact.getEmail().trim().isEmpty()) {
			contactBase.setEmail(contact.getEmail());
		}
		
		if(contact.getPhone()!= null && !contact.getPhone().trim().isEmpty()) {
			contactBase.setPhone(contact.getPhone());
		}
		
		if(contact.getWhatsApp() != null && !contact.getWhatsApp().trim().isEmpty()) {
			contactBase.setWhatsApp(contact.getWhatsApp());
		}
	}

}
