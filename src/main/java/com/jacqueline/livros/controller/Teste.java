package com.jacqueline.livros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Teste {

	@RequestMapping("/")//essa anotação é para abrir no navegador, neste caso, ao colocarmos o localhost:8080/ ja vem pra ca, se colocassemos /algo, deveria usar: localhost:8080/algo
	@ResponseBody //essa anotação faz com que retorne direto a string do metodo. se não a colocarmos, ele procura por uma pagina no projeto com o nome da string
	public String teste()
	{
		return "PRIMEIRA API ";
	}

}
