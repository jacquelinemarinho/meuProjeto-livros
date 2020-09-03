package com.jacqueline.livros.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jacqueline.livros.entidades.Autor;
import com.jacqueline.livros.entidades.Livro;
import com.jacqueline.livros.repository.AutorRepository;
import com.jacqueline.livros.repository.LivroRepository;

public class AtualizacaoLivroForm 
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

	public Livro atualizar(Long id, LivroRepository livroRepository) 
	{
		Livro livro = livroRepository.getOne(id);
		livro.getAutor().setNome(this.nomeAutor);
		livro.setTitulo(this.titulo);
		
		return livro;
		
	}

		

}
