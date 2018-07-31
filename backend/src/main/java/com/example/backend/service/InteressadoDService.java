package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.InteressadosDisciplina;
import com.example.backend.repository.InteressadoDRepositorio;

@Service
public class InteressadoDService {
	@Autowired
	InteressadoDRepositorio alunosInteressados;
	
	
	public List<Integer>CodigosDisciplinaAluno(Long matricula){
		return null;
		
		
	}

}
