package com.java.wipo.converter;

import java.util.ArrayList;
import java.util.List;

import com.java.wipo.model.Patente;
import com.java.wipo.model.Titulo;
import com.java.wipo.model.dto.TituloDto;

public class TituloConverter {

	public Titulo toModel(TituloDto dto, Patente patenteModel) {

		Titulo model = new Titulo();
		model.setPatente(patenteModel);
		model.setNoTitulo(dto.getNome());
		return model;

	}

	public List<Titulo> listToModel(List<TituloDto> listDto, Patente patenteModel) {

		List<Titulo> listModel = new ArrayList<>();

		for (TituloDto dto : listDto) {
			listModel.add(toModel(dto, patenteModel));
		}

		return listModel;

	}

	public TituloDto toDto(Titulo model) {

		TituloDto dto = new TituloDto();
		dto.setNome(model.getNoTitulo());
		return dto;

	}

	public List<TituloDto> listToDto(List<Titulo> listModel) {

		List<TituloDto> listDto = new ArrayList<>();

		for (Titulo model : listModel) {
			listDto.add(toDto(model));
		}

		return listDto;

	}

}
