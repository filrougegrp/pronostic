package org.sinaf.tpFileRouge.serviceTest.rencontreservicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticServiceTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Rencontre;

public class GetRencontreByIdTest extends APronosticServiceTest {

	@Test(expected = TechniqueException.class)
	public void shoudlThrowTechniqueException() throws TechniqueException {

		doThrow(TechniqueException.class).when(this.mockRencontreDAO).getById(555L);

		this.rencontreService.getRencontrebyId(555L).get();

		verify(this.mockRencontreDAO, times(1)).getById(555L);

	}

	@Test
	public void shoudReturnRencontreById() throws TechniqueException {

		doReturn(Optional.ofNullable(new Rencontre(4L))).when(this.mockRencontreDAO).getById(4L);

		Rencontre rencontre = this.rencontreService.getRencontrebyId(4L).get();
		assertNotNull(rencontre);
		assertEquals(4L, rencontre.getId());
		verify(this.mockRencontreDAO, times(1)).getById(4L);
	}

}
