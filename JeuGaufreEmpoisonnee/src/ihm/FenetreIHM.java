package ihm;

import java.util.Scanner;

import contenu.Cellule;
import contenu.Gaufre;
import contenu.Joueur;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FenetreIHM implements AffichageIHM {
	Gaufre gaufre;
	Stage stage;
	
	public FenetreIHM(Gaufre g, Stage stage){
		this.gaufre = g;
		this.stage = stage;
		initialiserFenetre(stage);
	}

	@Override
	public void bienvenu() {
		final Alert alert = new Alert(Alert.AlertType.INFORMATION);  
		alert.initOwner(this.stage); 
		alert.setTitle("Bienvenu");
		alert.setContentText("Debut d'une nouvelle partie de Gaufre empoisonnee"); 
		alert.showAndWait();
	}

	@Override
	public void afficheGaufre() {
//		System.out.println(this.gaufre);
	}

	@Override
	public int[] demandeCoup() {
		// Lorsqu'un joueur clique sur une case
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir numLigne et numCol : ");
		
		// convertir la case en coordonnées x et y
		return new int[]{sc.nextInt(), sc.nextInt()};
	}

	@Override
	public void affichePerdant(Joueur j, int tour) {
		final Alert alert = new Alert(Alert.AlertType.INFORMATION);  
		alert.initOwner(this.stage); 
		alert.setTitle("Fin de la partie");
		alert.setContentText("le " + j + " a perdu en " + tour + " tours"); 
		alert.showAndWait();
		
		// on quitte lorsque le joueur appuie sur OK
		Platform.exit();
	}
	
	@Override
	public void debutTour(Joueur j, int tour) {
		final Alert alert = new Alert(Alert.AlertType.INFORMATION);  
		alert.initOwner(this.stage); 
		alert.setTitle("Fin de la partie");
		alert.setContentText("Tour : " + tour + "\nAu " + j + " de jouer\nCliquer sur une cellule pour la manger"); 
		alert.showAndWait();
	}
	
	// initialise l'interface graphique ainsi que tous ses composants
	private void initialiserFenetre(Stage stage2) {
		// définit la largeur et la hauteur de la fenêtre
		// en pixels, le (0, 0) se situe en haut à gauche de la fenêtre
		this.stage.setWidth(1024);
		this.stage.setHeight(768);
		this.stage.setMaxWidth(1024);
		this.stage.setMaxHeight(768);
		this.stage.setMinWidth(1024);
		this.stage.setMinHeight(768);
		// met un titre dans la fenêtre
		this.stage.setTitle("Gaufre empoisonnee");

		// la racine du sceneGraph est le root
		Group root = new Group();
		Scene scene = new Scene(root);
		scene.setFill(Color.WHEAT);
		
		// création zone joueur 1
		Rectangle j1 = new Rectangle(5, 95, 246, 250);
		j1.setArcHeight(20);
		j1.setArcWidth(20);
		j1.setFill(Color.DARKGRAY);

		// création zone joueur 2
		Rectangle j2 = new Rectangle(5, 375, 246, 250);
		j2.setArcHeight(20);
		j2.setArcWidth(20);
		j2.setFill(Color.DARKGRAY);

		// création de la zone qui contient la gaufre
		Group zoneGaufre = new Group();
		zoneGaufre.setTranslateX(260);
		zoneGaufre.setTranslateY(60);
		// pour délimiter la zone de la gaufre
		Rectangle rectGaufre = new Rectangle(0, 0, 740, 600);
		rectGaufre.setFill(Color.WHITE);

		Rectangle[] tabGaufre = this.genererTabGaufre();

		// ajouter le fond de la zoneGaufre
		zoneGaufre.getChildren().add(rectGaufre);
		// ajouter toutes les cellules à la Gaufre
		zoneGaufre.getChildren().addAll(tabGaufre);

		// ajout de tous les éléments de la scène
		root.getChildren().add(j1);
		root.getChildren().add(j2);
		root.getChildren().add(zoneGaufre);

		// ajout de la scène sur l'estrade
		this.stage.setScene(scene);
		// ouvrir le rideau
		this.stage.show();
	}
	
	private Rectangle[] genererTabGaufre() {
		// TODO Auto-generated method stub
//		Rectangle[] tableauDeCase = null;
//		Cellule c;
//		int k=0;
//		for(int i=0; i<this.gaufre.getNbColonnes();i++){
//			for(int j=0; j<this.gaufre.getNbLignes();j++){
//				x,y a recalculer a chaque fois 
//				tableauDeCase[k] = new Rectangle(x,y,largeur,longueur);
//				k++;
//			}
//		}
//		return tableauDeCase;
		return null;
	}
}
