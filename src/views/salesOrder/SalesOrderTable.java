/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.salesOrder;

import java.time.LocalDate;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import models.SalesOrder;

/**
 *
 * @author Michael Talerico
 */

public class SalesOrderTable extends HBox{
    // TableView Reference
    private final TableView<SalesOrder> table;

    //Table Column References (ID, dateSold, vin, year, make, model, color,
    // mileage, mpg, soldPrice, Don't Worry about Profit)
    private final TableColumn<SalesOrder, Integer> id;
    private final TableColumn<SalesOrder, LocalDate> dateSold;
    private final TableColumn<SalesOrder, String> vin;
    private final TableColumn<SalesOrder, Integer> year;
    private final TableColumn<SalesOrder, String> make;
    private final TableColumn<SalesOrder, String> model;
    private final TableColumn<SalesOrder, String> color;
    private final TableColumn<SalesOrder, Integer> mileage;
    private final TableColumn<SalesOrder, Integer> mpg;
    private final TableColumn<SalesOrder, Double> priceSold;

    public SalesOrderTable(){

        // New TableView();
        table = new TableView<>();

        // Create Table Columns
        id = new TableColumn<>("ID");
        dateSold = new TableColumn<>("Date Sold");
        vin = new TableColumn<>("VIN");
        year = new TableColumn<>("Year");
        make = new TableColumn<>("Make");
        model = new TableColumn<>("Model");
        color = new TableColumn<>("Color");
        mileage = new TableColumn<>("Mileage");
        mpg = new TableColumn<>("MPG HWY");
        priceSold = new TableColumn<>("Price Sold");

        //Set Column Min Width
        id.setMinWidth(100.0);
        dateSold.setMinWidth(100.0);
        vin.setMinWidth(150.0);
        year.setMinWidth(75.0);
        make.setMinWidth(100.0);
        model.setMinWidth(150.0);
        color.setMinWidth(75.0);
        mileage.setMinWidth(100.0);
        mpg.setMinWidth(75);
        priceSold.setMinWidth(100.0);

        //Get column cell values from SalesOrder data model
        //!!!For all the data which comes from the SalesOrder's
        // Car object, instead of using the "new PropertyValueFactory<>()",
        //use the lamda expression below
        // ex: vin.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getCar().getVin()));
        // ex: year.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getCar().getYear()));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateSold.setCellValueFactory(new PropertyValueFactory<>("dateSold"));
        priceSold.setCellValueFactory(new PropertyValueFactory<>("priceSold"));
        vin.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCar().getVin()));
        year.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCar().getYear()));
        make.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCar().getMake()));
        model.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCar().getModel()));
        color.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCar().getColor()));
        mileage.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCar().getMileage()));
        mpg.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCar().getMpg()));


        //Add columns to table
        table.getColumns().add(id);
        table.getColumns().add(dateSold);
        table.getColumns().add(vin);
        table.getColumns().add(year);
        table.getColumns().add(make);
        table.getColumns().add(model);
        table.getColumns().add(color);
        table.getColumns().add(mileage);
        table.getColumns().add(mpg);
        table.getColumns().add(priceSold);

        //Get rid of extra column created
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //Add the table to this pane
        getChildren().add(table);

        //Set Pane Styles
        setAlignment(Pos.CENTER);

    }

    //Create getter for table

    public TableView<SalesOrder> getTable() {
        return table;
    }
}
