package pathtransitionanimation;

import static java.awt.Color.blue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PathTransitionAnimation extends Application {
    
    @Override
   public void start(Stage stage) throws Exception {
        
        Circle circle = new Circle(125,100,50);
        Rectangle rectangle=new Rectangle(10,25,Color.PINK);
        Group root=new Group();
        PathTransition pt = new PathTransition();
        
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circle);
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play(); 
        
        
        //Controles de la animacion
        circle.setOnMousePressed(e -> pt.pause());
        circle.setOnMouseReleased(e -> pt.play());
        
        root.getChildren().add(circle);
        root.getChildren().add(rectangle);
        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Circulo");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
