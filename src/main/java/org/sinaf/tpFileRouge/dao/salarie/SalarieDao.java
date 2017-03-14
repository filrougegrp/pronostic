package org.sinaf.tpFileRouge.dao.salarie;

import java.util.Optional;

import org.sinaf.tpFileRouge.dao.IDAO;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Salarie;

public interface SalarieDao extends IDAO<Salarie> {

	Optional<Salarie> getSalarieByUsername(String username) throws TechniqueException;
}
