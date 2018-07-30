package com.example.backend.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Aluno;
import com.example.backend.repository.AlunoRepositorio;


@Service
public class AlunoService {
	@Autowired
	private AlunoRepositorio alunorepo;
	
	public Aluno cadastrarAluno(Aluno aluno) {
		Optional<Aluno> procurandoAluno = alunorepo.findById(aluno.getMatricula());
		if(!procurandoAluno.isPresent()) {
			alunorepo.save(aluno);
			
		}
		return aluno;
	}
}
