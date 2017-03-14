package org.sinaf.tpFileRouge.service.pronostic.impl;

import java.util.List;

import org.sinaf.tpFileRouge.dao.pronostic.PronosticDAO;
import org.sinaf.tpFileRouge.dao.pronostic.impl.PronosticDAOImpl;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pronostic;
import org.sinaf.tpFileRouge.service.pronostic.PronosticService;

public class PronosticServiceImpl implements PronosticService {

	private PronosticDAO pronosticDao;

	public PronosticServiceImpl(PronosticDAO pronosticDAO) {
		this.pronosticDao = pronosticDAO;
	}

	public PronosticServiceImpl() {
		try {
			this.pronosticDao = new PronosticDAOImpl();
		} catch (TechniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int create(Pronostic pronostic) throws TechniqueException {
		return this.pronosticDao.create(pronostic);
	}

	@Override
	public List<Pronostic> getAllBySalarieId(Long id) throws TechniqueException {
		return this.pronosticDao.getAllPronosticsBySalarieId(id);
	}

}
