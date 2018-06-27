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
@Table(name = "TB_REQUERENTE_PATENTE")
@SequenceGenerator(name="seqRequerentePatente", sequenceName="SEQ_REQUERENTE_PATENTE", allocationSize=1)
public class Requerente {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seqRequerentePatente")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_PATENTE", referencedColumnName = "ID")
	private Patente patente;
	
	@Column(name = "NO_REQUERENTE")
	private String noRequerente;

	public Patente getPatente() {
		return patente;
	}

	public void setPatente(Patente patente) {
		this.patente = patente;
	}

	public String getNoRequerente() {
		return noRequerente;
	}

	public void setNoRequerente(String noRequerente) {
		this.noRequerente = noRequerente;
	}
	
}
