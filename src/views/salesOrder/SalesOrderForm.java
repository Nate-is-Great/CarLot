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

/**
 *
 * @author Michael Talerico
 */

public class SalesOrderForm extends HBox {

    //TextField References
    private final TextField vin = new TextField();
    private final TextField year = new TextField();
    private final TextField make = new TextField();
    private final TextField model = new TextField();
    private final TextField color = new TextField();
    private final TextField mileage = new TextField();
    private final TextField mpg = new TextField();
    private final TextField priceSold = new TextField();

    //DatePicker Reference (dateSold)
    private final DatePicker dateSold = new DatePicker();

    //Car Button Reference
    private final Button getCarBtn = new Button("Get Car");

    public SalesOrderForm(){

        //New GridPane
        GridPane grid = new GridPane();

        //Grid Styles
        grid.setHgap(20);
        grid.setVgap(15);

        // Add Labels and TextFields to Grid with add(Node, col index, row index)
        // Row 0: vin label, vin TextField, and Get Car Button
        grid.add(new Label("VIN:"), 0, 0);
        grid.add(vin, 1, 0);
        grid.add(getCarBtn, 2, 0);
        // Row 1: year label/textfield, make label/textfield, model label/textfield
        grid.add(new Label("Year:"), 0, 1);
        grid.add(year, 1, 1);
        grid.add(new Label("Make:"), 2, 1);
        grid.add(make, 3, 1);
        grid.add(new Label("Model:"), 4, 1);
        grid.add(model, 5, 1);
        // Row 2: color label/textfield, mileage label/textfield, mpg label/textfield
        grid.add(new Label("Color:"), 0, 2);
        grid.add(color, 1, 2);
        grid.add(new Label("Mileage:"), 2, 2);
        grid.add(mileage, 3, 2);
        grid.add(new Label("MPG HWY:"), 4, 2);
        grid.add(mpg, 5, 2);
        // Row 3: dateSold label/DatePicker, priceSold label/textfield
        grid.add(new Label("Date Sold:"), 0, 3);
        grid.add(dateSold, 1, 3);
        grid.add(new Label("Price Sold:"), 2, 3);
        grid.add(priceSold, 3, 3);

        //Make textfields year, make, model, color, mileage, mpg UNEDITABLE using following format:
        // year.setEditable(false);
        year.setEditable(false);
        make.setEditable(false);
        model.setEditable(false);
        color.setEditable(false);
        mileage.setEditable(false);
        mpg.setEditable(false);

        //Add grid to this pane
        getChildren().add(grid);

        //DO NOT STYLE GET CAR BUTTON

        //Styles for this pane (padding at 20, create border)
        setPadding(new Insets(20));
        setStyle("-fx-border-color: gray; -fx-border-width: 5px;");
    }

    //Getters for all TextFields, DatePicker, "Get Car" Button
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

    public TextField getPriceSold() {
        return priceSold;
    }

    public DatePicker getDateSold() {
        return dateSold;
    }

    public Button getCarBtn() {
        return getCarBtn;
    }

}
