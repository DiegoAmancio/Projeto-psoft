package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Aluno;

import com.example.backend.repository.AlunoRepositorio;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepositorio alunoRepositorio;

	public List<Aluno> todasMatriculas() {
		return alunoRepositorio.findAlunos();
	}

	public Aluno cadastrarAluno(Aluno aluno) {

		return alunoRepositorio.save(aluno);

	}

	public Optional<Aluno> getAluno(String matricula) {
		return alunoRepositorio.findById(matricula);
	}

}
