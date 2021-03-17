package com.fink.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fink.bookstore.domain.Categoria;
import com.fink.bookstore.domain.Livro;
import com.fink.bookstore.repositories.LivroRepository;
import com.fink.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;	
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrato! id: " + id));
	}

	public List<Livro> findByCategoriaId(Integer id_cat) {
		categoriaService.findById(id_cat);
		return livroRepository.findByCategoriaId(id_cat);
	}
	
	public Livro create(Integer id_cat, Livro livro) {
		livro.setId(null);
		Categoria categoria = categoriaService.findById(id_cat);
		livro.setCategoria(categoria);
		return livroRepository.save(livro);
	}
	
	public Livro update(Integer id, Livro newlivro) {
		Livro livro = findById(id);
		livro.setNomeAutor(newlivro.getNomeAutor());	
        livro.setTexto(newlivro.getTexto());
		livro.setTitulo(newlivro.getTitulo());
		return livroRepository.save(livro);
	}
	
	public void delete(Integer id) {
		findById(id);
		livroRepository.deleteById(id);
	}	
}
