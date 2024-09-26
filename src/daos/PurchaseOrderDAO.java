/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import carlot.DBConnection;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import models.PurchaseOrder;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import java.sql.Date;
import models.Car;

/**
 *
 * @author Matthew Harris
 */
public class PurchaseOrderDAO {
    //Reference for Prepared Statement
    private static PreparedStatement preparedStatement;
    
    //Reference for Get all Purchase Orders SQL statement (will need to join with car table to get all needed info)
    private final static String SELECT_ALL_PURCHASE_ORDERS_STMT = "SELECT * FROM purchaseOrder INNER JOIN car ON purchaseOrder.vin = car.vin;";
    
    //Reference for Insert Purchase Order Stmt
    private final static String ADD_PURCHASE_ORDER_STMT = "INSERT INTO purchaseOrder (vin, datePurchased, cost) VALUES (?, ?, ?)";
    
     
    
    
   //GET PURCHASE ORDERS
    public static ObservableList<PurchaseOrder> getAllPurchaseOrders() throws 
            SQLException, ClassNotFoundException {
        
        try{
            
          //Set up Connection
            DBConnection.dbConnect();
            
            //Create Prepared Statement
           preparedStatement = DBConnection.getConnection().prepareStatement(SELECT_ALL_PURCHASE_ORDERS_STMT);
            
           //Get ResultSet from executeQuery method
            ResultSet resultSet = preparedStatement.executeQuery();
            
            //Create ObservableList from ResultSet data
            ObservableList<PurchaseOrder> purchaseOrderList = createPurchaseOrderListFromResultSet(resultSet);
            
            //Return list
            return purchaseOrderList;
            
            
        }catch (SQLException e){
           
            //Throw exception
            throw e;
            
        }
    }
   
    
   //ADD PURCHASE ORDER
   public static void addPurchaseOrder(PurchaseOrder purchaseOrder) throws SQLException, ClassNotFoundException{
    
       try{
            
            //Set up Connection
           DBConnection.dbConnect();
            
            //Create Prepared Statement
           preparedStatement = DBConnection.getConnection().prepareStatement(ADD_PURCHASE_ORDER_STMT);
            
            //Update Prepared Statement
                // When updating the preparedStatement with the datePurchased you use the following format
                // preparedStatement.setString(2, Date.valueOf(purchaseOrder.getDatePurchased()) + "");
              preparedStatement.setString(1, purchaseOrder.getCar().getVin()); 
              preparedStatement.setString(2, Date.valueOf(purchaseOrder.getDatePurchased()) + "");
              preparedStatement.setString(3, purchaseOrder.getCost() + "");
     
            //Run Update
            preparedStatement.executeUpdate();
        
        }catch(SQLException e){
             System.out.println("SQL purchase order insert operation has failed: " + e);
        }
   
    }
       
    
       

    //Use ResultSet from 'GET PURCHASE ORDERS' to create and return list of purachaseOrders 
     private static ObservableList<PurchaseOrder> createPurchaseOrderListFromResultSet(ResultSet resultSet) 
            throws SQLException, ClassNotFoundException {
        
        //Create ObservableList
        ObservableList<PurchaseOrder> purchaseOrderList = FXCollections.observableArrayList();
        
        //Loop through ResultSet and create local variables:
         while(resultSet.next()){
         
        // int id, datePurchased (see note below on how to do that one), cost, vin
            // int year, make, model, color, int mileage, int mpg, double salesPrice
                //What to do to convert SQL date in Result Date to LocalDate 
                //LocalDate datePurchased = resultSet.getDate("datePurchased").toLocalDate();             
          int year = resultSet.getInt("year");
          int id = resultSet.getInt("id");
          int mileage = resultSet.getInt("mileage"); 
          int mpg = resultSet.getInt("mpg");
          double salesPrice = resultSet.getDouble("salesPrice");
          double cost = resultSet.getDouble("cost"); 
          String make = resultSet.getString("make");
          String model = resultSet.getString("model");
          String color = resultSet.getString("color");
          String vin = resultSet.getString("vin");                         
          LocalDate datePurchased = resultSet.getDate("datePurchased").toLocalDate();
            
            //Create car with local variables 
                //constructor: Car(vin, year, make model, color, mileage, mpg, salesPrice) 
                Car car = new Car(vin, year, make, model, color, mileage, mpg, salesPrice);
             
            //Create purchaseOrder with the created car and rest of the variables
                //constructor: PurchaseOrder(id, datePurchased, car, cost)
            PurchaseOrder purchaseOrder = new PurchaseOrder(id, datePurchased, car, cost);
             
            //Add PurchaseOrder To List
            purchaseOrderList.add(purchaseOrder);
         }
        //Return List
        return purchaseOrderList;
    }
    
    
    }
    
       
    
    
    
    
