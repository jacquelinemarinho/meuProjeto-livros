package com.jacqueline.livros.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jacqueline.livros.entidades.Autor;
import com.jacqueline.livros.entidades.Livro;
import com.jacqueline.livros.repository.AutorRepository;

public class LivroForm 
{
	@NotNull @NotEmpty @Length(min=5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min=5)
	private String nomeAutor;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}


	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Livro converter(AutorRepository autorRepository) {
		
		Autor autor = autorRepository.findByNome(nomeAutor);
		return new Livro(titulo, autor);
	}
		

}
