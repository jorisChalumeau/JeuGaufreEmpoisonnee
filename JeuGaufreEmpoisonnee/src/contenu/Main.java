package contenu;

import ihm.AffichageIHM;
import ihm.ConsoleIHM;
import ihm.FenetreIHM;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		int nbLignes, nbColonnes;
		String[] args = getParameters().getUnnamed().toArray(new String[0]);
		AffichageIHM ihm;
		boolean utiliserFenetre = false;
		
		if(args.length >= 2){
			nbLignes = Integer.parseInt(args[0]);
			nbColonnes = Integer.parseInt(args[1]);
			if(args.length >= 3){
				// si on a l'argument "fenetre", on lance l'application en mode fenetre, sinon on la lance en mode console
				utiliserFenetre = (args[2].equals("fenetres"));
			}
		} else {
			nbLignes = 6;
			nbColonnes = 8;
		}

		// initialisation de la partie, de la gaufre etc.
		Partie p = new Partie(nbLignes, nbColonnes);
		
		if(utiliserFenetre) {
			ihm = new FenetreIHM(p.getGaufre(), stage);
		} else {
			ihm = new ConsoleIHM(p.getGaufre());
		}
		if(!utiliserFenetre) {
			// En mode console on doit dire explicitement à JavaFX de se quitter.
			Platform.exit();
		}
		
		p.lancerPartie(ihm);
	}
	
	
}
