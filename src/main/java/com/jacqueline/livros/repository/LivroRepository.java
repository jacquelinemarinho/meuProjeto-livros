package com.jacqueline.livros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jacqueline.livros.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>
{

	List<Livro> findByAutor_Nome(String autor);

}
