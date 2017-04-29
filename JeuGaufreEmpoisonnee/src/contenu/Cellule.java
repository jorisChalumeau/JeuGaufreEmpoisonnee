package contenu;

public class Cellule {
	
//	private int valeur;
	private boolean etat;
	
	public Cellule(int numLigne, int numColonne){
//		this.valeur = (int) Math.pow(3, numLigne) * (int) Math.pow(2, numColonne);
		this.etat = true;
	}
	
//	public int getValeur(){
//		return this.valeur;
//	}
	
	public boolean getEtat(){
		return this.etat;
	}
	
	public void setEtat(boolean etat){
		this.etat = etat;
	}
}
