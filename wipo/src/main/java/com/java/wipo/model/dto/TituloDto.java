package com.java.wipo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TituloDto {

	@JsonProperty("nome")
	private String nome;

	public TituloDto() {

	}
	
	public TituloDto(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
