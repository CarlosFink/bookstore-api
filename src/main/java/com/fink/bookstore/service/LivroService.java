package com.fink.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fink.bookstore.domain.Livro;
import com.fink.bookstore.repositories.LivroRepository;
import com.fink.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;	
	
	public Livro findById(Integer id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrato! id: " + id));
	}

	public List<Livro> findAll() {		
		return livroRepository.findAll();
	}
}
