package org.sinaf.tpFileRouge.daoTest.pronosticdaotest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;
import org.sinaf.tpFileRouge.APronosticTest;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Competition;
import org.sinaf.tpFileRouge.model.Pays;
import org.sinaf.tpFileRouge.model.Poule;
import org.sinaf.tpFileRouge.model.Pronostic;
import org.sinaf.tpFileRouge.model.Rencontre;
import org.sinaf.tpFileRouge.model.Role;
import org.sinaf.tpFileRouge.model.Salarie;

public class InsertPronostic extends APronosticTest {
	@Test
	public void shoulReturn1WhenInsertSucces() {

		try {

			Competition competition = new Competition(1, "CAN ", LocalDate.now());
			Poule poule = new Poule(1, "A", true, competition);
			Pays pays1 = new Pays(1L, "maroc", "hhhh");
			Pays pays2 = new Pays(2L, "togo", "mmmm");
			Rencontre rencontre = new Rencontre(1L, pays1, pays2, 1, 2, poule, LocalDateTime.now());
			Role role = new Role(1, "ROLE_USER");
			Salarie salarie = new Salarie(1, "badouch", "mohamed", "badouch", "password", role, null);

			int rs = this.pronosticDao.create(new Pronostic(1, 2, 1, 0, rencontre, salarie));
			assertThat(rs).isEqualTo(1);
		} catch (TechniqueException e) {
			e.printStackTrace();
		}
	}
}
