package com.jacqueline.livros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacqueline.livros.entidades.Autor;
import com.jacqueline.livros.entidades.Livro;

public interface AutorRepository extends JpaRepository<Autor, Long>
{
	
	Autor findByNome(String nome);


}