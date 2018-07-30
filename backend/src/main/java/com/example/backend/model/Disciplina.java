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
	
	
	
	public Disciplina(String nomeDisciplina,int creditos, int cargaHoraria,String grade) {
		
		this.nomeDisciplina = nomeDisciplina;
		this.horas = cargaHoraria;
		this.creditos = creditos;
		this.grade = grade;
		
		
		
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoDisciplina;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (codigoDisciplina != other.codigoDisciplina)
			return false;
		return true;
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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}	
	