package com.fink.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<List<LivroDTO>> findByCategoriaId(
			@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
		List<Livro> list = livroService.findByCategoriaId(id_cat);
		List<LivroDTO> listDTO = list.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
			@RequestBody Livro livro) {
		livro = livroService.create(id_cat, livro);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/livros/{id}")
				.buildAndExpand(livro.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro livro) {
		Livro newlivro = livroService.update(id, livro);
		return ResponseEntity.ok().body(newlivro);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro livro) {
		Livro newlivro = livroService.update(id, livro);
		return ResponseEntity.ok().body(newlivro);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
