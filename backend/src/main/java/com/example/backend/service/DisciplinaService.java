package com.example.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.excecoes.Excecoes;
import com.example.backend.model.Disciplina;
import com.example.backend.repository.DisciplinasRepositorio;

@Service
public class DisciplinaService  {
	@Autowired
	private DisciplinasRepositorio disciplinas;
	
	
	public Disciplina cadastrarDisciplina(String nomeDisciplina, int cargaHoraria,String grade) {
		Optional<Disciplina> disciplina = disciplinas.findDisciplinaByName(nomeDisciplina,grade);
		
		if(!disciplina.isPresent()) {
			Disciplina novaDisciplina = new Disciplina(nomeDisciplina, cargaHoraria, grade);
			disciplinas.save(novaDisciplina);
			return disciplina.get();
		}
		
		throw new Excecoes("disciplina já cadastrada");
	}
	/**
	 * Aumenta o número de alunos interessados na disciplina em 1
	 * @param nomeDisciplina
	 */
	public void incrementaDisciplina(String nomeDisciplina,String grade) {
		Optional<Disciplina> disciplina = disciplinas.findDisciplinaByName(nomeDisciplina,grade);
		
		if(disciplina.isPresent()) {
			disciplina.get().maisUmAluno();
		}
		
		throw new Excecoes("disciplina não cadastrada");
	}
}
