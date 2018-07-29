package com.example.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Disciplina")
public class Disciplina implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6497987270939165315L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDisciplina;
	
	@Column(nullable = false)
	private String nomeDisciplina;
	
	@Column(nullable = false)
	private int cargaHoraria;
	
	@Column(nullable = false)
	private int creditos;
	
	@Column(nullable = false)
	private String grade;
	
	@Column(nullable = false)
	private int numeroCadastrados;
	
	
	public Disciplina(String nomeDisciplina, int cargaHoraria,String grade) {
		
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
		this.creditos = cargaHoraria / 4 ;
		this.grade = grade;
		this.numeroCadastrados = 0;
	}
	public void maisUmAluno() {
		this.numeroCadastrados += 1;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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

	public void setGrade(String gradeNova) {
		this.grade = gradeNova;
	}

	public int getNumeroCadastrados() {
		return numeroCadastrados;
	}

	public void setNumeroCadastrados(int numeroCadastrados) {
		this.numeroCadastrados = numeroCadastrados;
	}
	
}	
	