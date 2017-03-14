package org.sinaf.tpFileRouge.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Salarie {

	private long id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private Role role;
	private List<Pronostic> pronostics;

	public Salarie(long l) {
		id = l;
	}
}
