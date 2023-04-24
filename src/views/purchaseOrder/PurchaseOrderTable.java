/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.purchaseOrder;

import javafx.scene.layout.HBox;

import java.time.LocalDate;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.PurchaseOrder;

/**
 *
 * @author Kevin McAlister
 */
public class PurchaseOrderTable extends HBox{
    // TableView Reference
    private final TableView<PurchaseOrder> table;
    
    // Table Column References (Integer id, LocalDate datePurchased, 
    // String vin, Integer year, String make, String model, String color, 
    // Integer mileage, Integer mpg, Double cost)
	private final TableColumn<PurchaseOrder, Integer> id;
	private final TableColumn<PurchaseOrder, LocalDate> datePurchased;
	private final TableColumn<PurchaseOrder, String> vin;
	private final TableColumn<PurchaseOrder, Integer> year;
	private final TableColumn<PurchaseOrder, String> make;
	private final TableColumn<PurchaseOrder, String> model;
	private final TableColumn<PurchaseOrder, String> color;
	private final TableColumn<PurchaseOrder, Integer> mileage;
	private final TableColumn<PurchaseOrder, Integer> mpg;
	private final TableColumn<PurchaseOrder, Double> cost;
    
    
    
    public PurchaseOrderTable(){
    
        //New TableView
        table = new TableView();
        
        //Create the new Table Columns
        id = new TableColumn<>("ID");
        datePurchased = new TableColumn<>("Purchase Date");
        vin = new TableColumn<>("VIN");
        year = new TableColumn<>("Year");
        make = new TableColumn<>("Make");
        model = new TableColumn<>("Model");
        color = new TableColumn<>("Color");
        mileage = new TableColumn<>("Mileage");
        mpg = new TableColumn<>("MPG");
        cost = new TableColumn<>("Cost");
        
        //Set Column Min Width
        id.setMinWidth(100.00);
        datePurchased.setMinWidth(100.00);
        vin.setMinWidth(150.00);
        year.setMinWidth(75.0);
        make.setMinWidth(100.00);
        model.setMinWidth(150.0);
        color.setMinWidth(75.00);
        mileage.setMinWidth(100.00);
        mpg.setMinWidth(75.0);
        cost.setMinWidth(100.00);
        
        
        //Get column cell values from PurchaseOrder data model 
            // For properties that can be retrieved directly use:
            // id.setCellValueFactory(new PropertyValueFactory<> ("id"));
            // For the properties that have to retrieved from the Car Attribute use: 
            // ex: vin.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getCar().getVin()));
        id.setCellValueFactory(new PropertyValueFactory<> ("id"));
        datePurchased.setCellValueFactory(new PropertyValueFactory<> ("datePurchased"));
        vin.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getCar().getVin()));
        year.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getCar().getYear()));
        make.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getCar().getMake()));
        model.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getCar().getModel()));
        color.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getCar().getColor()));
        mileage.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getCar().getMileage()));
        mpg.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getCar().getMpg()));
        cost.setCellValueFactory(new PropertyValueFactory<> ("cost"));
        
        
        //Add columns to table
        table.getColumns().add(id);
        table.getColumns().add(datePurchased);
        table.getColumns().add(vin);
        table.getColumns().add(year);
        table.getColumns().add(make);
        table.getColumns().add(model);
        table.getColumns().add(color);
        table.getColumns().add(mileage);
        table.getColumns().add(mpg);
        table.getColumns().add(cost);
        
        //Gid rid of extra column created
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        //Add table to this pane
        this.getChildren().add(table);
        
        //Set Pane styles
        this.setAlignment(Pos.CENTER);
        
    }
    
    // Creater getter for table
    public TableView<PurchaseOrder> getTable() {
    	return this.table;
    }
}
