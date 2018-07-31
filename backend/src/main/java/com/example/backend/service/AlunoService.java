package com.example.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Aluno;
import com.example.backend.model.Disciplina;
import com.example.backend.model.InteressadosDisciplina;
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

	public Set<InteressadosDisciplina> cadeirasAluno(String matricula) {
		Optional<Aluno> aluno = alunoRepositorio.findById(matricula);

		return aluno.get().getCadeirasInteressadas();

	}

	public boolean cadastrarInteresse(InteressadosDisciplina disciplina, String matricula) {
		Optional<Aluno> aluno = alunoRepositorio.findById(matricula);
		if (aluno.isPresent()) {
			return aluno.get().addCadeira(disciplina);

		}
		return false;
	}
}
