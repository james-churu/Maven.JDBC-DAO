package daos;

import models.Car;

import java.sql.SQLException;
import java.util.List;

public  interface DAOLogic<T>{

    T findById( int id) throws SQLException;

    List findAll();

    T update( T car);

    T create( T car);

    void delete( int id);
}
