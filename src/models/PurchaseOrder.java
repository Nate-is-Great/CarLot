/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author AlexC
 */
public class PurchaseOrder {
    //Attributes int id, LocalDate datePurchased, Car car, double cost
    private int id;
    private LocalDate datePurchased;
    private Car car;
    private double cost;
    
    //Constructor
    public PurchaseOrder(){

    }

    public PurchaseOrder(int id,LocalDate datePurchased, Car car, double cost){
        this.id = id;
        this.datePurchased = datePurchased;
        this.car = car;
        this.cost = cost;

    }
    //Getters and Setters
    public int getId(){
        return id;
    }

    public LocalDate getDate(){
        return datePurchased;
    }
    public Car getCar(){
        return car;
    }
    public double getCost(){
        return cost;
    }
    
    
    public void setId(int id){
        this.id =id;
    }
   
    public void setCar(Car car){
        this.car = car;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
    //ToString
    public String ToSring(){
        return "Id " + id + " DatePurchased " + datePurchased + " Car " + car + " Cost " + cost;
    }
}
