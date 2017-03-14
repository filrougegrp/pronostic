package org.sinaf.tpFileRouge.dao.rencontre;

import java.util.List;

import org.sinaf.tpFileRouge.dao.IDAO;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Rencontre;

public interface RencontreDAO extends IDAO<Rencontre> {

	List<Rencontre> getAll() throws TechniqueException;

}
