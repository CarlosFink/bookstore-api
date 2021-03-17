package com.fink.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fink.bookstore.domain.Categoria;
import com.fink.bookstore.repositories.CategoriaRepository;
import com.fink.bookstore.service.exceptions.DataIntegrityViolationExcept;
import com.fink.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! id: " + id));
	}
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}
	
	public Categoria update(Integer id, Categoria categoria) {
		Categoria newCategoria = findById(id);
		newCategoria.setNome(categoria.getNome());
		newCategoria.setDescricao(categoria.getDescricao());
		return categoriaRepository.save(newCategoria);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationExcept("Categoria não pode ser excluída, possui livros associados!");
		}		
	}
}
