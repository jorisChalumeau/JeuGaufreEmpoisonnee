package controle;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;
import ihm.FenetreIHM;


public class joueursControle implements EventHandler<MouseEvent> {

    FenetreIHM app;
    int[] coord;

    public joueursControle(FenetreIHM a, int[] c) {
        app = a;
        coord = c;
    }
    
    @Override
    public void handle(MouseEvent event) {
    	System.out.println(coord[0] + ", " + coord[1]);
    	
    	// on stocke les coordonnées du coup jouer dans FenetreIHM
        app.setCoup(coord);
        app.notify();
    }
}
