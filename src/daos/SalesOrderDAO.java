/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import carlot.DBConnection;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import models.PurchaseOrder;
import models.SalesOrder;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.sql.Date;
import javafx.collections.FXCollections;
import models.Car;


/**
 *
 * @author Matthew Harris
 * 
 */
 
public class SalesOrderDAO {
    //Reference for Prepared Statement
   private static PreparedStatement preparedStatement;
     
    //Reference for Select all SalesOrder SQL Statement (Will need to join with car table to get all info)
    private final static String SELECT_ALL_SALES_ORDER_STMT = "SELECT * FROM salesOrder INNER JOIN car ON salesOrder.vin = car.vin;";
   
    //Reference for Insert SalesOrder SQL Statement
    private final static String ADD_SALES_ORDER_STMT = "INSERT INTO salesOrder (dateSold, vin, priceSold) VALUES (?, ?, ?)"; 
    
    //GET Sales ORDERS
    public static ObservableList<SalesOrder> getAllSalesOrders() throws 
            SQLException, ClassNotFoundException {
        
        try{
            
            //Set up Connection
            DBConnection.dbConnect();
            
            //Create Prepared Statement
           	preparedStatement = DBConnection.getConnection().prepareStatement(SELECT_ALL_SALES_ORDER_STMT);
            
           //Get ResultSet from executeQuery method
            ResultSet resultSet = preparedStatement.executeQuery();
            
            //Create ObservableList from ResultSet data
            ObservableList<SalesOrder> salesOrderList = createSalesOrderListFromResultSet(resultSet);
            
            //Return list
            return salesOrderList;
            
            
            
        }catch (SQLException e){
           	System.out.println("SQL salesOrder select operation has failed" + e);
            
            //Throw exception
            throw e;
            
        }
    }
    
    
   //ADD SALES ORDER
    public static void addSalesOrder(SalesOrder salesOrder) throws SQLException, ClassNotFoundException{
    
        try{
            
            //Set up Connection
           DBConnection.dbConnect();
            
            //Create Prepared Statement
            preparedStatement = DBConnection.getConnection().prepareStatement(ADD_SALES_ORDER_STMT);
            
            //Update Prepared Statement
                // When updating the preparedStatement with the datePurchased you use the following format
                // preparedStatement.setString(1, Date.valueOf(salesOrder.getDateSold()) + "");
              preparedStatement.setString(1, Date.valueOf(salesOrder.getDateSold()) + "");
              preparedStatement.setString(2, salesOrder.getCar().getVin()); 
              preparedStatement.setString(3, salesOrder.getPriceSold() + "");
            
            
            //Run Update
            preparedStatement.executeUpdate();
        
        }catch(SQLException e){
        	System.out.println("SQL sales order insert operation has failed: " + e);
             
        }
   
    }
    
    
    //Use ResultSet of 'GET ALL SALES ORDERS' to create and return list of sales orders
     private static ObservableList<SalesOrder> createSalesOrderListFromResultSet(ResultSet resultSet) 
          throws SQLException, ClassNotFoundException {
        
        //Create ObservableList
        ObservableList<SalesOrder> salesOrderList = FXCollections.observableArrayList();
        	
        
        //Loop through ResultSet and create local variables:
        while(resultSet.next()){
            
         //int id, dateSold (see note below on how to do this one), double priceSold,
         //vin, make, model, color, int mileage, int mpg, double salesPrice
          int year = resultSet.getInt("year");
          int id = resultSet.getInt("id");
          int mileage = resultSet.getInt("mileage"); 
          int mpg = resultSet.getInt("mpg");
          double salesPrice = resultSet.getDouble("salesPrice");
          double priceSold = resultSet.getDouble("priceSold");
          String make = resultSet.getString("make");
          String model = resultSet.getString("model");
          String color = resultSet.getString("color");
          String vin = resultSet.getString("vin");                         
          LocalDate dateSold = resultSet.getDate("dateSold").toLocalDate();
                     
          //Create car with local variables 
           //constructor: Car(vin, year, make model, color, mileage, mpg, salesPrice)
               Car car = new Car(vin, year, make, model, color, mileage, mpg, salesPrice);
                                     
                                     
               //Create SalesOrder with the created car and rest of the variables
                //constructor: SalesOrder(id, dateSold, car, priceSold)
                SalesOrder salesOrder = new SalesOrder(id, dateSold, car, priceSold);
               
                //Add SalesOrder To List
                 salesOrderList.add(salesOrder);
                                     
            }
               //Return List
                 return salesOrderList;
           
    }
        
    
}
