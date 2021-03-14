package com.fink.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fink.bookstore.domain.Categoria;
import com.fink.bookstore.domain.Livro;
import com.fink.bookstore.repositories.CategoriaRepository;
import com.fink.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	public void instanciaDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro livro2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem Ipsum", cat1);	
		Livro livro3 = new Livro(null, "The Time Machine", "H. G. Wells", "Lorem Ipsum", cat2);	
		Livro livro4 = new Livro(null, "The War of the Worlds", "H. G. Wells", "Lorem Ipsum", cat2);	
		Livro livro5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem Ipsum", cat2);	
		
		cat1.getLivros().addAll(Arrays.asList(livro1, livro2));
		cat2.getLivros().addAll(Arrays.asList(livro3, livro4, livro5));
		this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));
	}
}
