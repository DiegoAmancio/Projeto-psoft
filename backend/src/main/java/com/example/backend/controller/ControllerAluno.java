package com.example.backend.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import com.example.backend.service.AlunoService;

import com.example.backend.service.DisciplinaService;

@RestController
@RequestMapping(value = "/alunos")
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

	private Boolean validarEmail(String email) {
		String[] split1 = email.split("@");
		String ver = "@" + split1[1];
		if (ver.equals("@ccc.ufcg.edu.br")) {
			return true;
		}
		return false;

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public HttpStatus cadastrarAluno(@RequestBody Aluno aluno) {

		Boolean cadastrou = alunoService.cadastrarAluno(aluno);
		if (cadastrou && validarEmail(aluno.getEmail())) {
			return HttpStatus.OK;
		}
		return HttpStatus.NOT_MODIFIED;
	}

	@RequestMapping(value = "/{matricula}", method = RequestMethod.GET)
	public Set<Disciplina> cadeirasAluno1(@PathVariable("matricula") String matricula) {

		return alunoService.getAluno(matricula).get().getCadeiras();

	}

	@RequestMapping(value = "/{matricula}", method = RequestMethod.POST)
	public HttpStatus cadastrarCadeiraInteresse(@RequestBody int codigo,
			@PathVariable("matricula") String matricula) {

		Optional<Disciplina> disciplina = disciplinaService.findById(codigo);
		Optional<Aluno> aluno = alunoService.getAluno(matricula);
		if (disciplina.isPresent() && aluno.isPresent()) {
			alunoService.cadastrarInteresse(disciplina.get(), matricula);
			return HttpStatus.OK;
		}

		return HttpStatus.NOT_FOUND;
	}

}
