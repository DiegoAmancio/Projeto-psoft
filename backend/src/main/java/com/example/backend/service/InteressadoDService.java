package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.InteressadosDisciplina;
import com.example.backend.repository.InteressadoDRepositorio;

@Service
public class InteressadoDService {
	@Autowired
	private InteressadoDRepositorio alunosInteressados;

	public void cadastrarInteresse(Integer nova_disciplina, String matricula) {

		alunosInteressados.save(new InteressadosDisciplina(matricula, nova_disciplina));

	}

	public List<InteressadosDisciplina> cadeirasEscolhidas(String matricula) {
		return alunosInteressados.FindByMatricula(matricula);

	}

}
