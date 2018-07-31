package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.RequisitoDisciplina;
import com.example.backend.repository.RequisitosRepositorio;
@Service
public class RequisitosService {
	@Autowired
	private RequisitosRepositorio requisitosGeral;
	
	public List<RequisitoDisciplina> requisitosCadeira(Integer codigo){
		return requisitosGeral.requisitos(codigo);
	}
	
}
