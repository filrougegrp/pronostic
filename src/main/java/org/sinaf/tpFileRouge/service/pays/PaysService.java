package org.sinaf.tpFileRouge.service.pays;

import java.util.Optional;

import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pays;

public interface PaysService {

	Optional<Pays> getPaysbyId(Long id) throws TechniqueException;

	void updatePays(Pays pays) throws TechniqueException;

}
