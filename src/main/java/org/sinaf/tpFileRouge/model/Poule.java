package org.sinaf.tpFileRouge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Poule {

	private long id;
	private String nom;
	private boolean isGroupe;
	private Competition competition;

}
