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
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class Controller {
	@Autowired
	DisciplinaService disciplinaService;
	@Autowired
	AlunoService alunoService;
	@Autowired
	private InteressadoDService alunosInteressados;

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

	@RequestMapping(value = "/aluno/disciplinas/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable("id") Integer id) {
		if (disciplinaService.deletarDisciplina(id)) {
			return HttpStatus.OK;
		}
		return HttpStatus.NOT_FOUND;
	}

	/**
	 * METODO PUT DE DISCIPLINA
	 */
	@RequestMapping(value = "/disciplinas", method = RequestMethod.PUT)
	public HttpStatus update(@RequestBody Disciplina disciplina) {
		Disciplina disciplinaAtt = disciplinaService.update(disciplina);
		if (disciplinaAtt != null)
			return HttpStatus.OK;
		return HttpStatus.EXPECTATION_FAILED;
	}


	@RequestMapping(value = "/disciplinas", method = RequestMethod.POST)
	public Disciplina save(@RequestBody Disciplina disciplina) {
		return disciplinaService.cadastrarDisciplina(disciplina);
	}

	@RequestMapping(value = "/disciplinas/{matricula}", method = RequestMethod.GET)
	public List<InteressadosDisciplina> cadeirasAluno(@PathVariable("matricula") String matricula) {

		return alunosInteressados.cadeirasEscolhidas(matricula);

	}

	@RequestMapping(value = "/disciplinas/{matricula}", method = RequestMethod.POST)
	public HttpStatus cadastrar(@RequestBody Integer codigo, @PathVariable("matricula") String matricula) {

		Optional<Disciplina> disciplina = disciplinaService.findById(codigo);
		Optional<Aluno> aluno = alunoService.getAluno(matricula);
		if (disciplina.isPresent() && aluno.isPresent()) {
			alunosInteressados.cadastrarInteresse(codigo, matricula);
			return HttpStatus.OK;
		}

		return HttpStatus.NOT_FOUND;

	}

}
