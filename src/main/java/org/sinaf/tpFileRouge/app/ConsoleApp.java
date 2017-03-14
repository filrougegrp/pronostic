package org.sinaf.tpFileRouge.app;

import java.util.List;
import java.util.Scanner;

import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pronostic;
import org.sinaf.tpFileRouge.model.Rencontre;
import org.sinaf.tpFileRouge.model.Salarie;
import org.sinaf.tpFileRouge.service.pronostic.PronosticService;
import org.sinaf.tpFileRouge.service.pronostic.impl.PronosticServiceImpl;
import org.sinaf.tpFileRouge.service.rencontre.RencontreService;
import org.sinaf.tpFileRouge.service.rencontre.impl.RencontreServiceImpl;
import org.sinaf.tpFileRouge.service.salarie.SalarieService;
import org.sinaf.tpFileRouge.service.salarie.impl.SalarieServiceImpl;

public class ConsoleApp {

	private static SalarieService salarieService = new SalarieServiceImpl();
	private static RencontreService rencontreService = new RencontreServiceImpl();
	private static PronosticService pronosticService = new PronosticServiceImpl();

	private static List<Rencontre> rencontres;
	private static List<Pronostic> pronostics;

	private static Salarie salarie;

	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws TechniqueException {

		getSalarie();

		int selection = -1;

		while (selection != 0) {

			System.out.println("votre nom est : " + salarie.getNom());
			System.out.println("===== CAN 2016 =====\n\n");

			System.out.println("====== MAIN MENU ======");
			System.out.println("[1] Lister les rencontres");
			System.out.println("[2] voir vos pronostic");
			System.out.println("[0] exit\n\n");

			s.reset();

			System.out.println("choisir menu --> ");
			selection = s.nextInt();

			switch (selection) {
			case 1:
				rencontreMenu();
				break;
			case 2:
				ListerPronostics();
				break;
			case 0:
				System.out.println("Fin");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid selection.");

			}

		}

	}

	public static void rencontreMenu() throws TechniqueException {
		s.reset();

		int selection = -1;

		while (selection != 0) {

			ListerRencontres();

			System.out.println("Choisir une rencontre pour saisir des pronostics (0 pour retourner au main menu):");

			selection = s.nextInt();

			if (selection != 0) {

				Rencontre rencontre = rencontreService.getRencontrebyId(selection).get();
				System.out.println("Pronostic du match : " + rencontre.getPays_1().getNom() + "  VS" + " "
						+ rencontre.getPays_2().getNom());
				Pronostic pronostic = new Pronostic();
				pronostic.setSalarie(salarie);
				pronostic.setRencontre(rencontre);

				System.out.println(rencontre.getPays_1().getNom() + " buts => ");
				pronostic.setBut_1(s.nextInt());

				System.out.println(rencontre.getPays_2().getNom() + " buts => ");
				pronostic.setBut_2(s.nextInt());

				pronosticService.create(pronostic);

			}

		}

	}

	private static void getSalarie() throws TechniqueException {
		s.reset();
		System.out.println("svp entrer votre nom");

		String nom = s.nextLine();

		salarie = salarieService.getSalariebyUsername(nom).get();

	}

	private static void ListerRencontres() throws TechniqueException {
		System.out.println("Les rencontres prochin :");

		rencontres = rencontreService.getAll();
		rencontres.forEach(r -> System.out
				.println("[" + r.getId() + "]- " + r.getPays_1().getNom() + "  VS" + " " + r.getPays_2().getNom()));
	}

	private static void ListerPronostics() throws TechniqueException {
		System.out.println("Vos pronostics :");

		pronostics = pronosticService.getAllBySalarieId(salarie.getId());
		pronostics.forEach(p -> System.out.println("[" + p.getId() + "] - " + p.getRencontre().getPays_1().getNom()
				+ "  " + p.getBut_1() + " - " + p.getBut_2() + "  " + p.getRencontre().getPays_2().getNom()));

		System.out.println("tapez 0 pour retourner au main menu : ");
		s.reset();
		s.nextInt();

	}

}
