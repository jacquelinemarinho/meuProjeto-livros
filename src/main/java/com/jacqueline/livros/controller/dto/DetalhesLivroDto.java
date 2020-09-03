package com.jacqueline.livros.controller.dto;

import com.jacqueline.livros.entidades.Livro;
import com.jacqueline.livros.entidades.Status;

public class DetalhesLivroDto 
{
	private Long id;
	private String titulo;
	private String nomeAutor;
	private Status status;
	
	public DetalhesLivroDto(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.nomeAutor = livro.getAutor().getNome();
		this.status = livro.getStatus();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public Status getStatus() {
		return status;
	}
	
	
	
	
	
	
	

}
