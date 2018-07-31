package com.example.backend.controller;

import java.util.ArrayList;
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
	private  InteressadoDService alunosInteressados;
	
	
	
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
	
	
	@RequestMapping(value = "/disciplinas/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable("id") Integer id, @RequestBody Disciplina disciplina) {
		if(disciplinaService.deletarDisciplina(id)){
			return HttpStatus.OK;
		}
		return HttpStatus.NOT_FOUND;
	}
	
	/**
	 * METODO PUT DE DISCIPLINA
	 */
	@RequestMapping(value = "/disciplinas", method = RequestMethod.PUT)
	public HttpStatus update( @RequestBody Disciplina disciplina) {
		Disciplina disciplinaAtt  = disciplinaService.update(disciplina);
		if(disciplinaAtt != null)return HttpStatus.OK;
		return HttpStatus.EXPECTATION_FAILED;
	}
	/**
	 * METODO POST DE DISCIPLINA
	 */
	@RequestMapping(value = "/disciplinas", method = RequestMethod.POST)
	public Disciplina save(@RequestBody Disciplina disciplina) {
		return disciplinaService.cadastrarDisciplina(disciplina);
	}
	@RequestMapping(value = "/disciplinas/{matricula}", method = RequestMethod.GET)
	public Set<InteressadosDisciplina> cadeirasAluno(@PathVariable("matricula") String matricula) {
			
					
			return alunoService.cadeirasAluno(matricula);
		
		
	}
	@RequestMapping(value = "/disciplinas/{matricula}", method = RequestMethod.POST)
	public HttpStatus cadastrar( @RequestBody Integer codigo,@PathVariable("matricula") String matricula) {
			
					
			Optional<Disciplina> disciplina = disciplinaService.findById(codigo);
			
			if(disciplina.isPresent()) {
				alunoService.cadastrarInteresse(new InteressadosDisciplina(matricula,codigo), matricula);
				return HttpStatus.OK;
			}
			
			
			
			return HttpStatus.NOT_FOUND;
		
		
	}
	
//	
//	@RequestMapping(value = "/service/search/{text}", method = RequestMethod.GET)
//	public List<Disciplina> searchByText(@PathVariable("text") String text) {
//		return disciplinaService.searchByText(text);
//	}
//	
//}


}
