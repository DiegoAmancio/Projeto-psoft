package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Disciplina;
import com.example.backend.service.DisciplinaService;

@RestController
@RequestMapping(value = "/disciplinas")
@CrossOrigin(origins = "*")
public class ControllerDisciplinas {
	@Autowired
	DisciplinaService disciplinaService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Disciplina> listar() {
		return disciplinaService.disciplinasCadastradas();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Disciplina save(@RequestBody Disciplina disciplina) {
		return disciplinaService.cadastrarDisciplina(disciplina);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public HttpStatus update(@RequestBody Disciplina disciplina) {
		Disciplina disciplinaAtt = disciplinaService.update(disciplina);
		if (disciplinaAtt != null)
			return HttpStatus.OK;
		return HttpStatus.EXPECTATION_FAILED;
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public HttpStatus delete(@RequestBody Integer id) {
		if (disciplinaService.deletarDisciplina(id)) {
			return HttpStatus.OK;
		}
		return HttpStatus.NOT_FOUND;
	}

}
