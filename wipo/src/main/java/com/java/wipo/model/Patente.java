package com.java.wipo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PATENTE")
@SequenceGenerator(name="seqPatente", sequenceName="SEQ_PATENTE", allocationSize=1)
public class Patente {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seqPatente")
	private Integer id;

	@Column(name = "NU_PUB")
	private String nroPub;
	
	@Column(name = "NU_PEDIDO_INTENACIONAL")
	private String nroPedidoInternacional;
	
	@Column(name = "DT_PUBLICACAO")
	private Date dataPublicacao;
	
	@OneToMany(mappedBy = "patente", cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private List<Requerente> requerentes;
	
	@OneToMany(mappedBy = "patente", cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private List<Titulo> titulo;
	
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

	public List<Requerente> getRequerentes() {
		return requerentes;
	}

	public void setRequerentes(List<Requerente> requerentes) {
		this.requerentes = requerentes;
	}

	public List<Titulo> getTitulo() {
		return titulo;
	}

	public void setTitulo(List<Titulo> titulo) {
		this.titulo = titulo;
	}

	public void addRequerente(Requerente requerente) {
		this.requerentes.add(requerente);
	}
	
	public void addTitulo(Titulo titulo) {
		this.titulo.add(titulo);
	}
	
}
