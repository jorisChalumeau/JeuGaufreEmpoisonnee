package ihm;

import contenu.Joueur;

public interface AffichageIHM {
	public void bienvenu();
	public void afficheGaufre();
	public int[] demandeCoup();
	public void affichePerdant(Joueur j, int tour);
	public void debutTour(Joueur j, int tour);
}
