package com.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno{

	@Id
	private String matricula;
	
	@Column(nullable = false)
	private String periodo;
	
	@Column(nullable = false)
	private String grade;
	public Aluno() {
		
	}
	public Aluno(String matricula, String periodo,String grade) {
		
		this.matricula = matricula;
		this.periodo = periodo;
		this.grade = grade;
	}
	
	public String getPeriodo() {
		return periodo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}



}