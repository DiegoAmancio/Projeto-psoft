package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.backend.model.InteressadosDisciplina;

@Repository
@Transactional
public interface InteressadoDRepositorio extends JpaRepository<InteressadosDisciplina,String> {

	@Query("SELECT '*' FROM InteressadosDisciplina")
	public  Optional<InteressadosDisciplina> getAll();
	
	
	
	
}
