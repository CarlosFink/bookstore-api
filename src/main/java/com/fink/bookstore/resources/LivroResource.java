package com.fink.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fink.bookstore.domain.Livro;
import com.fink.bookstore.dtos.LivroDTO;
import com.fink.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro livro = livroService.findById(id);
		return ResponseEntity.ok().body(livro);
	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll() {
		List<Livro> list = livroService.findAll();
		List<LivroDTO> listDTO = list.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
