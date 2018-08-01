package com.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "InteressadosDisciplina")
public class InteressadosDisciplina {
	@Id
	private String matriculaDisciplina;
	@Column(nullable = false)
	private String aluno_matricula;

	@Column(nullable = false)
	private Integer n_disciplina;

	public InteressadosDisciplina() {

	}

	public InteressadosDisciplina(String aluno_matricula, Integer n_disciplina) {

		this.aluno_matricula = aluno_matricula;
		this.n_disciplina = n_disciplina;
		this.matriculaDisciplina = aluno_matricula + n_disciplina;
	}

	public String getAluno_matricula() {
		return aluno_matricula;
	}

	public void setAluno_matricula(String aluno_matricula) {
		this.aluno_matricula = aluno_matricula;
	}

	public Integer getN_disciplina() {
		return n_disciplina;
	}

	public void setN_disciplina(Integer n_disciplina) {
		this.n_disciplina = n_disciplina;
	}

}