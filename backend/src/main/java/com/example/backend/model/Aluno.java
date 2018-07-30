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

	private String periodo;
	
//	private Set<Disciplina> cadeirasDesejadas;
	
	@Column(nullable = false)
	private String grade;

	public Aluno(Long matricula, String periodo,String grade) {
		this.grade = grade;
		this.matricula = matricula;
		this.periodo = periodo;
//		this.cadeirasDesejadas = new HashSet<>();
	}
	
//	public void addCadeira(Disciplina disciplina) {
//		if(!cadeirasDesejadas.contains(disciplina)) {
//			cadeirasDesejadas.add(disciplina);
//		}
//	}



	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

//	public Set<Disciplina> getCadeirasDesejadas() {
//		return cadeirasDesejadas;
//	}
//
//	public void setCadeirasDesejadas(Set<Disciplina> cadeirasDesejadas) {
//		this.cadeirasDesejadas = cadeirasDesejadas;
//	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	


}
