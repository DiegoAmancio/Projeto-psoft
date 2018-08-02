package com.example.backend.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@Column(name = "matricula")
	private String matricula;

	@Column(nullable = false, name = "nome_completo")
	private String nome;

	@Column(nullable = false, name = "grade")
	private String grade;

	@Column(nullable = false, name = "email")
	private String email;

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY) 
	@JoinColumn(name = "cadeiras_aluno")
	private Set<Disciplina> cadeiras;

	public Aluno() {

	}

	public Aluno(String matricula, String nome, String grade, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.grade = grade;
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	
	public Set<Disciplina> getCadeiras() {
		return cadeiras;
	}

	public void setCadeiras(Set<Disciplina> cadeiras) {
		this.cadeiras = cadeiras;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}