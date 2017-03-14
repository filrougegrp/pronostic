package org.sinaf.tpFileRouge.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rencontre {

	private long id;
	private Pays pays_1;
	private Pays pays_2;
	private int but_1;
	private int but_2;
	private Poule poule;
	private LocalDateTime dateRencontre;

	public Rencontre(long id) {
		this.id = id;
	}

}
