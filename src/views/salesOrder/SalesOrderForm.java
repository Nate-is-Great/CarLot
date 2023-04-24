/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.salesOrder;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class SalesOrderForm extends HBox {

    //TextField References
    private final TextField tfVin = new TextField();
    private final TextField tfYear = new TextField();
    private final TextField tfMake = new TextField();
    private final TextField tfModel = new TextField();
    private final TextField tfColor = new TextField();
    private final TextField tfMileage = new TextField();
    private final TextField tfMpg = new TextField();
    private final TextField tfPriceSold = new TextField();

    //DatePicker Reference (dateSold)
    private final DatePicker dpDateSold = new DatePicker();

    //Car Button Reference
    private final Button btGetCar = new Button("Get Car");

    public SalesOrderForm(){

        //New GridPane
        GridPane grid = new GridPane();

        //Grid Styles
        grid.setHgap(20);
        grid.setVgap(15);

        // Add Labels and TextFields to Grid with add(Node, col index, row index)
        // Row 0: vin label, vin TextField, and Get Car Button
        grid.add(new Label("VIN:"), 0, 0);
        grid.add(tfVin, 1, 0);
        grid.add(btGetCar, 2, 0);
        // Row 1: year label/textfield, make label/textfield, model label/textfield
        grid.add(new Label("Year:"), 0, 1);
        grid.add(tfYear, 1, 1);
        grid.add(new Label("Make:"), 2, 1);
        grid.add(tfMake, 3, 1);
        grid.add(new Label("Model:"), 4, 1);
        grid.add(tfModel, 5, 1);
        // Row 2: color label/textfield, mileage label/textfield, mpg label/textfield
        grid.add(new Label("Color:"), 0, 2);
        grid.add(tfColor, 1, 2);
        grid.add(new Label("Mileage:"), 2, 2);
        grid.add(tfMileage, 3, 2);
        grid.add(new Label("MPG HWY:"), 4, 2);
        grid.add(tfMpg, 5, 2);
        // Row 3: dateSold label/DatePicker, priceSold label/textfield
        grid.add(new Label("Date Sold:"), 0, 3);
        grid.add(dpDateSold, 1, 3);
        grid.add(new Label("Price Sold:"), 2, 3);
        grid.add(tfPriceSold, 3, 3);

        //Make textfields year, make, model, color, mileage, mpg UNEDITABLE using following format:
        // year.setEditable(false);
        tfYear.setEditable(false);
        tfMake.setEditable(false);
        tfModel.setEditable(false);
        tfColor.setEditable(false);
        tfMileage.setEditable(false);
        tfMpg.setEditable(false);

        //Add grid to this pane
        getChildren().add(grid);

        //DO NOT STYLE GET CAR BUTTON

        //Styles for this pane (padding at 20, create border)
        setPadding(new Insets(20));
        setStyle("-fx-border-color: gray; -fx-border-width: 5px;");
    }

    //Getters for all TextFields, DatePicker, "Get Car" Button
    public TextField getVin() {
        return tfVin;
    }

    public TextField getYear() {
        return tfYear;
    }

    public TextField getMake() {
        return tfMake;
    }

    public TextField getModel() {
        return tfModel;
    }

    public TextField getColor() {
        return tfColor;
    }

    public TextField getMileage() {
        return tfMileage;
    }

    public TextField getMpg() {
        return tfMpg;
    }

    public TextField getPriceSold() {
        return tfPriceSold;
    }

    public DatePicker getDateSold() {
        return dpDateSold;
    }

    public Button getGetCar() {
        return btGetCar;
    }

}
