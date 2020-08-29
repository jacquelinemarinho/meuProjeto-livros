package com.jacqueline.livros.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Autor 
{

	@Id
	private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	

}
