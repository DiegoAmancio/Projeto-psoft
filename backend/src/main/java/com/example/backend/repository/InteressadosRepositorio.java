package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend.model.Disciplina;
import com.example.backend.model.InteressadosDisciplina;

public interface InteressadosRepositorio  extends JpaRepository<InteressadosDisciplina,Long>{
	
	@Query("SELECT * FROM InteressadosDisciplina AS I WHERE matricula = I.alunoMatricula")
	public  List<InteressadosDisciplina> findDisciplinasByMatricula(@Param("matricula") String matricula);
	
	@Query("SELECT * FROM InteressadosDisciplina AS I WHERE nomeDisciplina = I.nDisciplina")
	public  List<InteressadosDisciplina> findMatricuaByDisciplina(@Param("nomeDisciplina") String nomeDisciplina);
}
