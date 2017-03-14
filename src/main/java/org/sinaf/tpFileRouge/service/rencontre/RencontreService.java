package org.sinaf.tpFileRouge.service.rencontre;

import java.util.List;
import java.util.Optional;

import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Rencontre;

public interface RencontreService {

	List<Rencontre> getAll() throws TechniqueException;

	Optional<Rencontre> getRencontrebyId(long id) throws TechniqueException;

}
