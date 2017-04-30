package contenu;

/**
 * Déroulement d'une partie
 * @author jo_ch
 *
 */
public class Partie {
	
	private Gaufre gaufre;
	private Joueur joueur1;
	private Joueur joueur2;
	private int tour = 1;
	private Joueur joueurActuel;
	
	public Partie(int nbLignes, int nbColonnes){
		this.gaufre = new Gaufre(nbLignes, nbColonnes);
		
		this.joueur1 = new Joueur();
		this.joueur2 = new Joueur();
		this.joueurActuel = joueur1;
	}
	
	
	/**
	 * précondition : la cellule peut être mangée
	 * post-condition : la cellule (i,j) a été mangée (ainsi que toutes les cellules en dessous à droite) par le joueur j
	 * @param numLigne
	 * @param numColonne
	 */
	public void mangerCellule(int numLigne, int numColonne){
		
		if(!this.gaufre.peutEtreMange(numLigne, numColonne)) 
			return;
		
		for(int ligne = 0 ; ligne < this.gaufre.getNbLignes() ; ligne++){
				for(int colonne = 0 ; colonne < this.gaufre.getNbColonnes() ; colonne++){
					if(ligne >= numLigne && colonne >= numColonne)
						this.gaufre.getTabGaufre()[ligne][colonne].setEtat(true);
			}
		}
		
		String numJoueur;
		if(this.joueurActuel == this.joueur2) {
			numJoueur="2";
		}
		else {
			numJoueur="1";
		}
		
		if(PoisonEstMange()){
			System.out.println("le " + joueurActuel.toString() + numJoueur + " a perdu :/");
			return;}
		
		//Changement de joueur
		if(this.joueurActuel == this.joueur2) {
			this.tour++;
			this.joueurActuel =  this.joueur1;
		}
		else {
			this.joueurActuel = this.joueur2;
		}
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
	
	public int GetNbLigne(){
		return this.gaufre.getNbLignes();
	}

	public int GetNbColonne(){
		return this.gaufre.getNbColonnes();
	}
}
