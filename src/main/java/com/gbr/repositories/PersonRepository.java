package com.gbr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbr.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
