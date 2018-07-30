package com.example.backend.controller;
import java.util.List;

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
	
	DisciplinaService disciplinaService;
	AlunoService alunoService;
	@RequestMapping(value = "/Aluno", method = RequestMethod.GET)
	public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
		return alunoService.cadastrarAluno(aluno);
	}
	/**
	 * METODO GET DE DISCIPLINA
	 */
	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public List<Disciplina> getAll() {
		return disciplinaService.getAll();
	}
	/**
	 * METODO POST DE DISCIPLINA
	 */
	@RequestMapping(value = "/service", method = RequestMethod.POST)
	public Disciplina save(@RequestBody Disciplina disciplina) {
		return disciplinaService.cadastrarDisciplina(disciplina);
	}
	/**
	 * METODO POST DE DISCIPLINA PELO ID
	 */
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public Disciplina getById(@PathVariable("id") Long id) {
		return disciplinaService.getById(id);
	}
	/**
	 * METODO PUT DE DISCIPLINA
	 */
	@RequestMapping(value = "/service/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Disciplina> update(@PathVariable("id") Long id, @RequestBody Disciplina disciplina) {
		Disciplina disciplinaAtt  = disciplinaService.update(disciplina, id);
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
}

