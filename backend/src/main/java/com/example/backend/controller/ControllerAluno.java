package com.example.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Aluno;
import com.example.backend.model.Disciplina;
import com.example.backend.model.InteressadosDisciplina;
import com.example.backend.service.AlunoService;

import com.example.backend.service.DisciplinaService;
import com.example.backend.service.InteressadoDService;

@RestController
@RequestMapping(value = "/aluno")
@CrossOrigin(origins = "*")
public class ControllerAluno {
	@Autowired
	DisciplinaService disciplinaService;
	@Autowired
	AlunoService alunoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Aluno> todasMatriculas() {
		return alunoService.todasMatriculas();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public HttpStatus cadastrarAluno(@RequestBody Aluno aluno) {

		 alunoService.cadastrarAluno(aluno);
		 return HttpStatus.OK;
	}

	
	
}
