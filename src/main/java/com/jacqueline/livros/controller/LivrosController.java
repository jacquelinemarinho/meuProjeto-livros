package com.jacqueline.livros.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jacqueline.livros.controller.dto.DetalhesLivroDto;
import com.jacqueline.livros.controller.dto.LivroDto;
import com.jacqueline.livros.controller.form.AtualizacaoLivroForm;
import com.jacqueline.livros.controller.form.LivroForm;
import com.jacqueline.livros.entidades.Autor;
import com.jacqueline.livros.entidades.Livro;
import com.jacqueline.livros.entidades.Status;
import com.jacqueline.livros.repository.AutorRepository;
import com.jacqueline.livros.repository.LivroRepository;


@RestController
@RequestMapping("/livros")
public class LivrosController 
{
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@GetMapping
	public List<LivroDto> listarLivros(String autor)
	{
		if(autor == null)
		{
			List<Livro> livros = livroRepository.findAll();
			return LivroDto.converter(livros);
		}
		else
		{
			List<Livro> livros = livroRepository.findByAutor_Nome(autor);
			return LivroDto.converter(livros);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm form, UriComponentsBuilder uriBuilder) 
	{
		Livro livro = form.converter(autorRepository);
		livroRepository.save(livro);
		
		URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(new LivroDto(livro));
		
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesLivroDto> listarUmLivro(@PathVariable Long id)
	{
		Optional<Livro> livro = livroRepository.findById(id);
		if(livro.isPresent())
		{
			return ResponseEntity.ok(new DetalhesLivroDto(livro.get()));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LivroDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoLivroForm form )
	{
		Optional<Livro> optional = livroRepository.findById(id);
		if(optional.isPresent())
		{
			Livro livro = form.atualizar(id, livroRepository);
			return ResponseEntity.ok(new LivroDto(livro));
		}
		return ResponseEntity.notFound().build();	
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletar(@PathVariable Long id)
	{
		Optional<Livro> optional = livroRepository.findById(id);
		if(optional.isPresent())
		{
			livroRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();	
			
		 
	}
	
	
	
	

}
