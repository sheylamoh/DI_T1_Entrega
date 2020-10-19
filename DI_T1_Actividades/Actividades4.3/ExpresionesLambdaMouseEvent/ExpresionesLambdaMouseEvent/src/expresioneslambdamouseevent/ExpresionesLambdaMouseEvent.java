package expresioneslambdamouseevent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 6teme
 */
public class ExpresionesLambdaMouseEvent extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {
        
        Pane root = new Pane();
        
        Text texto = new Text("Programming is fun");
        root.getChildren().add(texto);
        
        // expresion lambda para mover el texto 
        texto.setOnMouseDragged(e -> {
            
            // posiciones vertical y horizontal para seguir el raton
            texto.setX(e.getX());
            texto.setY(e.getY());

        });
        
        Scene scene = new Scene(root, 300, 250);
        
        texto.setX(scene.getWidth()/2);
        texto.setY(scene.getHeight()/2);
        
        primaryStage.setTitle("Mouse Event");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
