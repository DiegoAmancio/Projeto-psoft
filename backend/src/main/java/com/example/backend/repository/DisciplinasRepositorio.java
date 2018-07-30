package com.example.backend.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Disciplina;

@Repository
@Transactional
public interface DisciplinasRepositorio extends JpaRepository<Disciplina,Long> {

	@Query("SELECT * FROM Disciplina AS D WHERE nome = D.nomeDisciplina and grade = D.grade")
	public  Optional<Disciplina> findDisciplinaById(@Param("nome") String nome,@Param("grade") String grade);
}
