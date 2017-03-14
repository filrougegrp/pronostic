package org.sinaf.tpFileRouge.daoTest.paysdaotest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pays;

public class GetPaysByIdTest extends APronosticTest {

	@Test
	public void shoulReturnTogoWhenGetById() throws TechniqueException {
		Optional<Pays> togo = this.paysDao.getById(2L);
		assertThat(togo.get().getId()).isEqualTo(2L);
	}

	@Test(expected = TechniqueException.class)
	public void shouldThrowTechnocalException() throws TechniqueException {
		Optional<Pays> togo = this.paysDao.getById(5000L);
		assertThat(togo.get().getId()).isEqualTo(2L);
	}

}
