package org.sinaf.tpFileRouge.serviceTest.salarieservicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticServiceTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Salarie;

public class GetSalarieByUsernameTest extends APronosticServiceTest {

	@Test
	public void shoudReturnSalarieWhenGetPaysByUsername() throws TechniqueException {

		Salarie s = new Salarie();
		s.setUsername("saoud");

		doReturn(Optional.ofNullable(s)).when(this.mockSalarieDao).getSalarieByUsername("saoud");

		Salarie salarie = this.salarieService.getSalariebyUsername("saoud").get();

		assertNotNull(salarie);
		assertEquals("saoud", salarie.getUsername());
		verify(this.mockSalarieDao, times(1)).getSalarieByUsername("saoud");

	}

}
