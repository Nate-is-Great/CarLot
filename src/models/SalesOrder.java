/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *

 * @author Nate
 */

public class SalesOrder {
    //Attributes int id, LocalDate dateSold, Car car, double priceSold
    private int id;
    private LocalDate dateSold;
    private Car car;
    private double priceSold;

    //Constructor

   public SalesOrder(){

    }
    
    public SalesOrder(int id, LocalDate dateSold, Car car, double priceSold){
    this.id = id;
    this.dateSold = dateSold;
    this.car = car;
    this.priceSold = priceSold;

    }
    
    //Getters
    public int getId(){
        return id;
    }
    public LocalDate getDateSold(){
        return dateSold;
    }
    public Car getCar(){
        return car;
    }
    public double getPriceSold(){
        return priceSold;
    }
    //Setters

    public void setDateSold(LocalDate dateSold){
        this.dateSold = dateSold;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public void setCar(Car car){
        this.car = car;
    }
    public void setPriceSold(double priceSold){
        this.priceSold = priceSold;
    }

    //ToString
    public String ToSring(int id, LocalDate dateSold, Car car, double priceSold){
        return "Id " + id + " DateSold " + dateSold + " Car " + car + " PriceSold " + priceSold;
    }
    
}

