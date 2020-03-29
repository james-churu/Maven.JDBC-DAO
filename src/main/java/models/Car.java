package models;

import java.util.*;

//insert into car (id,make,model,year,color,vin_number) values(5000,'Chevy','Equinox','2014-01-01','Orange',12349);
public class Car {

    Integer id;
    String make;
    String model;
    Date year;
    String color;
    Integer vin_number;

    public Car(Integer id, String make, String model, Date year, String color, Integer vin_number) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin_number = vin_number;
    }
    public Car(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getVin_number() {
        return vin_number;
    }

    public void setVin_number(Integer vin_number) {
        this.vin_number = vin_number;
    }


}
