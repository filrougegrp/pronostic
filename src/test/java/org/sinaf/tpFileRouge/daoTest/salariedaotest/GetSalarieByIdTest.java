package org.sinaf.tpFileRouge.daoTest.salariedaotest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Salarie;

public class GetSalarieByIdTest extends APronosticTest {

	@Test
	public void shoudlReturnSalarieWhenGetById() throws TechniqueException {
		Optional<Salarie> salarie = this.salarieDao.getById(1L);
		assertThat(salarie.isPresent()).isTrue();
	}

	@Test(expected = TechniqueException.class)
	public void shoudlThrowTechniqueException() throws TechniqueException {
		this.salarieDao.getById(5000L);
	}

}
