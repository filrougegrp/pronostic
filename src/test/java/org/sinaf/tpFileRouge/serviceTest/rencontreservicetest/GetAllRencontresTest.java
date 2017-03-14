package org.sinaf.tpFileRouge.serviceTest.rencontreservicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticServiceTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Rencontre;

public class GetAllRencontresTest extends APronosticServiceTest {

	@Test
	public void shoudReturnAllRencontres() throws TechniqueException {

		List<Rencontre> rencontres = Arrays.asList(new Rencontre(), new Rencontre(), new Rencontre());

		doReturn(rencontres).when(this.mockRencontreDAO).getAll();

		List<Rencontre> rencontresFromSv = this.rencontreService.getAll();

		assertNotNull(rencontres);
		assertEquals(rencontres.size(), rencontresFromSv.size());
		verify(this.mockRencontreDAO, times(1)).getAll();
	}

}
