import daos.CarDAO;
import models.Car;

import java.sql.*;

public class App {


    public static void main(String[] args){

        CarDAO carDao = new CarDAO();

        Car car  = carDao.findById(5000);

        System.out.println(car);
        System.out.println(carDao.findAll());
    }
}

