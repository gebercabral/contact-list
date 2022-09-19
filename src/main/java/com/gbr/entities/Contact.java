package com.gbr.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="contact")
public class Contact implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String phone;
	private String email;
	
	@Column(name = "whats")
	private String whatsApp;
	
	@ManyToOne
	@ToString.Exclude
	@JsonBackReference
	@NotNull
	private Person person;
	
}
