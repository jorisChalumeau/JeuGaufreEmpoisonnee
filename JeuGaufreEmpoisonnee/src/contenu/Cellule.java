package contenu;

public class Cellule {
	
	private int valeur;
	private int etat;
	
	public Cellule(int numLigne, int numColonne){
		this.valeur = (int) Math.pow(3, numLigne) * (int) Math.pow(2, numColonne);
		this.etat = 1;
	}
	
	public int getValeur(){
		return this.valeur;
	}
	
	public int getEtat(){
		return this.etat;
	}
	
	public void setEtat(int etat){
		this.etat = etat;
	}
}
