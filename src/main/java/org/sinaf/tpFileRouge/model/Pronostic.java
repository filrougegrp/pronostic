package org.sinaf.tpFileRouge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pronostic {

	private long id;
	private int but_1;
	private int but_2;
	private int note;
	private Rencontre rencontre;
	private Salarie salarie;

}
