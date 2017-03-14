package org.sinaf.tpFileRouge.service.rencontre.impl;

import java.util.List;
import java.util.Optional;

import org.sinaf.tpFileRouge.dao.rencontre.RencontreDAO;
import org.sinaf.tpFileRouge.dao.rencontre.impl.RencontreDAOImpl;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Rencontre;
import org.sinaf.tpFileRouge.service.rencontre.RencontreService;

public class RencontreServiceImpl implements RencontreService {

	private RencontreDAO rencontreDao;

	public RencontreServiceImpl() {
		try {
			this.rencontreDao = new RencontreDAOImpl();
		} catch (TechniqueException e) {
			e.printStackTrace();
		}
	}

	public RencontreServiceImpl(RencontreDAO rencontreDao) {
		this.rencontreDao = rencontreDao;
	}

	@Override
	public List<Rencontre> getAll() throws TechniqueException {
		return this.rencontreDao.getAll();
	}

	@Override
	public Optional<Rencontre> getRencontrebyId(long id) throws TechniqueException {
		return this.rencontreDao.getById(id);
	}

}
