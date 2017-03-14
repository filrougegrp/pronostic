package org.sinaf.tpFileRouge.dao.pronostic;

import java.util.List;

import org.sinaf.tpFileRouge.dao.IDAO;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pronostic;

public interface PronosticDAO extends IDAO<Pronostic> {

	List<Pronostic> getAllPronosticsBySalarieId(Long id) throws TechniqueException;

}
