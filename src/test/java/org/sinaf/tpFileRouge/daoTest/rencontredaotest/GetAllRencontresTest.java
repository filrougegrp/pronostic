package org.sinaf.tpFileRouge.daoTest.rencontredaotest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Rencontre;

public class GetAllRencontresTest extends APronosticTest {

	@Test
	public void shoudlReturnAllRencontres() throws TechniqueException {
		List<Rencontre> rencontres = this.rencontreDAO.getAll();
		assertThat(rencontres.stream().count()).isGreaterThan(1);
	}

}
