/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.car;


import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import models.Car;

/**
 *
 * @author AlexC
 */
public class CarTable extends HBox{
    // TableView Reference 
   private final TableView<Car> table;
   
   //Table Column References
   private final TableColumn<Car, String> vin;
   private final TableColumn<Car, Integer> year;
   private final TableColumn<Car, String> make;
   private final TableColumn<Car, String> model;
   private final TableColumn<Car, String> color;
   private final TableColumn<Car, Integer> mileage;
   private final TableColumn<Car, Integer> mpg;
   private final TableColumn<Car, Double> salesPrice;
   
  
   public CarTable(){
       
       // New TableView
       table = new TableView();
       
       // Create Table Columns
       vin = new TableColumn<>("VIN");
       year = new TableColumn<>("Year");
       make = new TableColumn<>("Make");
       model = new TableColumn<>("Model");
       color = new TableColumn<>("Color");
       mileage = new TableColumn<>("Mileage");
       mpg = new TableColumn<>("MPG HWY");
       salesPrice = new TableColumn<>("Sales Price");
             
       //Set Column Min Width
       vin.setMinWidth(150.0);
       year.setMinWidth(75.0);
       make.setMinWidth(100.0);
       model.setMinWidth(150.0);
       color.setMinWidth(75.0);
       mileage.setMinWidth(100.0);
       mpg.setMinWidth(75);
       salesPrice.setMinWidth(100.0);
       
       // Get column cell values from Car data model
       vin.setCellValueFactory(new PropertyValueFactory<>("vin"));
       year.setCellValueFactory(new PropertyValueFactory<>("year"));
       make.setCellValueFactory(new PropertyValueFactory<>("make"));
       model.setCellValueFactory(new PropertyValueFactory<>("model"));
       color.setCellValueFactory(new PropertyValueFactory<>("color"));
       mileage.setCellValueFactory(new PropertyValueFactory<>("mileage"));
       mpg.setCellValueFactory(new PropertyValueFactory<>("mpg"));
       salesPrice.setCellValueFactory(new PropertyValueFactory<>("salesPrice"));
      
       
       //Add columns to table
       table.getColumns().add(vin);
       table.getColumns().add(year);
       table.getColumns().add(make);
       table.getColumns().add(model);
       table.getColumns().add(color);
       table.getColumns().add(mileage);
       table.getColumns().add(mpg);
       table.getColumns().add(salesPrice);
       
       //Get rid of extra column created
       table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       
       //This Pane extends HBox so I can add table directly to the carTablePane 
       this.getChildren().add(table);
       
       //Set Pane styles
       this.setAlignment(Pos.CENTER);
   
   
   }
   
  // Only need getter for table
   public TableView<Car> getTable(){
       return this.table;
   }
}
