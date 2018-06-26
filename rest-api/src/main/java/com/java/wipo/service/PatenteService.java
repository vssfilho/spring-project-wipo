package com.java.wipo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.wipo.converter.PatenteConverter;
import com.java.wipo.dao.PatenteDao;
import com.java.wipo.model.Patente;
import com.java.wipo.model.dto.PatenteDto;
import com.java.wipo.util.ClientWipo;

@Service
public class PatenteService {

	PatenteConverter patenteConverter = new PatenteConverter();
	PatenteDao patenteDao = new PatenteDao();
	
	public PatenteDto carregarPatente(String nuPatente) {
		try {
			ClientWipo client = new ClientWipo();
			return client.buscarPatente(nuPatente);
		} catch(Exception e) {
			return null;
		} 
	}

	public boolean salvar(PatenteDto patente) {
		boolean retorno = false;
		try {
			patenteDao.create();
			patenteDao.begin();
			patenteDao.cadastrar(patenteConverter.toModel(patente));
			patenteDao.commit();
			retorno = true;
		} catch(Exception e) {
			patenteDao.rollback();
		} finally {
			patenteDao.close();
		}
		return retorno;
	}

	public List<PatenteDto> buscar(String nroPublicacao, String noRequerente) {
		List<PatenteDto> listPatente = null;
		try {
			patenteDao.create();
			List<Patente> listModel = patenteDao.findBy(nroPublicacao, noRequerente);
			listPatente = patenteConverter.listToDto(listModel);
		} finally {
			patenteDao.close();
		}
		return listPatente;
	}
	
}
