package com.fink.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fink.bookstore.domain.Categoria;
import com.fink.bookstore.dtos.CategoriaDTO;
import com.fink.bookstore.service.CategoriaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria categoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(categoria);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = categoriaService.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(categoria -> new CategoriaDTO(categoria))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria) {
		categoria = categoriaService.create(categoria);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(categoria.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Categoria> update(@PathVariable Integer id,@Valid @RequestBody Categoria categoria) {
		Categoria newCategoria = categoriaService.update(id, categoria);
		return ResponseEntity.ok().body(newCategoria);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();		
	}
}
