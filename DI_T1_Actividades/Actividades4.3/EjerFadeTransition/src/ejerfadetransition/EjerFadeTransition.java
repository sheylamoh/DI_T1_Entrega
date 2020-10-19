package ejerfadetransition;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;


public class EjerFadeTransition extends Application {
    
   @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Ellipse ellipse = new Ellipse(150, 125, 100, 50);
        // Applica una fade transition a elipse
        ellipse.setFill(Color.PINK);
        ellipse.setStroke(Color.PURPLE);
        FadeTransition ft = new FadeTransition(Duration.millis(3000), ellipse);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play(); 
        
        // control de animation
        ellipse.setOnMousePressed(e -> ft.pause());
        ellipse.setOnMouseReleased(e -> ft.play());
        root.getChildren().add(ellipse);
        
        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Ellipse");
        stage.setScene(scene);
        stage.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }
    
}

