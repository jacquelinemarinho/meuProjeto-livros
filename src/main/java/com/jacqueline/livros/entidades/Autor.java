package com.jacqueline.livros.entidades;

import javax.persistence.Entity;

@Entity
public class Autor 
{
	private String nome;
	
	

	public Autor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Autor(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	

}
