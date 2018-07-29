package com.example.backend.excecoes;

public class Excecoes extends NullPointerException{
	
	private static final long serialVersionUID = -1420260864494245909L;

	public Excecoes(String message) {
		super(message);
	}
}
