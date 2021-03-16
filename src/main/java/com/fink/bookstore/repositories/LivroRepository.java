package com.fink.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fink.bookstore.domain.Livro;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Integer>{

	@Query("SELECT l FROM Livro l WHERE l.categoria.id = :id_cat ORDER BY l.titulo")
	List<Livro> findByCategoriaId(@ Param(value = "id_cat") Integer  id_cat);

}
