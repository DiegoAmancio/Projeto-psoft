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
	private Long alunoMatricula;
	
	@Column(nullable = false)
	private int nDisciplina;
	

	public InteressadosDisciplina(Long alunoMatricula, int nDisciplina) {

		this.alunoMatricula = alunoMatricula;
		this.nDisciplina = nDisciplina;
	}
	
	public Long getAlunoMatricula() {
		return alunoMatricula;
	}

	public void setAlunoMatricula(Long alunoMatricula) {
		this.alunoMatricula = alunoMatricula;
	}

	public int getnDisciplina() {
		return nDisciplina;
	}

	public void setnDisciplina(int nDisciplina) {
		this.nDisciplina = nDisciplina;
	}
}