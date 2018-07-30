package com.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "InteressadosDisciplina")
public class InteressadosDisciplina {
	@Id
	@Column(nullable = false)
	private String alunoMatricula;
	
	@Column(nullable = false)
	private int nDisciplina;
	
	public InteressadosDisciplina(String aMatricula, int nDisciplina) {
		
		this.alunoMatricula = aMatricula;
		this.nDisciplina = nDisciplina;
	}

	public String getAlunoMatricula() {
		return alunoMatricula;
	}

	public void setAlunoMatricula(String alunoMatricula) {
		this.alunoMatricula = alunoMatricula;
	}

	public int getnDisciplina() {
		return nDisciplina;
	}

	public void setnDisciplina(int nDisciplina) {
		this.nDisciplina = nDisciplina;
	}
}