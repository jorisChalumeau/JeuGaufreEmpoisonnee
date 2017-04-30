package contenu;

import java.util.Scanner;

import ihm.AffichageIHM;

/**
 * Déroulement d'une partie
 * 
 * @author jo_ch
 *
 */
public class Partie {

	private Gaufre gaufre;
	private Joueur joueur1;
	private Joueur joueur2;
	private int tour = 1;
	private Joueur joueurActuel;

	public Partie(int nbLignes, int nbColonnes) {
		this.gaufre = new Gaufre(nbLignes, nbColonnes);

		this.joueur1 = new Joueur(1);
		this.joueur2 = new Joueur(2);
		this.joueurActuel = joueur1;
	}

	public void lancerPartie(AffichageIHM ihm) {
		int[] coordonnees;
		
		ihm.bienvenu();

		while (!PoisonEstMange()) {
			ihm.afficheGaufre();
			ihm.debutTour(this.joueurActuel, this.tour);
			
			do {
				coordonnees = ihm.demandeCoup();
			} while (!mangerCellule(coordonnees[0], coordonnees[1]));

			if (!PoisonEstMange()) {

				// Changement de joueur
				if (this.joueurActuel == this.joueur2) {
					this.tour++;
					this.joueurActuel = this.joueur1;
				} else {
					this.joueurActuel = this.joueur2;
				}
			}
		}
		ihm.afficheGaufre();
		
		// afficher le perdant et finir la partie
		ihm.affichePerdant(this.joueurActuel, this.tour);
	}

	/**
	 * précondition : la cellule peut être mangée
	 * post-condition : la cellule (i,j) a été mangée par le joueur j
	 * (ainsi que toutes les cellules en dessous à droite)
	 * @param numLigne
	 * @param numColonne
	 */
	public boolean mangerCellule(int numLigne, int numColonne) {

		if (!this.gaufre.peutEtreMange(numLigne, numColonne))
			return false;

		for (int ligne = 0; ligne < this.gaufre.getNbLignes(); ligne++) {
			for (int colonne = 0; colonne < this.gaufre.getNbColonnes(); colonne++) {
				if (ligne >= numLigne && colonne >= numColonne)
					this.gaufre.getTabGaufre()[ligne][colonne].setEtat(true);
			}
		}

		return true;
	}

	public boolean PoisonEstMange() {
		return this.gaufre.getTabGaufre()[0][0].getEtat();
	}

	public Gaufre getGaufre() {
		return gaufre;
	}

	public Joueur GetJoueur() {
		return this.joueurActuel;
	}

	public int GetTour() {
		return this.tour;
	}

	public int GetNbLigne() {
		return this.gaufre.getNbLignes();
	}

	public int GetNbColonne() {
		return this.gaufre.getNbColonnes();
	}
}
