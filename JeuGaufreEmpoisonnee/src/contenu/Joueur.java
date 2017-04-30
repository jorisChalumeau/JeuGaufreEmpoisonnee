package contenu;

public class Joueur {
	private final int numJoueur;

	public Joueur(int numJ) {
		this.numJoueur = numJ;
	}

	public String toString() {
		String aff = "Joueur " + this.numJoueur;
		return aff;
	}

}
