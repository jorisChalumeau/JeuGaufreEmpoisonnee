package contenu;

public class Gaufre {
	private int nbLignes;
	private int nbColonnes;
	private Cellule[][] tabGaufre;
	
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
		this.tabGaufre = new Cellule[this.nbLignes][this.nbColonnes];
		
		for(int ligne = 0 ; ligne < this.nbLignes ; ligne++){
			for(int colonne = 0 ; colonne < this.nbColonnes ; colonne++){
				this.tabGaufre[ligne][colonne] = new Cellule(ligne, colonne);
			}
		}
	}
	
	/**
	 * renvoie true si le joueur a le droit de manger la cellule, false sinon
	 * @param numLigne
	 * @param numColonne
	 * @return
	 */
	public boolean peutEtreMange(int numLigne, int numColonne){
		// on vérifie que la cellule est dans la gaufre
		if(numLigne > this.nbLignes || numColonne > this.nbColonnes)
			return false;
		
		// on vérifie que la cellule n'est pas encore mangée
		if(!this.tabGaufre[numLigne][numColonne].getEtat())
			return false;
		
		return true;
	}
	
	public int getNbColonnes(){
		return this.nbColonnes;
	}
	
	public int getNbLignes(){
		return this.nbLignes;
	}
	
	public Cellule[][] getTabGaufre(){
		return this.tabGaufre;
	}

	public String toString(){
		String affichage = "-";
		for(int colonne = 0 ; colonne < this.nbColonnes ; colonne++)
			affichage += "----";
		affichage += "\n";
		for(int ligne = 0 ; ligne < this.nbLignes ; ligne++){
			affichage += "|";
			for(int colonne = 0 ; colonne < this.nbColonnes ; colonne++){
				//affichage += " " + String.format("%03d", this.gaufre[ligne][colonne].getValeur()) + " |";
				if(this.tabGaufre[ligne][colonne].getEtat())
					affichage += "   |";
				else
					affichage += " x |";
			}
			affichage += "\n-";
			for(int colonne = 0 ; colonne < this.nbColonnes ; colonne++)
				affichage += "----";
			affichage += "\n";
		}
		return affichage;
	}
}
