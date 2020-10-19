package lambdakeyevent;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class LambdaKeyEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       Text letra = new Text(20, 20, "A");
        Pane root = new Pane();
        root.getChildren().add(letra);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Key Event");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.setOnKeyPressed(e -> {
            KeyCode key = e.getCode();
            
            if (key==key.UP)
            {
                if(letra.getY()<20) 
                    return;
                else 
                    letra.setY(letra.getY()-10);
            }
            
             if (key==key.DOWN)
            {
                if(letra.getY()<20) 
                    return;
                else 
                    letra.setY(letra.getY()+10);
            }
             
              if (key==key.LEFT)
            {
                if(letra.getX()<20) 
                    return;
                else 
                    letra.setX(letra.getX()-10);
            }
            
               if (key==key.RIGHT)
            {
                if(letra.getX()<-20) 
                    return;
                else 
                    letra.setX(letra.getX()+10);
            }
            
            
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
