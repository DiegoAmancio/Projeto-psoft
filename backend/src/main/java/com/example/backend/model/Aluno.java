package com.example.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Aluno")
public class Aluno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String matricula;
	
	@Column(nullable = false)
	private String periodo;

}
