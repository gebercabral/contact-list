package com.gbr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbr.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
