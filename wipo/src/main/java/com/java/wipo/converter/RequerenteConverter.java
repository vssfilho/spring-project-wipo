package com.java.wipo.converter;

import java.util.ArrayList;
import java.util.List;

import com.java.wipo.model.Patente;
import com.java.wipo.model.Requerente;
import com.java.wipo.model.dto.RequerenteDto;

public class RequerenteConverter {

	public Requerente toModel(RequerenteDto dto, Patente patenteModel) {

		Requerente model = new Requerente();
		model.setPatente(patenteModel);
		model.setNoRequerente(dto.getNome());
		return model;

	}

	public List<Requerente> listToModel(List<RequerenteDto> listDto, Patente patenteModel) {

		List<Requerente> listModel = new ArrayList<>();

		for (RequerenteDto dto : listDto) {
			listModel.add(toModel(dto, patenteModel));
		}

		return listModel;

	}

	public RequerenteDto toDto(Requerente model) {

		RequerenteDto dto = new RequerenteDto();
		dto.setNome(model.getNoRequerente());
		return dto;

	}

	public List<RequerenteDto> listToDto(List<Requerente> listModel) {

		List<RequerenteDto> listDto = new ArrayList<>();

		for (Requerente model : listModel) {
			listDto.add(toDto(model));
		}

		return listDto;

	}

}
