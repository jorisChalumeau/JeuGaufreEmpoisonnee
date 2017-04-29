package contenu;

/**
 * Déroulement d'une partie
 * @author jo_ch
 *
 */
public class Partie {
	
	private Gaufre gaufre;
	private Joueur j1;
	private Joueur j2;
	
	public Partie(int nbLignes, int nbColonnes){
		this.gaufre = new Gaufre(nbLignes, nbColonnes);
		
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
	}
	
	
	/**
	 * précondition : la cellule peut être mangée
	 * post-condition : la cellule (i,j) a été mangée (ainsi que toutes les cellules en dessous à droite) par le joueur j
	 * @param numLigne
	 * @param numColonne
	 */
	public void mangerCellule(Joueur j, int numLigne, int numColonne){
		for(int ligne = 0 ; ligne < this.gaufre.getNbLignes() ; ligne++){
			for(int colonne = 0 ; colonne < this.gaufre.getNbColonnes() ; colonne++){
				if(ligne >= numLigne && colonne >= numColonne)
					this.gaufre.getTabGaufre()[ligne][colonne].setEtat(false);
			}
		}
	}
	
	public Gaufre getGaufre() {
		return gaufre;
	}


	public Joueur getJ1() {
		return j1;
	}


	public Joueur getJ2() {
		return j2;
	}
}
