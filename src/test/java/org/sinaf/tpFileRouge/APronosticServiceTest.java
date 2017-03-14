package org.sinaf.tpFileRouge;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sinaf.tpFileRouge.dao.pays.PaysDAO;
import org.sinaf.tpFileRouge.dao.pronostic.PronosticDAO;
import org.sinaf.tpFileRouge.dao.rencontre.RencontreDAO;
import org.sinaf.tpFileRouge.dao.salarie.SalarieDao;
import org.sinaf.tpFileRouge.service.pays.PaysService;
import org.sinaf.tpFileRouge.service.pays.impl.PaysServiceImpl;
import org.sinaf.tpFileRouge.service.pronostic.PronosticService;
import org.sinaf.tpFileRouge.service.pronostic.impl.PronosticServiceImpl;
import org.sinaf.tpFileRouge.service.rencontre.RencontreService;
import org.sinaf.tpFileRouge.service.rencontre.impl.RencontreServiceImpl;
import org.sinaf.tpFileRouge.service.salarie.SalarieService;
import org.sinaf.tpFileRouge.service.salarie.impl.SalarieServiceImpl;

public abstract class APronosticServiceTest {

	protected SalarieService salarieService;
	protected RencontreService rencontreService;
	protected PronosticService pronosticService;
	protected PaysService paysService;

	@Mock
	protected SalarieDao mockSalarieDao;
	@Mock
	protected RencontreDAO mockRencontreDAO;
	@Mock
	protected PronosticDAO mockPronosticDAO;
	@Mock
	protected PaysDAO mockPaysDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.salarieService = new SalarieServiceImpl(this.mockSalarieDao);
		this.rencontreService = new RencontreServiceImpl(this.mockRencontreDAO);
		this.pronosticService = new PronosticServiceImpl(this.mockPronosticDAO);
		this.paysService = new PaysServiceImpl(this.mockPaysDAO);
	}

}
