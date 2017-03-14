package org.sinaf.tpFileRouge.service.salarie;

import java.util.Optional;

import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Salarie;

public interface SalarieService {

	Optional<Salarie> getSalariebyId(Long id) throws TechniqueException;

	public Optional<Salarie> getSalariebyUsername(String name) throws TechniqueException;

}
