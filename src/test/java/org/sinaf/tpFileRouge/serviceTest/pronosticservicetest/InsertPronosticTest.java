package org.sinaf.tpFileRouge.serviceTest.pronosticservicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticServiceTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pronostic;

public class InsertPronosticTest extends APronosticServiceTest {
	@Test
	public void shoulReturn1WhenInsertSucces() {

		try {
			Pronostic p = new Pronostic();
			doReturn(1).when(this.mockPronosticDAO).create(p);

			int rs = this.pronosticService.create(p);
			assertThat(rs).isEqualTo(1);
			verify(this.mockPronosticDAO, times(1)).create(p);
		} catch (TechniqueException e) {
			e.printStackTrace();
		}
	}

}
