/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.purchaseOrder;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


/**
 *
 * @author AlexC
 */
public class PurchaseOrderView extends VBox{
    //References for PurchaseOrderTable purchaseOrderTable, PurchaseOrderForm purchaseOrderForm
	private final PurchaseOrderTable purchaseOrderTable;
	private final PurchaseOrderForm purchaseOrderForm;
    
     //References for TextField salesPrice
	private final TextField salesPrice;
	private final Label salesPriceLabel; // Necessary for the
    
    //References for Buttons add ToInventoryBtn, Button cancelBtn
	private final Button toInventoryBtn;
	private final Button cancelBtn;
    
    //Reference for error message text: Text errorMessage
    private Text errorMessage;
    
    //Constructor
    public PurchaseOrderView(){
        //Create Title
		Text title = new Text("Purchase Order");
		title.setFont(Font.font("Ariel", 30));
		
        //Create PurchaseOrderTable for the Attribute Reference
		purchaseOrderTable = new PurchaseOrderTable();
    
        //Create PurchaseOrderForm for the Attribute Reference
		purchaseOrderForm = new PurchaseOrderForm();
        
        //Create HBox for error message Text
		HBox errorMessagePane = new HBox();
    
        //Set error message HBox Styles (alignment - center)
		errorMessagePane.setAlignment(Pos.CENTER);
    
        //Create Text object for error message
		errorMessage = new Text();
    
        //Set Text styles(Font(Arial,BOLD, 13), Fill(Color is red), Stroke(Color is red))
		errorMessage.setFont(Font.font("Arial, FontWeight.BOLD, 13"));
		errorMessage.setFill(Color.RED);
		errorMessage.setStroke(Color.RED);
    
        //Add Text to error message HBox
		errorMessagePane.getChildren().add(errorMessage);
        
        //Create HBox for the CarLot SalesPrice Label, SalesPrice TextField, and the two Buttons
		HBox salesPricePane = new HBox();
    
        //Add CarLot Sales Price Label, salesPrice TextField, addToInventoryBtn, and cancelBtn to the
        // HBox
		// label?
		salesPricePane.getChildren().addAll(salesPriceLabel = new Label("Sales Price"), salesPrice = new TextField("Sales Price"), toInventoryBtn = new Button("To Inventory"), cancelBtn = new Button("Cancel"));
    
        //Button Styles (PrefWidth - 150)
		toInventoryBtn.setPrefWidth(150);
		cancelBtn.setPrefWidth(150);
   
        //HBox Style (Spacing is 20)
		salesPricePane.setSpacing(20);
       
        
        //Set Styles for This Pane(Alignment - Center, Padding - new Insets 20, spacing - 20)
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20));
		this.setSpacing(20);
        
        //Add title, table, errorMessagePane, form, and salesPrice/ButtonPane to this pane
		this.getChildren().addAll(title, purchaseOrderTable, errorMessagePane, salesPricePane);
   
    }
        
    //Create Getters for Table, Form, Buttons, TextField, Text
    
    public PurchaseOrderTable getPurchaseOrderTable() {
    	return purchaseOrderTable;
    }
    
    public PurchaseOrderForm getPurchaseOrderForm() {
    	return purchaseOrderForm;
    }
    
    public Button getToInventoryBtn() {
    	return toInventoryBtn;
    }
    
    public Button getCancelBtn() {
    	return cancelBtn;
    }
    
    public TextField getSalesPrice() {
    	return salesPrice;
    }
    
    public Text errorMessage() {
    	return errorMessage;
    }
    
}
