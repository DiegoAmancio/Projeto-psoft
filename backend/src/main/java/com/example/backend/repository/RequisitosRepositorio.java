package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend.model.RequisitoDisciplina;



public interface RequisitosRepositorio extends JpaRepository<RequisitoDisciplina,Integer> {
	@Query("SELECT '*' FROM RequisitoDisciplina WHERE codigo_disciplina = codigo")
	public  List<RequisitoDisciplina> requisitos(@Param("codigo") Integer codigo);
	
}
