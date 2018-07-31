package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Disciplina;
import com.example.backend.model.InteressadosDisciplina;
import com.example.backend.repository.InteressadoDRepositorio;

@Service
public class InteressadoDService {
	@Autowired
	private InteressadoDRepositorio alunosInteressados;
	
	public Boolean cadastrarInteresse(Integer nova_disciplina,String matricula){
		Optional<InteressadosDisciplina> cadastroBd = alunosInteressados.findById(matricula + nova_disciplina);
		if(!cadastroBd.isPresent()) {
			 alunosInteressados.save(new InteressadosDisciplina(matricula, nova_disciplina));
			 return true;
		}
		return false;
	}
	public List<InteressadosDisciplina> cadeirasEscolhidas(String matricula){
		return alunosInteressados.getAll();
		
		
	}

}
