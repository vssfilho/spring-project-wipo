package com.java.wipo.util;

import java.text.SimpleDateFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.java.wipo.model.dto.PatenteDto;
import com.java.wipo.model.dto.RequerenteDto;
import com.java.wipo.model.dto.TituloDto;

public class ClientWipo {

	private String server = "https://patentscope.wipo.int/search/pt/detail.jsf?docId=:nuPatente&redirectedID=true";
	private RestTemplate rest;
	private HttpHeaders headers;
	private HttpStatus status;
	private String html;
	Document doc;

	public ClientWipo() {
	    this.rest = new RestTemplate();
	    this.headers = new HttpHeaders();
	    headers.add("Content-Type", MediaType.TEXT_HTML_VALUE);
	    headers.add("Accept", "*/*");
	  }
	
	public PatenteDto buscarPatente(String nuPatente) throws Exception {

		PatenteDto patente = new PatenteDto();
		SimpleDateFormat formato = new SimpleDateFormat("dd.MM.yyyy");
		
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		ResponseEntity<String> responseEntity = rest.exchange(server.replace(":nuPatente", nuPatente),
				HttpMethod.GET, requestEntity, String.class);
		this.status = responseEntity.getStatusCode();
		
		if(Integer.compare(this.status.value(), 200) != 0) {
			throw new Exception("Erro ao buscar patente no servidor");
		}
		
		this.html = responseEntity.getBody();
		this.doc = Jsoup.parse(this.html);
		
		Element setNroPub = doc.getElementById("detailPCTtableWO");
		Element nroPedidoInternacional = doc.getElementById("detailPCTtableAN");
		Element dataPublicacao = doc.getElementById("detailPCTtablePubDate");
		Elements requerentes = doc.getElementById("PCTapplicants").select(".notranslate");
		Elements titulos = doc.select("span.PCTtitle");
		
		
		patente.setNroPub((setNroPub != null) ? setNroPub.childNode(0).toString() : null);
		patente.setNroPedidoInternacional((nroPedidoInternacional != null) ? nroPedidoInternacional.childNode(0).toString() : null);
		patente.setDataPublicacao((dataPublicacao != null) ? formato.parse(dataPublicacao.childNode(0).toString()) : null);
		
		if(requerentes != null) {
			String[] arrayRequerentes = requerentes.first().html().split("<br>");
			for (String requerente : arrayRequerentes) {
				patente.addRequerente(new RequerenteDto(Jsoup.parse(requerente).text()));
			}
		}
		
		if(titulos != null) {
			String[] arrayTitulos = titulos.first().html().split("<br>");
			for (String titulo : arrayTitulos) {
				patente.addTitulo(new TituloDto(Jsoup.parse(titulo).text()));
			}
		}
		
		return patente;

	}

}
