package ihm;
import javafx.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class JeuIHM  extends Application
{
	public static void main(String[] args)
	{
        System.out.println( "Main method inside Thread : " +  Thread.currentThread().getName());
        launch(args);
    }

	 @Override
	    public void start(Stage stage) throws Exception {
	        // d�finit la largeur et la hauteur de la fen�tre
	        // en pixels, le (0, 0) se situe en haut � gauche de la fen�tre
	          stage.setWidth(800);
	        stage.setHeight(600);
	        // met un titre dans la fen�tre
	        stage.setTitle("La bite chantilly");

	        // la racine du sceneGraph est le root
	        Group root = new Group();
	        Scene scene = new Scene(root);
	        scene.setFill(Color.SKYBLUE);
	        
	        // cr�ation du soleil
	        Circle sun = new Circle(60, Color.web("yellow", 0.8));
	        sun.setCenterX(600);
	        sun.setCenterY(100);
	     
	        // cr�ation du sol
	        Rectangle ground = new Rectangle(0, 400, 800, 200);
	        ground.setFill(Color.GREEN);
	        
	        // cr�ation d'un �l�ment plus complexe, le panneau
	        Group sign = new Group();
	        sign.setTranslateX(150);
	        sign.setTranslateY(200);
	        // Attention les coordonn�es sont celles du panneau, pas de la sc�ne
	        Text text = new Text(10, 30, "Yop coucou");
	        text.setFont(new Font(80));
	        text.setFill(Color.WHITE);
	        // le rep�re utilis� est celui du panneau
	        Rectangle panel = new Rectangle( 0, -50, 510, 110);
	        panel.setFill(Color.DARKBLUE);
	       
	        //Vertical separator
	        Separator separator2 = new Separator();
	        separator2.setMaxWidth(40);
	        separator2.setHalignment(HPos.LEFT);
	        separator2.setOrientation(Orientation.VERTICAL);
	        
	        // composer l'�l�ment plus complexe
	        sign.getChildren().add(panel);
	        sign.getChildren().add(text);

	        // ajout de tous les �l�ments de la sc�ne
	        root.getChildren().add(sun);
	        root.getChildren().add(ground);
	        root.getChildren().add(sign);
	        
	        // ajout de la sc�ne sur l'estrade
	        stage.setScene(scene);
	        // ouvrir le rideau
	        stage.show();
	    }

}