package com.java.wipo.converter;

import java.util.ArrayList;
import java.util.List;

import com.java.wipo.model.Patente;
import com.java.wipo.model.dto.PatenteDto;

public class PatenteConverter {

	RequerenteConverter requerenteConverter = new RequerenteConverter();
	
	TituloConverter tituloConverter = new TituloConverter();
	
	public Patente toModel(PatenteDto dto) {
		
		Patente model = new Patente();
		
		model.setNroPub(dto.getNroPub());
		model.setNroPedidoInternacional(dto.getNroPedidoInternacional());
		model.setDataPublicacao(dto.getDataPublicacao());
		
		if(dto.getRequerentes() != null) {
			model.setRequerentes(requerenteConverter.listToModel(dto.getRequerentes(), model));
		}
		
		if(dto.getTitulo() != null) {
			model.setTitulo(tituloConverter.listToModel(dto.getTitulo(), model));
		}
		
		return model;
		
	}
	
	public PatenteDto toDto(Patente model) {
		
		PatenteDto dto = new PatenteDto();
		
		dto.setId(model.getId());
		dto.setNroPub(model.getNroPub());
		dto.setNroPedidoInternacional(model.getNroPedidoInternacional());
		dto.setDataPublicacao(model.getDataPublicacao());
		
		if(model.getRequerentes() != null) {
			dto.setRequerentes(requerenteConverter.listToDto(model.getRequerentes()));
		}
		
		if(model.getTitulo() != null) {
			dto.setTitulo(tituloConverter.listToDto(model.getTitulo()));
		}
		
		return dto;
		
	}
	
	public List<PatenteDto> listToDto(List<Patente> listModel) {

		List<PatenteDto> listDto = new ArrayList<>();

		for (Patente model : listModel) {
			listDto.add(toDto(model));
		}

		return listDto;

	}
	
	
}
