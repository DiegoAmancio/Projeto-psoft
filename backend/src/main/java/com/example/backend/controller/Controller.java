package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.backend.model.Aluno;
import com.example.backend.model.Disciplina;
import com.example.backend.service.AlunoService;

import com.example.backend.service.DisciplinaService;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class Controller {
	@Autowired
	DisciplinaService disciplinaService;
	@Autowired
	AlunoService alunoService;
	
	
	@RequestMapping(value = "/aluno", method = RequestMethod.GET)
	public List<Aluno> todasMatriculas() {
		return alunoService.todasMatriculas();
	}
	@RequestMapping(value = "/aluno", method = RequestMethod.POST)
	public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
		
		 return alunoService.cadastrarAluno(aluno);
		
	}
	@RequestMapping(value = "/disciplinas", method = RequestMethod.GET)
	public List<Disciplina> listar() {
		return disciplinaService.disciplinasCadastradas();
	}
	/**
	 * METODO POST DE DISCIPLINA
	 */
	@RequestMapping(value = "/disciplinas", method = RequestMethod.POST)
	public Disciplina save(@RequestBody Disciplina disciplina) {
		return disciplinaService.cadastrarDisciplina(disciplina);
	}
	
	/**
	 * METODO PUT DE DISCIPLINA
	 */
	@RequestMapping(value = "/disciplinas", method = RequestMethod.PUT)
	public ResponseEntity<Disciplina> update( @RequestBody Disciplina disciplina) {
		Disciplina disciplinaAtt  = disciplinaService.update(disciplina);
		if(disciplinaAtt != null)return new ResponseEntity<Disciplina>(disciplinaAtt, HttpStatus.OK);
		return new ResponseEntity<Disciplina>(disciplinaAtt, HttpStatus.EXPECTATION_FAILED);
	}
//	/**
//	 * METODO DELETE DE DISCIPLINA PELO ID
//	 */
//	@RequestMapping(value = "/service/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Disciplina> delete(@PathVariable("id") Long id) {
//		Disciplina disciplina = disciplinaService.deleteById(id);
//		return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/service/search/{text}", method = RequestMethod.GET)
//	public List<Disciplina> searchByText(@PathVariable("text") String text) {
//		return disciplinaService.searchByText(text);
//	}
//	
//}


}
