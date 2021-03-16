package com.fink.bookstore.dtos;

import java.io.Serializable;

import com.fink.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String texto;
	
	public LivroDTO() {
		super();
	}
	
	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.nomeAutor = livro.getNomeAutor();
		this.texto = livro.getTexto();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
