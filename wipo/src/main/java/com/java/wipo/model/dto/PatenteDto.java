package com.java.wipo.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatenteDto {

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("nro_pub")
	private String nroPub;
	
	@JsonProperty("nro_pedido_internacional")
	private String nroPedidoInternacional;
	
	@JsonProperty("data_publicacao")
	private Date dataPublicacao;
	
	@JsonProperty("requerentes")
	private List<RequerenteDto> requerentes = new ArrayList<>();
	
	@JsonProperty("titulo")
	private List<TituloDto> titulo = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNroPub() {
		return nroPub;
	}
	
	public void setNroPub(String nroPub) {
		this.nroPub = nroPub;
	}
	
	public String getNroPedidoInternacional() {
		return nroPedidoInternacional;
	}
	
	public void setNroPedidoInternacional(String nroPedidoInternacional) {
		this.nroPedidoInternacional = nroPedidoInternacional;
	}
	
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public List<RequerenteDto> getRequerentes() {
		return requerentes;
	}
	
	public void setRequerentes(List<RequerenteDto> requerentes) {
		this.requerentes = requerentes;
	}
	
	public List<TituloDto> getTitulo() {
		return titulo;
	}
	
	public void setTitulo(List<TituloDto> titulo) {
		this.titulo = titulo;
	}
	
	public void addRequerente(RequerenteDto requerente) {
		this.requerentes.add(requerente);
	}
	
	public void addTitulo(TituloDto titulo) {
		this.titulo.add(titulo);
	}
	
}
