package ihm;

import java.util.Scanner;

import contenu.Gaufre;
import contenu.Joueur;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FenetreIHM implements AffichageIHM {
	private static final int LARG_ZONE = 740;
	private static final int HAUT_ZONE = 600;
	Gaufre gaufre;
	Stage stage;
	Rectangle[] tabRect;

	public FenetreIHM(Gaufre g, Stage stage) {
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
		// System.out.println(this.gaufre);
	}

	@Override
	public int[] demandeCoup() {
		// Lorsqu'un joueur clique sur une case
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir numLigne et numCol : ");
		int[] res = new int[] { sc.nextInt(), sc.nextInt() };
		sc.close();

		// convertir la case en coordonnées x et y
		return res;
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
		Rectangle rectGaufre = new Rectangle(0, 0, LARG_ZONE, HAUT_ZONE);
		rectGaufre.setFill(Color.WHITE);

		// ajouter le fond de la zoneGaufre
		zoneGaufre.getChildren().add(rectGaufre);
		// ajouter toutes les cellules à la Gaufre
		Text[] numerotation = this.genererTabGaufre();
		if (numerotation != null){
			zoneGaufre.getChildren().addAll(numerotation);
			zoneGaufre.getChildren().addAll(this.tabRect);
		}else {
			this.erreurCreation();
		}

		// ajout de tous les éléments de la scène
		root.getChildren().add(j1);
		root.getChildren().add(j2);
		root.getChildren().add(zoneGaufre);

		// ajout de la scène sur l'estrade
		this.stage.setScene(scene);
		// ouvrir le rideau
		this.stage.show();
	}

	private Text[] genererTabGaufre() {
		final int largeur = 50;
		final int hauteur = 60;
		final int debutX = 50;
		final int debutY = 50;
		int posX, posY, ind;

		tabRect = new Rectangle[this.gaufre.getNbLignes() * this.gaufre.getNbColonnes()];
		Text[] numerotation = new Text[this.gaufre.getNbLignes() + this.gaufre.getNbColonnes()];

		if (this.gaufre.getTabGaufre() != null) {

			// on génére le tableau de numérotation des lignes et colonnes
			posY = debutY + hauteur/2;
			posX = debutX - largeur/2;
			ind = 0;
			for (int i = 0; i < this.gaufre.getNbLignes(); i++) {
				numerotation[ind] = new Text(posX, posY, "" + i);
				posY += hauteur;
				ind++;
			}
			posY = debutY - 15;
			posX = debutX + 25;
			for (int j = 0; j < this.gaufre.getNbColonnes(); j++) {
				numerotation[ind] = new Text(posX, posY, "" + j);
				posX += largeur;
				ind++;
			}

			// on génére la gaufre
			posY = debutY;
			posX = debutX;
			ind = 0;
			for (int i = 0; i < this.gaufre.getNbLignes(); i++) {
				for (int j = 0; j < this.gaufre.getNbColonnes(); j++) {
					this.tabRect[ind] = new Rectangle(posX, posY, largeur, hauteur);
					this.tabRect[ind].setFill(Color.WHEAT);
					this.tabRect[ind].setStroke(Color.BEIGE);
					posX += largeur;
					ind++;
				}
				posX = debutX;
				posY += hauteur;
			}

			return numerotation;
		}

		return null;
	}

	private void erreurCreation() {
		final Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.initOwner(this.stage);
		alert.setTitle("Erreur");
		alert.setContentText("Erreur lors de la génération de la maquette du jeu.\nVeuillez relancer l'application");
		alert.showAndWait();
	}
}
