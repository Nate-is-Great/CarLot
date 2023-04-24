/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.car;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author AlexC
 */
public class CarView extends VBox{
    // Reference for each Pane
    private final CarTable carTable;
    private final CarForm carForm;
    
    //Reference for each button
    private final Button updateBtn;
    private final Button cancelBtn;
    
    //Reference for error msg Text
    private Text errorMessage;
    
    //Constuctor with layout info
    public CarView(){
        
        //Title
        Text title = new Text("CarLot Inventory");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));  
    
        //New CarTable
        carTable = new CarTable();
        
        //New CarForm
        carForm = new CarForm(); 
      
         //Create pane for buttons
        HBox buttonPane = new HBox();
        
        //Add buttons to pane
        buttonPane.getChildren().addAll(cancelBtn = new Button("Cancel"), updateBtn = new Button("Update"));
        
        //Style buttons
        updateBtn.setPrefWidth(150.0);
        cancelBtn.setPrefWidth(150.0);
        
        //Style button pane
        buttonPane.setSpacing(20);
        buttonPane.setAlignment(Pos.CENTER);
        
        //This Pane extends VBox so I can use "this" for styling CarView
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20.0));
        this.setSpacing(20);
            
        //Add to CarView
        this.getChildren().addAll(title, carTable, carForm, buttonPane);
    
    }

    //Getters for Attributes
    public CarTable getCarTable() {
        return carTable;
    }

    public CarForm getCarForm() {
        return carForm;
    }

    public Button getUpdateBtn() {
        return updateBtn;
    }

    public Button getCancelBtn() {
        return cancelBtn;
    }

    public Text getErrorMessage() {
        return errorMessage;
    }
    
}

