/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresioneslambdaactionevent;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 6teme
 */
public class ExpresionesLambdaActionEvent extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {
         GridPane grid = new GridPane();
         
        // campo de anual
        Label annual = new Label("Annual Interest Rate");
        grid.add(annual, 0, 0);

        TextField annualTextField = new TextField();
        grid.add(annualTextField, 1, 0);
        
        // campo de number
        Label number = new Label("Number of Years");
        grid.add(number, 0, 1);
        
        TextField numberTextField = new TextField();
        grid.add(numberTextField, 1, 1);
        
        // campo de loan
        Label loan = new Label("Loan Amount");
        grid.add(loan, 0, 2);
        
        TextField loanTextField = new TextField();
        grid.add(loanTextField, 1, 2);
        
        // campo de monthly
        Label monthly = new Label("Monthly Payment");
        grid.add(monthly, 0, 3);
        
        TextField monthlyTextField = new TextField();
        grid.add(monthlyTextField, 1, 3);
        
        // campo de total
        Label total = new Label("Total Payment");
        grid.add(total, 0, 4);
        
        TextField totalTextField = new TextField();
        grid.add(totalTextField, 1, 4);
        
        // botón de calculate
        Button calculate = new Button("Calculate");
        grid.add(calculate, 1, 5);
        
        grid.setAlignment(Pos.CENTER);
        
        // expresión lambda
        calculate.setOnAction((ActionEvent e) -> {
             // declaración de variables
             double i;  // interés
             double n;  // número de años
             double h;  // cantidad hipotecada
             double m;  // cuota mensual
             double r;  
             
             // pasa los textfield a las variables de tipo double
             i = Double.parseDouble(annualTextField.getText());
             n = Double.parseDouble(numberTextField.getText());
             h = Double.parseDouble(loanTextField.getText());
             
             r = i / (100 * 12);
             m = (h * r) / (1 - Math.pow(1 + r, -12 * n));
             
             DecimalFormat df = new DecimalFormat("#.##");
             
             monthlyTextField.setText(df.format(m) + " ");
             totalTextField.setText(df.format(m * 12 * n) + " ");
             
         });
        
        
        Scene scene = new Scene(grid, 300, 250);
        
        
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
