package com.java.wipo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.java.commons.util.GenericDao;
import com.java.wipo.model.Patente;

public class PatenteDao extends GenericDao {

	public void cadastrar(Patente patente) {
		GenericDao.em.persist(patente);
	}

	public List<Patente> findBy(String nroPublicacao, String noRequerente) {

		// Consulta realizada dessa forma para que o 
		// resultado traga a lista completa de requerentes e titulos
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT P FROM Patente P ");
		sql.append("LEFT JOIN FETCH P.requerentes R ");
		sql.append("WHERE P.id IN ( ");
		sql.append("SELECT P_FILTRO.id FROM Patente P_FILTRO ");
		sql.append("LEFT JOIN P_FILTRO.requerentes R_FILTRO ");
		sql.append("WHERE 1 = 1 ");

		boolean filtrarNroPublicacao = nroPublicacao != null && !nroPublicacao.isEmpty();
		boolean filtrarRequerente = noRequerente != null && !noRequerente.isEmpty();

		if (filtrarNroPublicacao) {
			sql.append(" AND P_FILTRO.nroPub = :nroPub");
		}

		if (filtrarRequerente) {
			sql.append(" AND R_FILTRO.noRequerente LIKE :noRequerente");
		}

		sql.append(" ) ORDER BY P.id ASC");
		
		TypedQuery<Patente> query = GenericDao.em.createQuery(sql.toString(), Patente.class);

		if (filtrarNroPublicacao) {
			query.setParameter("nroPub", nroPublicacao);
		}

		if (filtrarRequerente) {
			query.setParameter("noRequerente", "%"+noRequerente+"%");
		}

		return query.getResultList();
	}

}
