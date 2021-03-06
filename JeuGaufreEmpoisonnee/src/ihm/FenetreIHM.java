package ihm;

import java.util.Scanner;

import contenu.Gaufre;
import contenu.Joueur;
import controle.joueursControle;
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
	private static final int LARG_CELL = 50;
	private static final int HAUT_CELL = 60;
	private static final int OFF_X_CELL = 50;
	private static final int OFF_Y_CELL = 50;
	
	private Gaufre gaufre;
	private Stage stage;
	private Rectangle[] tabRect;
	private int[] coup;

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
//		// on efface les pr�c�dents coups
//		this.coup = null;
//		
//		// Lorsqu'un joueur clique sur une case
//		if(coup == null){
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return coup;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir numLigne et numCol : ");
		int[] res = new int[] { sc.nextInt(), sc.nextInt() };
		sc.close();

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
		// d�finit la largeur et la hauteur de la fen�tre
		// en pixels, le (0, 0) se situe en haut � gauche de la fen�tre
		this.stage.setWidth(1024);
		this.stage.setHeight(768);
		this.stage.setMaxWidth(1024);
		this.stage.setMaxHeight(768);
		this.stage.setMinWidth(1024);
		this.stage.setMinHeight(768);
		// met un titre dans la fen�tre
		this.stage.setTitle("Gaufre empoisonnee");

		// la racine du sceneGraph est le root
		Group root = new Group();
		Scene scene = new Scene(root);
		scene.setFill(Color.WHEAT);

		// cr�ation zone joueur 1
		Rectangle j1 = new Rectangle(5, 95, 246, 250);
		j1.setArcHeight(20);
		j1.setArcWidth(20);
		j1.setFill(Color.DARKGRAY);

		// cr�ation zone joueur 2
		Rectangle j2 = new Rectangle(5, 375, 246, 250);
		j2.setArcHeight(20);
		j2.setArcWidth(20);
		j2.setFill(Color.DARKGRAY);

		// cr�ation de la zone qui contient la gaufre
		Group zoneGaufre = new Group();
		zoneGaufre.setTranslateX(260);
		zoneGaufre.setTranslateY(60);
		// pour d�limiter la zone de la gaufre
		Rectangle rectGaufre = new Rectangle(0, 0, LARG_ZONE, HAUT_ZONE);
		rectGaufre.setFill(Color.WHITE);

		// ajouter le fond de la zoneGaufre
		zoneGaufre.getChildren().add(rectGaufre);
		// ajouter toutes les cellules � la Gaufre
		Text[] numerotation = this.genererTabGaufre();
		if (numerotation != null){
			zoneGaufre.getChildren().addAll(numerotation);
			zoneGaufre.getChildren().addAll(this.tabRect);
		}else {
			this.erreurCreation();
		}

		// ajout de tous les �l�ments de la sc�ne
		root.getChildren().add(j1);
		root.getChildren().add(j2);
		root.getChildren().add(zoneGaufre);

		// ajout de la sc�ne sur l'estrade
		this.stage.setScene(scene);
		// ouvrir le rideau
		this.stage.show();
	}

	private Text[] genererTabGaufre() {
		int posX, posY, ind;

		tabRect = new Rectangle[this.gaufre.getNbLignes() * this.gaufre.getNbColonnes()];
		Text[] numerotation = new Text[this.gaufre.getNbLignes() + this.gaufre.getNbColonnes()];

		if (this.gaufre.getTabGaufre() != null) {

			// on g�n�re le tableau de num�rotation des lignes et colonnes
			posY = OFF_Y_CELL + HAUT_CELL/2;
			posX = OFF_X_CELL - LARG_CELL/2;
			ind = 0;
			for (int i = 0; i < this.gaufre.getNbLignes(); i++) {
				numerotation[ind] = new Text(posX, posY, "" + i);
				posY += HAUT_CELL;
				ind++;
			}
			posY = OFF_Y_CELL - 15;
			posX = OFF_X_CELL + 25;
			for (int j = 0; j < this.gaufre.getNbColonnes(); j++) {
				numerotation[ind] = new Text(posX, posY, "" + j);
				posX += LARG_CELL;
				ind++;
			}

			// on g�n�re la gaufre
			posY = OFF_Y_CELL;
			posX = OFF_X_CELL;
			ind = 0;
			for (int i = 0; i < this.gaufre.getNbLignes(); i++) {
				for (int j = 0; j < this.gaufre.getNbColonnes(); j++) {
					this.tabRect[ind] = new Rectangle(posX, posY, LARG_CELL, HAUT_CELL);
					this.tabRect[ind].setFill(Color.WHEAT);
					this.tabRect[ind].setStroke(Color.BEIGE);
					this.tabRect[ind].setOnMousePressed(new joueursControle(this,new int[]{i, j}));
					posX += LARG_CELL;
					ind++;
				}
				posX = OFF_X_CELL;
				posY += HAUT_CELL;
			}

			return numerotation;
		}

		return null;
	}

	private void erreurCreation() {
		final Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.initOwner(this.stage);
		alert.setTitle("Erreur");
		alert.setContentText("Erreur lors de la g�n�ration de la maquette du jeu.\nVeuillez relancer l'application");
		alert.showAndWait();
	}

	public void setCoup(int[] coord) {
		this.coup = new int[]{coord[0], coord[1]};
	}
}
