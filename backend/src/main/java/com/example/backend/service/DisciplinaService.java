package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.model.Disciplina;
import com.example.backend.repository.DisciplinasRepositorio;

@Service
public class DisciplinaService  {
	@Autowired
	private DisciplinasRepositorio disciplinas;
	
	
	public Disciplina cadastrarDisciplina(Disciplina novaDisciplina) {
		Optional<Disciplina> disciplina = disciplinas.findById((int) novaDisciplina.getCodigo_disciplina());
		
		if(!disciplina.isPresent()) {
			disciplinas.save(novaDisciplina);
			
		}
		return novaDisciplina;
		
	}


	public List<Disciplina> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



	public Disciplina update(Disciplina novaDisciplina) {
		Optional<Disciplina> disciplinaNoBd = disciplinas.findById((int) novaDisciplina.getCodigo_disciplina());
		if(disciplinaNoBd.isPresent()) {
			disciplinas.deleteById((int) novaDisciplina.getCodigo_disciplina());
			disciplinas.save(novaDisciplina);
			return novaDisciplina;
		}
		return null;
	}
	
}
