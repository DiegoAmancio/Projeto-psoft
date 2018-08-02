package com.example.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Aluno;
import com.example.backend.model.Disciplina;
import com.example.backend.repository.AlunoRepositorio;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepositorio alunoRepositorio;

	public List<Aluno> todasMatriculas() {
		return alunoRepositorio.findAll();
	}

	public Boolean cadastrarAluno(Aluno aluno) {
		if(alunoRepositorio.existsById(aluno.getMatricula())) {
			return false;
		}
		alunoRepositorio.save(aluno);
		return true;

	}

	public Optional<Aluno> getAluno(String matricula) {
		return alunoRepositorio.findById(matricula);
	}

	public void cadastrarInteresse(Disciplina disciplina, String matricula) {
		Aluno aluno = alunoRepositorio.findById(matricula).get();
		Set<Disciplina> cadeiras = aluno.getCadeiras();
		cadeiras.add(disciplina);
		aluno.setCadeiras(cadeiras);
		alunoRepositorio.save(aluno);
	}

}
