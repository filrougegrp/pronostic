package org.sinaf.tpFileRouge.daoTest.pronosticdaotest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pronostic;

public class getAllPronosticsBySalarieIdTest extends APronosticTest {

	@Test
	public void shouldReturnAllPronosticsBySalarieId() {
		try {
			List<Pronostic> pronostics = this.pronosticDao.getAllPronosticsBySalarieId(3L);
			assertThat(pronostics.stream().count()).isGreaterThan(2);
		} catch (TechniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
