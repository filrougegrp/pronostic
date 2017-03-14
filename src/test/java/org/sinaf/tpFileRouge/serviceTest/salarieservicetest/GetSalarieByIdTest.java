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

public class GetSalarieByIdTest extends APronosticServiceTest {

	@Test
	public void shoudReturnSalarieWhenGetPaysById() throws TechniqueException {

		doReturn(Optional.ofNullable(new Salarie(3L))).when(this.mockSalarieDao).getById(3L);

		Salarie salarie = this.salarieService.getSalariebyId(3L).get();

		assertNotNull(salarie);
		assertEquals(3L, salarie.getId());
		verify(this.mockSalarieDao, times(1)).getById(3L);
	}

}
