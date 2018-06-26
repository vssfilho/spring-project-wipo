package com.java.wipo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TITULO_PATENTE")
@SequenceGenerator(name="seqTituloPatente", sequenceName="SEQ_TITULO_PATENTE", allocationSize=1)
public class Titulo {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seqTituloPatente")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_PATENTE", referencedColumnName = "ID")
	private Patente patente;
	
	@Column(name = "NO_TITULO")
	private String noTitulo;

	public Patente getPatente() {
		return patente;
	}

	public void setPatente(Patente patente) {
		this.patente = patente;
	}

	public String getNoTitulo() {
		return noTitulo;
	}

	public void setNoTitulo(String noTitulo) {
		this.noTitulo = noTitulo;
	}


}
