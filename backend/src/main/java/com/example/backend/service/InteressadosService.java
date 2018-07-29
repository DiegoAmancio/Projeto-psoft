package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.InteressadosDisciplina;
import com.example.backend.repository.InteressadosRepositorio;

@Service
public class InteressadosService {
	@Autowired
	private InteressadosRepositorio alunosInteressados;
	
	public void cadastraAlunoDisciplina(String matricula,int idDisciplina) {
		List<InteressadosDisciplina> cadastrosAluno = alunosInteressados.findDisciplinasByMatricula(matricula);
		InteressadosDisciplina novoCadastro = new InteressadosDisciplina(matricula,idDisciplina);
		if(!cadastrosAluno.contains(novoCadastro)){
			alunosInteressados.save(novoCadastro);
		}
	}
}
