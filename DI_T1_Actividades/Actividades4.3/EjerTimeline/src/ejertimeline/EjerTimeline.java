
package ejertimeline;

import com.sun.javafx.perf.PerformanceTracker;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class EjerTimeline extends Application 
{
   public static double bola1 = 1;
   public static double bola2 = 1;
   
    @Override
    public void start(Stage primaryStage) 
    {
       
        Group pane = new Group();
        
        // creamos la bola
        Circle ball = new Circle(10);
        ball.setTranslateX(300 * 0.5);
        ball.setTranslateY(250 * 0.5);
        
        pane.getChildren().addAll(ball);
        
        // frames por segundo
        Label label = new Label();
        label.setTranslateX(10);
        label.setTranslateY(10);
        
        pane.getChildren().addAll(label);
        
        Scene scene = new Scene(pane, 300, 250);
       
        // lambda
        EventHandler<ActionEvent> eH = e -> 
        {
            PerformanceTracker perfTracker =
            PerformanceTracker.getSceneTracker(scene);
            label.setText("FPS (Timeline) = " + perfTracker.getInstantFPS());
            // cambia la dirección
            if(ball.getTranslateX() < 0 || ball.getTranslateX() > 300) {
            bola1 *= -1;        
            }
       
            if(ball.getTranslateY() < 0 || ball.getTranslateY() > 250) {
            bola2 *= -1;       
            }
       
            ball.setTranslateX(ball.getTranslateX() + bola1);
            ball.setTranslateY(ball.getTranslateY() + bola2);
        };
        
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(0.8), eH));
        animation.setCycleCount(Timeline.INDEFINITE);
        
        animation.play(); // inicio de animación

        primaryStage.setTitle("Timeline");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
