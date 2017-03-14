package org.sinaf.tpFileRouge.service.salarie.impl;

import java.util.Optional;

import org.sinaf.tpFileRouge.dao.salarie.SalarieDao;
import org.sinaf.tpFileRouge.dao.salarie.impl.SalarieDAOImpl;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Salarie;
import org.sinaf.tpFileRouge.service.salarie.SalarieService;

import lombok.Setter;

@Setter
public class SalarieServiceImpl implements SalarieService {

	private SalarieDao salarieDao;

	public SalarieServiceImpl() {
		try {
			this.salarieDao = new SalarieDAOImpl();
		} catch (TechniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SalarieServiceImpl(SalarieDao salarieDao) {
		this.salarieDao = salarieDao;
	}

	@Override
	public Optional<Salarie> getSalariebyId(Long id) throws TechniqueException {
		return this.salarieDao.getById(id);
	}

	@Override
	public Optional<Salarie> getSalariebyUsername(String name) throws TechniqueException {
		return this.salarieDao.getSalarieByUsername(name);
	}

}
