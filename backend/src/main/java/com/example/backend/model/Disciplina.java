package com.example.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6497987270939165315L;

	@Id
	private Integer codigo_disciplina;

	@Column(nullable = false)
	private String disciplina;

	@Column
	private double semestre;

	@Column
	private double horas;

	@Column
	private int creditos;

	@Column
	private String grade;

	public Disciplina() {

	}

	public Disciplina(Integer codigo_disciplina, String disciplina, double semestre, double horas, int creditos,
			String grade) {
		super();
		this.codigo_disciplina = codigo_disciplina;
		this.disciplina = disciplina;
		this.semestre = semestre;
		this.horas = horas;
		this.creditos = creditos;
		this.grade = grade;
	}

	public Integer getCodigo_disciplina() {
		return codigo_disciplina;
	}

	public void setCodigo_disciplina(Integer codigo_disciplina) {
		this.codigo_disciplina = codigo_disciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public double getSemestre() {
		return semestre;
	}

	public void setSemestre(double semestre) {
		this.semestre = semestre;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

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