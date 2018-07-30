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
		Optional<Disciplina> disciplina = disciplinas.findById((long) novaDisciplina.getCodigoDisciplina());
		
		if(!disciplina.isPresent()) {
			disciplinas.save(novaDisciplina);
			
		}
		return novaDisciplina;
		
	}


	public List<Disciplina> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public Disciplina getById(Long id) {
		Optional<Disciplina> disciplina = disciplinas.findById(id);
		
		if(disciplina.isPresent()) {
			return disciplina.get();
			
		}
		return null;
	}


	public Disciplina update(Disciplina novaDisciplina, Long id) {
		Optional<Disciplina> disciplinaNoBd = disciplinas.findById(id);
		if(disciplinaNoBd.isPresent()) {
			disciplinas.deleteById(id);
			disciplinas.save(novaDisciplina);
			return novaDisciplina;
		}
		return null;
	}
	
}
