/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package carlot;

import daos.CarDAO;
import daos.PurchaseOrderDAO;
import daos.SalesOrderDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Car;
import models.PurchaseOrder;
import models.SalesOrder;
import views.car.CarTable;
import views.car.CarView;
import views.purchaseOrder.PurchaseOrderView;
import views.salesOrder.SalesOrderView;

/**
 *
 * @author AlexC
 */
public class CarLot extends Application {
    private CarView carView;
    private PurchaseOrderView purchaseOrderView;
    private SalesOrderView salesOrderView;
    
    @Override
    public void start(Stage primaryStage) {
        
        //Create Root Pane
        TabPane root = new TabPane();
        
        //Create Tabs
        Tab carTab = new Tab("Inventory");
        Tab purchaseOrderTab = new Tab("Purchases");
        Tab salesOrderTab = new Tab("Sales");
        
        //Create New Views 
        carView = new CarView();
        purchaseOrderView = new PurchaseOrderView();
        salesOrderView = new SalesOrderView();
        
        //Add Views to Tabs as Content
        carTab.setContent(carView);
        purchaseOrderTab.setContent(purchaseOrderView);
        salesOrderTab.setContent(salesOrderView);
        
        //Add Tabs to Root Pane
        root.getTabs().addAll(carTab, purchaseOrderTab, salesOrderTab);
        
        //Root Styling
        root.setTabMinWidth(100);
        root.setTabMaxWidth(100);
        root.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        
        Scene scene = new Scene(root);
        primaryStage.setTitle("CarLot");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
         /**
         * POPULATE TABLES WITH DATA
         */
         
        this.populateCarTable();
        this.populatePurchaseOrderTable();
        this.populateSalesOrderTable();
        
        
         /**
         * EVENTS
         */
        
         //Inventory Tab Clicked
        carTab.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                populateCarTable();
            }
        });


        // Car Table Row Clicked
        carView.getCarTable().getTable().setOnMouseClicked(e -> {
            // Display attributes of car whose table row was selected in textfields
            this.populateCarTextFieldsWithSelectionData();
        });  
        
        // Car Update Button Clicked
        carView.getUpdateBtn().setOnAction(e -> {
            
            // Uses textfield input to update Car in db
            Car car = createCarFromTextFieldInput();
            
            //Use data to update car in db
            updateCar(car);
            
            //Clear textfields
            clearCarFormTextFields();
            
            //Refresh car table
            populateCarTable();
        });  
        
        //Car Cancel Button Clicked
        carView.getCancelBtn().setOnAction(e -> clearCarFormTextFields());
        
        
        //PurchaseOrder Add To Inventory Button Clicked
        purchaseOrderView.getAddToInventoryBtn().setOnAction(e ->{
            
            //Use textfield input to create purchase order
            PurchaseOrder purchaseOrder = createPurchaseOrderFromTextFields();
            
            //Use PurchaseOrder attributes to add car and purchaseOrder to db
            addCar(purchaseOrder.getCar());
            addPurchaseOrder(purchaseOrder);
            
            //Clear the textfields
            clearPurchaseOrderFormTextFields();
            
            //refresh purchaseOrder and car tables
            populatePurchaseOrderTable();
             
        });
             
        
        //PurchaseOrder Cancel Button Clicked
        purchaseOrderView.getCancelBtn().setOnAction(e -> {
            clearPurchaseOrderFormTextFields();
        });
            
        
        //SalesOrder Get Button Car Clicked
        salesOrderView.getSalesOrderForm().getCarBtn().setOnAction(e -> {
            
            try{
                //Look up vin entered in textfield
                String vinForCarToLookUp = salesOrderView.getSalesOrderForm().getVin().getText();
        
                //Use vin to get the car 
                Car car = CarDAO.getCar(vinForCarToLookUp).get(0);
                
                //Use car info to fill textfields
                populateSalesOrderFormCarInfoTextFields(car);
            
            }catch(SQLException | ClassNotFoundException ex){
                System.out.println("Error populating table with car data from db.\n" + ex);
            
            }
        });
            
         //SalesOrder Process Sale Button Clicked
        salesOrderView.getProcessSaleBtn().setOnAction(e -> {
            //TODO CAR FIELDS in SALES ORDER SHOULD BE UNEDITABLE
            
            //Use textfield input to add SalesOrder to db
            SalesOrder salesOrder = createSalesOrderFromTextfields();
            addSalesOrder(salesOrder);
            clearSalesOrderTextFields();
            
            //refresh Table
            populateSalesOrderTable();
         
        });
            
        
         //SalesOrder Cancel Button Clicked
        salesOrderView.getCancelBtn().setOnAction(e -> {
            clearSalesOrderTextFields();
        });  
        
    }
    
     /**
     * METHODS
     */
    
    //CAR TABLE RELATED
    private void populateCarTable(){
        try{
            //Use CarDAO to get list of cars from db
            carView.getCarTable().getTable().setItems(CarDAO.getAllAvaliableCars());
            
        } catch(SQLException | ClassNotFoundException e) {
            System.out.println("Error populating table with car data for db.\n" + e);
        }
    }
    
    private void populateCarTextFieldsWithSelectionData(){
        //Get car that was selected 
        Car car = carView.getCarTable().getTable().getSelectionModel().getSelectedItem();
        
        //Get attributes of selected car and set as text for car form textfields
        carView.getCarForm().getVin().setText(car.getVin());
        carView.getCarForm().getMake().setText(car.getMake());
        carView.getCarForm().getModel().setText(car.getModel());
        carView.getCarForm().getColor().setText(car.getColor());
        
        // Add +"" to setText() argument to convert the resulting number to a string
        carView.getCarForm().getYear().setText(car.getYear()+ "");
        carView.getCarForm().getMileage().setText(car.getMileage()+ "");
        carView.getCarForm().getMpg().setText(car.getMpg()+"");
        carView.getCarForm().getSalesPrice().setText(car.getSalesPrice()+"");
    }
    
     private Car createCarFromTextFieldInput(){
        //Get each car attribute value from the car form textfields
        String vin = carView.getCarForm().getVin().getText();
        String make = carView.getCarForm().getMake().getText();
        String model = carView.getCarForm().getModel().getText();
        String color = carView.getCarForm().getColor().getText();
        int year =  Integer.parseInt(carView.getCarForm().getYear().getText());
        int mileage = Integer.parseInt(carView.getCarForm().getMileage().getText()); 
        int mpg = Integer.parseInt(carView.getCarForm().getMpg().getText());
        double salesPrice = Double.parseDouble(carView.getCarForm().getSalesPrice().getText());
               
        Car car = new Car(vin, year, make, model, color, mileage, mpg, salesPrice);
        return car;
    }
    
    // Update Car in DB
    private void updateCar(Car car){   
        try{
            CarDAO.updateCar(car);
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Error when attempting to update a contact and repopulate table " + e);
        }    
    }
    
    //Add Car to DB
   private void addCar(Car car){
       try{
           CarDAO.addCar(car);
       }catch(SQLException | ClassNotFoundException e){
           System.out.println("Error when attempting to add a car" + e);
       }
   
   }
      
    // Car Form Clear TextFields
    private void clearCarFormTextFields(){
        carView.getCarForm().getVin().clear();
        carView.getCarForm().getMake().clear();
        carView.getCarForm().getModel().clear();
        carView.getCarForm().getColor().clear();
        carView.getCarForm().getYear().clear();
        carView.getCarForm().getMileage().clear();
        carView.getCarForm().getMpg().clear();
        carView.getCarForm().getSalesPrice().clear(); 
    }
    
    //PURCHASE ORDER TABLE RELATED
    
    private void populatePurchaseOrderTable(){
        try{
            //Use PurchaseOrder DAO to get list of purchase orders from db
            purchaseOrderView.getPurchaseOrderTable().getTable().setItems(PurchaseOrderDAO.getAllPurchaseOrders());
        } catch(SQLException | ClassNotFoundException e) {
            System.out.println("Error populating table with purchase order data from db.\n" + e);
        }
    }
    
    
    private PurchaseOrder createPurchaseOrderFromTextFields(){
        //Get each car and purchaseOrder attribute value from the purchaseOder form textfields
        LocalDate datePurchased = purchaseOrderView.getPurchaseOrderForm().getDatePurchased().getValue();
        double cost = Double.parseDouble(purchaseOrderView.getPurchaseOrderForm().getCost().getText());
        String vin = purchaseOrderView.getPurchaseOrderForm().getVin().getText();
        String make = purchaseOrderView.getPurchaseOrderForm().getMake().getText();
        String model = purchaseOrderView.getPurchaseOrderForm().getModel().getText();
        String color = purchaseOrderView.getPurchaseOrderForm().getColor().getText();
        int year =  Integer.parseInt(purchaseOrderView.getPurchaseOrderForm().getYear().getText());
        int mileage = Integer.parseInt(purchaseOrderView.getPurchaseOrderForm().getMileage().getText()); 
        int mpg = Integer.parseInt(purchaseOrderView.getPurchaseOrderForm().getMpg().getText());
        double salesPrice = Double.parseDouble(purchaseOrderView.getSalesPrice().getText());
               
        Car car = new Car(vin, year, make, model, color, mileage, mpg, salesPrice);
        PurchaseOrder purchaseOrder = new PurchaseOrder(0, datePurchased, car, cost);
        return purchaseOrder;
    
    }  

    
    
    private void addPurchaseOrder(PurchaseOrder purchaseOrder){
        try{
            PurchaseOrderDAO.addPurchaseOrder(purchaseOrder);
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Error when attempting to add a purchaseOrder\n" + e);
        }
    }
    
    private void clearPurchaseOrderFormTextFields(){
        purchaseOrderView.getPurchaseOrderForm().getDatePurchased().setValue(null);
        purchaseOrderView.getPurchaseOrderForm().getCost().clear();
        purchaseOrderView.getPurchaseOrderForm().getVin().clear();
        purchaseOrderView.getPurchaseOrderForm().getMake().clear();
        purchaseOrderView.getPurchaseOrderForm().getModel().clear();
        purchaseOrderView.getPurchaseOrderForm().getColor().clear();
        purchaseOrderView.getPurchaseOrderForm().getYear().clear();
        purchaseOrderView.getPurchaseOrderForm().getMileage().clear(); 
        purchaseOrderView.getPurchaseOrderForm().getMpg().clear();
        purchaseOrderView.getSalesPrice().clear();
    }
    
    
    //SALES ORDER TABLE RELATED
    private void populateSalesOrderTable(){
        try{
            //Use SalesOrder DAO to get list of sales orders from db
            salesOrderView.getSalesOrderTable().getTable().setItems(SalesOrderDAO.getAllSalesOrders());
        } catch(SQLException | ClassNotFoundException e) {
            System.out.println("Error populating table with car data for db.\n" + e);
        }
    
    }
    
    private void populateSalesOrderFormCarInfoTextFields(Car car){
        salesOrderView.getSalesOrderForm().getYear().setText(car.getYear() + "");
        salesOrderView.getSalesOrderForm().getMake().setText(car.getMake());
        salesOrderView.getSalesOrderForm().getModel().setText(car.getModel());
        salesOrderView.getSalesOrderForm().getColor().setText(car.getColor());
        salesOrderView.getSalesOrderForm().getMileage().setText(car.getMileage() + "");
        salesOrderView.getSalesOrderForm().getMpg().setText(car.getMpg() + "");
    }
    
    private SalesOrder createSalesOrderFromTextfields(){
         //Get each car and purchaseOrder attribute value from the salesOrder form textfields
        String vin = salesOrderView.getSalesOrderForm().getVin().getText();
        LocalDate dateSold = salesOrderView.getSalesOrderForm().getDateSold().getValue();
        double priceSold = Double.parseDouble(salesOrderView.getSalesOrderForm().getPriceSold().getText());
        int year = Integer.parseInt(salesOrderView.getSalesOrderForm().getYear().getText());
        int mileage = Integer.parseInt(salesOrderView.getSalesOrderForm().getMileage().getText());
        String make = salesOrderView.getSalesOrderForm().getMake().getText();
        String model = salesOrderView.getSalesOrderForm().getModel().getText();
        String color = salesOrderView.getSalesOrderForm().getColor().getText();
        int mpg = Integer.parseInt(salesOrderView.getSalesOrderForm().getMpg().getText());
        double salesPrice = 0; //actual sales price not needed as just using info to create salesOrder
        int salesOrderID = 0; //actual salesOrder ID added by db
        
        //Create Car
        Car car = new Car(vin, year, make, model, color, mileage, mpg, salesPrice);
        
        //Create SalesOrder
        SalesOrder salesOrder = new SalesOrder(salesOrderID, dateSold, car, priceSold);
    
        //Return SalesOrder
        return salesOrder;
    
    } 
    
    private void addSalesOrder(SalesOrder salesOrder){
        try{
            SalesOrderDAO.addSalesOrder(salesOrder);
        
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Error when attempting to add a salesOrder\n" + e);
        }
    }
    
    //private void clearSalesOrderTextFields90{}
    private void clearSalesOrderTextFields(){
        salesOrderView.getSalesOrderForm().getVin().clear();
        salesOrderView.getSalesOrderForm().getDateSold().setValue(null);
        salesOrderView.getSalesOrderForm().getPriceSold().clear();
        salesOrderView.getSalesOrderForm().getYear().clear();
        salesOrderView.getSalesOrderForm().getMileage().clear();
        salesOrderView.getSalesOrderForm().getMake().clear();
        salesOrderView.getSalesOrderForm().getModel().clear();
        salesOrderView.getSalesOrderForm().getColor().clear();
        salesOrderView.getSalesOrderForm().getMpg().clear();
 
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
