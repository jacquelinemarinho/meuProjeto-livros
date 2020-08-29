package com.jacqueline.livros.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro 
{
	
	@Id
	private Long id;
	private String titulo;
	@ManyToOne
	private Autor autor; 
	private Status status = Status.PENDENTE;
	
	
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livro(String titulo, Autor autor) {
		super();
		
		this.titulo = titulo;
		this.autor = autor;
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
	

}
