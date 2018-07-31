package com.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "requisito")
public class RequisitoDisciplina {
	@Id
	private Integer codigo_disciplina;
	
	@Column
	private Integer pre;
	
	@Column
	private Integer Pos
	;
	
	public RequisitoDisciplina(Integer codigo_disciplina, Integer pre, Integer pos) {
		super();
		this.codigo_disciplina = codigo_disciplina;
		this.pre = pre;
		Pos = pos;
	}
	public Integer getCodigo_disciplina() {
		return codigo_disciplina;
	}
	public void setCodigo_disciplina(Integer codigo_disciplina) {
		this.codigo_disciplina = codigo_disciplina;
	}
	public Integer getPre() {
		return pre;
	}
	public void setPre(Integer pre) {
		this.pre = pre;
	}
	public Integer getPos() {
		return Pos;
	}
	public void setPos(Integer pos) {
		Pos = pos;
	}
	
	
	
	
	

}
