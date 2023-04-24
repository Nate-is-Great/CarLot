/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.purchaseOrder;

import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author AlexC, KevinM
 */
public class PurchaseOrderForm extends HBox{
   
    private final TextField cost = new TextField();
    private final TextField vin = new TextField();
    private final TextField year = new TextField();
    private final TextField make = new TextField();
    private final TextField model = new TextField();
    private final TextField color = new TextField();
    private final TextField mileage = new TextField();
    private final TextField mpg = new TextField();
    private final TextField salesPrice = new TextField();
    
    //DatePicker Reference (datePurchased)
    private final DatePicker datePurchased = new DatePicker();
    
    
    public PurchaseOrderForm(){
        
        //New GridPane
        GridPane grid = new GridPane();
        
        //Grid Styles
        grid.setHgap(20);
        grid.setVgap(15);
        
        // Add Labels and Textfields to Grid with add(Node, col index, row index)
            //Row 0: datePurchased label/datepicker, cost label/textfield 
            //Row 1: vin label/textfield, year label/textfield, make label/textfield, model label/textfield
            //Row 2: color label/textfield, mileage label/textfield, mpg label/textfield, salesPrice label/textfield 
        grid.add(new Label("Date Purchased:"), 0, 0);
        grid.add(datePurchased, 1, 0);
        grid.add(new Label("Cost:"), 2, 0);
        grid.add(cost, 3, 0);
        
        grid.add(new Label("VIN:"), 0, 1);
        grid.add(vin, 1, 1);
        grid.add(new Label("Year:"), 2, 1);
        grid.add(year, 3, 1);
        grid.add(new Label("Make:"), 4, 1);
        grid.add(make, 5, 1);
        grid.add(new Label("Model:"), 6, 1);
        grid.add(model, 7, 1);
        
        grid.add(new Label(""), 0, 2);
        grid.add(color, 1, 2);
        grid.add(new Label(""), 2, 2);
        grid.add(mileage, 3, 2);
        grid.add(new Label(""), 4, 2);
        grid.add(mpg, 5, 2);
        grid.add(new Label(""), 6, 2);
        grid.add(salesPrice, 7, 2);
        
        
        
        //Add grid to this pane
        getChildren().add(grid);
        
      
        //Set PurchaseOrderForm Styles (padding at 20, create border)
        setPadding(new Insets(20));
        setStyle("-fx-border-color: gray; -fx-border-width: 5px;");
    }
    
    // Getters for all TextFields and the DatePicker
    public TextField getCost() {
    	return cost;
    }
    
    public TextField getVin() {
    	return vin;
    }
    
    public TextField getYear() {
    	return year;
    }
    
    public TextField getMake() {
    	return make;
    }
    
    public TextField getModel() {
    	return model;
    }
    
    public TextField getColor() {
    	return color;
    }
    
    public TextField getMileage() {
    	return mileage;
    }
    
    public TextField getMpg() {
    	return mpg;
    }
    
    public TextField getSalesPrice() {
    	return salesPrice;
    }
    
    public DatePicker getDatePurchased() {
    	return datePurchased;
    }
}
