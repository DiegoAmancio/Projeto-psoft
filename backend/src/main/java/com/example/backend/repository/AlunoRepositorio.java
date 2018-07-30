package com.example.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Aluno;

@Repository
@Transactional
public interface AlunoRepositorio  extends JpaRepository<Aluno,Long>{
	@Query("SELECT matricula FROM Aluno WHERE text = matricula")
	public Aluno findAlunoByMatricula(@Param("text") String text);
	
	@Query("SELECT matricula FROM Aluno")
	public List<Aluno> findAlunos();
}
