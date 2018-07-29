package com.example.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufcg.springboot.service.DisciplinaService;


@RestController
@RequestMappinng(value = "/api")
@CrossOrigin(origins = "*")

public class Controller {
	@Autowired
	DisciplinaService disciplinaService;
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
		return disciplinaService.save(disciplina);
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
		Disciplina updatedTodo = disciplinaService.update(disciplina, id);
		return new ResponseEntity<Disciplina>(updatedTodo, HttpStatus.OK);
	}
	/**
	 * METODO DELETE DE DISCIPLINA PELO ID
	 */
	@RequestMapping(value = "/service/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Disciplina> delete(@PathVariable("id") Long id) {
		Disciplina disciplina = disciplinaService.delete(id);
		return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/service/search/{text}", method = RequestMethod.GET)
	public List<Disciplina> searchByText(@PathVariable("text") String text) {
		return disciplinaService.searchByText(text);
	}
}

