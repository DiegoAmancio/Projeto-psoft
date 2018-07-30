package com.example.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.model.Disciplina;
import com.example.backend.repository.DisciplinasRepositorio;

@Service
public class DisciplinaService  {
	@Autowired
	private DisciplinasRepositorio disciplinas;
	
	
	public void cadastrarDisciplina(Disciplina novaDisciplina) {
		Optional<Disciplina> disciplina = disciplinas.findById((long) novaDisciplina.getCodigoDisciplina());
		
		if(!disciplina.isPresent()) {
			disciplinas.save(novaDisciplina);
			
		}
		
	}
	
}
