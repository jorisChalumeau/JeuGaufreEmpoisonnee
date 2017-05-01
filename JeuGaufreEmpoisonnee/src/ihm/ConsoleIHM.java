package ihm;

import java.util.Scanner;

import contenu.Gaufre;
import contenu.Joueur;

public class ConsoleIHM implements AffichageIHM {
	Gaufre gaufre;
	
	public ConsoleIHM(Gaufre g){
		this.gaufre = g;
	}

	@Override
	public void bienvenu() {
		System.out.println("Debut d'une nouvelle partie de Gaufre empoisonnee");
	}

	@Override
	public void afficheGaufre() {
		System.out.println(this.gaufre);
	}

	@Override
	public int[] demandeCoup() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir numLigne et numCol : ");
		int[] res = new int[] { sc.nextInt(), sc.nextInt() };
		sc.close();

		return res;
	}

	@Override
	public void affichePerdant(Joueur j, int tour) {
		System.out.println("le " + j + " a perdu en " + tour + " tours");
	}

	@Override
	public void debutTour(Joueur j, int tour) {
		System.out.println("Tour : " + tour);
		System.out.println("Au " + j + " de jouer");
	}

}
