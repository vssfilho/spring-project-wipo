package com.java.wipo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequerenteDto {

	@JsonProperty("nome")
	private String nome;

	public RequerenteDto() {
		
	}
	
	public RequerenteDto(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
