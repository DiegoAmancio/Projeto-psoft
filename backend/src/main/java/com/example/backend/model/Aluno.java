package com.example.backend.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy = "aluno_matricula")
	private Set<InteressadosDisciplina> cadeirasInteressadas;
	
	public Aluno() {
		
	}
	public Aluno(String matricula, String periodo,String grade) {
		
		this.matricula = matricula;
		this.periodo = periodo;
		this.grade = grade;
		this.cadeirasInteressadas = new HashSet<>();
	}
	public boolean addCadeira(InteressadosDisciplina disciplina) {
		if(!cadeirasInteressadas.contains(disciplina)) {
			cadeirasInteressadas.add(disciplina);
			return true;
		}
		return false;
	}
	
	public Set<InteressadosDisciplina> getCadeirasInteressadas() {
		return cadeirasInteressadas;
	}
	public void setCadeirasInteressadas(Set<InteressadosDisciplina> cadeirasInteressadas) {
		this.cadeirasInteressadas = cadeirasInteressadas;
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