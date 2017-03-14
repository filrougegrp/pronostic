package org.sinaf.tpFileRouge.service.pronostic;

import java.util.List;

import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pronostic;

public interface PronosticService {

	int create(Pronostic pronostic) throws TechniqueException;

	List<Pronostic> getAllBySalarieId(Long id) throws TechniqueException;

}