package contenu;

public class Gaufre {
	int nbLignes;
	int nbColonnes;
	Cellule[][] gaufre;
	
	public Gaufre(int nbLignes, int nbColonnes){
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		
		// initialise toutes les cellules de la gaufre
		genererGaufre();
	}
	
	/**
	 *  initialise toutes les cellules de la gaufre
	 * @param nbLignes
	 * @param nbColonnes
	 */
	private void genererGaufre(){
		this.gaufre = new Cellule[this.nbLignes][this.nbColonnes];
		
		for(int ligne = 0 ; ligne < this.nbLignes ; ligne++){
			for(int colonne = 0 ; colonne < this.nbColonnes ; colonne++){
				this.gaufre[ligne][colonne] = new Cellule(ligne, colonne);
			}
		}
	}

	public String toString(){
		String affichage = "-";
		for(int colonne = 0 ; colonne < this.nbColonnes ; colonne++)
			affichage += "------";
		affichage += "\n";
		for(int ligne = 0 ; ligne < this.nbLignes ; ligne++){
			affichage += "|";
			for(int colonne = 0 ; colonne < this.nbColonnes ; colonne++){
				affichage += " " + String.format("%03d", this.gaufre[ligne][colonne].getValeur()) + " |";
			}
			affichage += "\n-";
			for(int colonne = 0 ; colonne < this.nbColonnes ; colonne++)
				affichage += "------";
			affichage += "\n";
		}
		
		return affichage;
	}
}
