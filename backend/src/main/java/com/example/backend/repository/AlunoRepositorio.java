package com.example.backend.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Aluno;

@Repository
@Transactional
public interface AlunoRepositorio extends JpaRepository<Aluno, String> {

}
