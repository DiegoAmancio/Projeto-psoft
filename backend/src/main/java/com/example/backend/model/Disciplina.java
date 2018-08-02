package com.example.backend.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6497987270939165315L;

	@Id
	@Column(name = "codigo_disciplina")
	private int codigo_disciplina;

	@Column(nullable = false, name = "disciplina")
	private String disciplina;

	@Column(name = "semestre")
	private double semestre;

	@Column(name = "horas")
	private double horas;

	@Column(name = "creditos")
	private int creditos;

	@Column(name = "grade")
	private String grade;

	@OneToMany(mappedBy = "cadeiras")
	Set<Aluno> users;

	public Disciplina() {

	}

	public Disciplina(int codigo_disciplina, String disciplina, double semestre, double horas, int creditos,
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

	public void setCodigo_disciplina(int codigo_disciplina) {
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