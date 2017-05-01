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
    String etat;

    public joueursControle(FenetreIHM a, String e) {
        app = a;
        etat = e;
    }
    
    @Override
    public void handle(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        System.out.println("clic en ("+x+","+y+"), etat :"+etat);
        //app.message = "clic en ("+x+","+y+"), etat :"+etat;

    }
}
