package com.jacqueline.livros.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jacqueline.livros.entidades.Autor;
import com.jacqueline.livros.entidades.Livro;


@Controller
public class LivrosController 
{
	@ResponseBody
	@RequestMapping("/livros")
	public List<Livro> listarLivros()
	{
		Livro livro = new Livro("A Rainha Vermelha", new Autor("lalalala"));
		
		return Arrays.asList(livro, livro, livro);
	}
	

}
