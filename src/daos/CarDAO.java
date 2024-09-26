/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import carlot.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author AlexC
 */
public class CarDAO {
    private static PreparedStatement preparedStatement;
    private final static String SELECT_ALL_AVALIABLE_CARS_STMT = "SELECT * FROM car LEFT JOIN salesOrder ON car.vin = salesOrder.vin WHERE salesOrder.vin IS NULL;";
    private final static String UPDATE_CAR_STMT = "UPDATE car SET year = ?, make = ?, model = ?, color = ?, mileage = ?, mpg = ?, salesPrice = ? WHERE vin = ?";
    private final static String ADD_CAR_STMT = "INSERT INTO car (vin, year, make, model, color, mileage, mpg, salesPrice) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
    private final static String SELECT_CAR_STMT = "SELECT * FROM car WHERE vin = ?";
    
    //GET AVALIABLE CARS
    public static ObservableList<Car> getAllAvaliableCars() throws 
            SQLException, ClassNotFoundException {
        
        try{
            //Set up Connection
            DBConnection.dbConnect();
            
            //Create Prepared Statement
            preparedStatement = DBConnection.getConnection().prepareStatement(SELECT_ALL_AVALIABLE_CARS_STMT);
            
           //Get ResultSet from executeQuery method
            ResultSet resultSet = preparedStatement.executeQuery();
            
            //Create List from ResultSet data
            ObservableList<Car> carList = createCarListFromResultSet(resultSet);
            
            // Return list
            return carList;
            
        }catch (SQLException e){
            System.out.println("SQL select all avaliable cars operation has failed: " + e);
            //Return exception
            throw e;
        }
    }
    
    //GET CAR
    public static ObservableList<Car> getCar(String vin) throws 
            SQLException, ClassNotFoundException {
        
        try{
            //Set up Connection
            DBConnection.dbConnect();
            
            //Create Prepared Statement
            preparedStatement = DBConnection.getConnection().prepareStatement(SELECT_CAR_STMT);
            
            //Update Prepared Statement
            preparedStatement.setString(1,vin );
            
           //Get ResultSet from executeQuery method
            ResultSet resultSet = preparedStatement.executeQuery();
            
            //Create List from ResultSet data
            ObservableList<Car> carList = createCarListFromResultSet(resultSet);
            
            // Return list
            return carList;
            
        }catch (SQLException e){
            System.out.println("SQL select all avaliable cars operation has failed: " + e);
            //Return exception
            throw e;
        }
    }
    
    // UPDATE CAR
    public static void updateCar(Car car) throws 
            SQLException, ClassNotFoundException {
    
        try{
        
        //Set up Connection
        DBConnection.dbConnect();
        
        //Create Prepared Statement
        preparedStatement = DBConnection.getConnection().prepareStatement(UPDATE_CAR_STMT);
        
        //Update Prepared Statement
        preparedStatement.setString(1, car.getYear() + "");
        preparedStatement.setString(2,car.getMake());
        preparedStatement.setString(3, car.getModel());
        preparedStatement.setString(4, car.getColor());
        preparedStatement.setString(5, car.getMileage() + "");
        preparedStatement.setString(6, car.getMpg() + "");
        preparedStatement.setString(7, car.getSalesPrice() + "");
        preparedStatement.setString(8, car.getVin());
        
        //Run Update
        preparedStatement.executeUpdate();
        
        }
        catch(SQLException e){
        System.out.println("SQL car update operation has failed: " + e);
        }
    }
    
    //ADD CAR
    public static void addCar(Car car) throws SQLException, ClassNotFoundException{
    
        try{
            
            //Set up Connection
            DBConnection.dbConnect();
            
            //Create Prepared Statement
            preparedStatement = DBConnection.getConnection().prepareStatement(ADD_CAR_STMT);
            
            //Update Prepared Statement
            preparedStatement.setString(1, car.getVin());
            preparedStatement.setString(2, car.getYear() + "");
            preparedStatement.setString(3,car.getMake());
            preparedStatement.setString(4, car.getModel());
            preparedStatement.setString(5, car.getColor());
            preparedStatement.setString(6, car.getMileage() + "");
            preparedStatement.setString(7, car.getMpg() + "");
            preparedStatement.setString(8, car.getSalesPrice() + "");
        
            //Run Update
            preparedStatement.executeUpdate();
        
        }catch(SQLException e){
             System.out.println("SQL car insert operation has failed: " + e);
        }
   
    
    }
    
        
    //Use ResultSet of 'GET CAR' to create and return list of cars
    private static ObservableList<Car> createCarListFromResultSet(ResultSet resultSet) 
            throws SQLException, ClassNotFoundException {
        
        //Create List
        ObservableList<Car> carList = FXCollections.observableArrayList();
        
        //Loop through ResultSet and create local variables
        while (resultSet.next()){ 
            String vin = resultSet.getString("vin");
            int year = resultSet.getInt("year");
            String make = resultSet.getString("make");
            String model = resultSet.getString("model");
            String color = resultSet.getString("color");
            int mileage = resultSet.getInt("mileage");
            int mpg = resultSet.getInt("mpg");
            double salesPrice = resultSet.getDouble("salesPrice");
            
            //Create car with variables
            Car car = new Car(vin, year, make, model, color, mileage, mpg, salesPrice);
            
            //Add car to List
            carList.add(car);
        }
        //Return List
        return carList;
    }
    
   
    
    
}