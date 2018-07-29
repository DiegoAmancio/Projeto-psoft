package com.example.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(nullable = false)
	private int codigoDisciplina;
	
	@Column(nullable = false)
	private String nomeDisciplina;
	
	@Column
	private String semestre;
	
	@Column(nullable = false)
	private int horas;
	
	@Column
	private int creditos;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private String grade;
	
	private List<Integer> preRequisitos;
	
	public Disciplina(String nomeDisciplina,int creditos, int cargaHoraria,String grade,ArrayList<Integer> lista) {
		
		this.nomeDisciplina = nomeDisciplina;
		this.horas = cargaHoraria;
		this.creditos = creditos;
		this.grade = grade;
		this.preRequisitos = lista;
		
	}

	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
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

	public List<Integer> getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(List<Integer> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}	
	