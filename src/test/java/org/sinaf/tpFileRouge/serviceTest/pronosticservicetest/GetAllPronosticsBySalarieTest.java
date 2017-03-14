package org.sinaf.tpFileRouge.serviceTest.pronosticservicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticServiceTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pronostic;

public class GetAllPronosticsBySalarieTest extends APronosticServiceTest {

	@Test
	public void shoulReturn1WhenInsertSucces() {

		try {
			List<Pronostic> pronostics = Arrays.asList(new Pronostic(), new Pronostic(), new Pronostic());
			doReturn(pronostics).when(this.mockPronosticDAO).getAllPronosticsBySalarieId(1L);

			assertThat(this.pronosticService.getAllBySalarieId(1L).size()).isEqualTo(pronostics.size());
			verify(this.mockPronosticDAO, times(1)).getAllPronosticsBySalarieId(1L);
		} catch (TechniqueException e) {
			e.printStackTrace();
		}
	}

}
