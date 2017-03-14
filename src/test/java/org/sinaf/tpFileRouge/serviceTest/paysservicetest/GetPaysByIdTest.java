package org.sinaf.tpFileRouge.serviceTest.paysservicetest;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticServiceTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pays;

public class GetPaysByIdTest extends APronosticServiceTest {

	@Test
	public void shoudReturnPaysWhenGetPaysById() throws TechniqueException {

		doReturn(Optional.ofNullable(new Pays(4L, "ma", "lo"))).when(this.mockPaysDAO).getById(4L);
		this.paysService.getPaysbyId(4L).get();
		verify(this.mockPaysDAO, times(1)).getById(4L);
	}

	@Test(expected = TechniqueException.class)
	public void shouldThrowTechnocalException() throws TechniqueException {

		doThrow(TechniqueException.class).when(this.mockPaysDAO).getById(555L);

		this.paysService.getPaysbyId(555L).get();
		verify(this.mockPaysDAO, times(1)).getById(555L);
	}

}
