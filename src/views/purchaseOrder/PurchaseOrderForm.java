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
 * @author Padhmasri Baskaran
 */
public class PurchaseOrderForm extends HBox {

  // Textfields References (cost, vin, year, make, model, mileage, mpg)
  private final TextField vin;
  private final TextField year;
  private final TextField make;
  private final TextField model;
  private final TextField color;
  private final TextField mileage;
  private final TextField mpg;
  private final TextField cost;

  // DatePicker Reference (datePurchased)
  private final DatePicker datePurchased;

  public PurchaseOrderForm() {

    // New GridPane
    GridPane grid = new GridPane();

    // Grid Styles
    grid.setHgap(20.0);
    grid.setVgap(15.0);

    // Add Labels and Textfields to Grid with add(Node, col index, row index)
    // Row 0: datePurchased label/datepicker, cost label/textfield
    grid.add(new Label("Date Purchased"), 0, 0);
    grid.add(this.datePurchased = new DatePicker(), 1, 0);
    
    grid.add(new Label("cost: "), 2, 0);
    grid.add(cost = new TextField(), 3, 0);

    // Row 1: vin label/textfield, year label/textfield, make label/textfield, model
    // label/textfield

    grid.add(new Label("VIN:"), 0, 1);
    grid.add(vin = new TextField(), 1, 1);

    grid.add(new Label("Year:"), 2, 1);
    grid.add(year = new TextField(), 3, 1);

    grid.add(new Label("Make:"), 4, 1);
    grid.add(make = new TextField(), 5, 1);

    grid.add(new Label("Model:"), 6, 1);
    grid.add(model = new TextField(), 7, 1);

    // Row 2: color label/textfield, mileage label/textfield, mpg label/textfield,
    // salesPrice label/textfield

    grid.add(new Label("Color:"), 0, 2);
    grid.add(color = new TextField(), 1, 2);

    grid.add(new Label("Mileage:"), 2, 2);
    grid.add(mileage = new TextField(), 3, 2);

    grid.add(new Label("MPG HWY:"), 4, 2);
    grid.add(mpg = new TextField(), 5, 2);


    // Add grid to this pane
    this.getChildren().add(grid);

    // Set PurchaseOrderForm Styles (padding at 20, create border)
    this.setPadding(new Insets(20));
    this.setStyle("-fx-border-color: gray; -fx-border-width: 5px;");
  }

  // Getters for all TextFields and the DatePicker
  public DatePicker getDatePurchased() {
    return datePurchased;
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


  public TextField getCost() {
    return cost;
  }

}