package contenu;

public class Cellule {
	
	int valeur;
	
	public Cellule(int numLigne, int numColonne){
		this.valeur = (int) Math.pow(3, numLigne) * (int) Math.pow(2, numColonne);
	}
	
	public int getValeur(){
		return this.valeur;
	}
}
