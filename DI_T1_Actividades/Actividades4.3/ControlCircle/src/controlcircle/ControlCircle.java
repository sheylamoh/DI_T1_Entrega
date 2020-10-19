/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlcircle;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle;
/**
 *
 * @author 6teme
 */
public class ControlCircle extends Application 
{
    private CirclePane circlePane = new CirclePane();
    
    @Override
    public void start(Stage primaryStage) 
    {
        HBox hBox = new HBox();
        
        // botones 
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);
        
        btEnlarge.setOnAction(new EnlargeHandler());
        btShrink.setOnAction(new ShrinkHandler());
        hBox.setAlignment(Pos.CENTER);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("Control Circle");
        primaryStage.setScene(scene); 
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
    // inner class
    class EnlargeHandler implements EventHandler<ActionEvent> 
    {
        @Override
        public void handle(ActionEvent e) 
        {
            circlePane.enlarge();
        }
    }
    
    class ShrinkHandler implements EventHandler<ActionEvent> 
    {
        @Override
        public void handle(ActionEvent e) 
        {
            circlePane.shrink();
        }
    }
}

    // panel del circulo para agrandar y reducir 
    class CirclePane extends StackPane 
    {
        private Circle circle = new Circle(30);  // tamaño circulo inicial
    
        public CirclePane() 
        {
            getChildren().add(circle);
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.PINK);
        }
        public void enlarge() 
        {
            circle.setRadius(circle.getRadius() + 1);
        }
        public void shrink() 
        {
            circle.setRadius(circle.getRadius() > 1 ? circle.getRadius() - 1 : circle.getRadius());
        }
    }

