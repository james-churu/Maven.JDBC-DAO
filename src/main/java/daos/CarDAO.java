package daos;
import models.Car;
import java.sql.*;
import java.util.*;

public class CarDAO implements GetId ,DAOLogic<Car> {



    public Car findById(int id){

        ConnectionClass conClass = new ConnectionClass();
        Connection connection = conClass.getConnection();

        try{
            PreparedStatement prepStat = connection.prepareStatement("select * from car where id = " + id);
            prepStat.setInt(1,id);
            ResultSet result = prepStat.executeQuery();
            return getCarFromResultSet( result );

        }catch(SQLException e){
            return null;
        }
    }

    public List findAll() {

        ConnectionClass conClass = new ConnectionClass();
        Connection connection = conClass.getConnection();

        ArrayList<Car> cars = new ArrayList<Car>();

        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM car");
            while(results.next()) {
                Car car = getCarFromResultSet( results );
                cars.add( car );
                return cars;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public Car update(Car car) {
        ConnectionClass conClass = new ConnectionClass();
        Connection connection = conClass.getConnection();

        try{
            PreparedStatement prepstat = connection.prepareStatement("UPDATE Car SET 'make'=?, 'model'=?, 'year'=? , 'color'=?, 'vin_number'=? WHERE 'id'=?");
            prepstat.setString(1 , car.getMake() );
            prepstat.setString(2 , car.getModel() );
            prepstat.setDate(3 , (java.sql.Date) car.getYear() );
            prepstat.setString(4 , car.getColor() );
            prepstat.setInt(5 , car.getVin_number() );

            prepstat.setInt( 6 , car.getId() );

            int goodUpdate = prepstat.executeUpdate();

            if( goodUpdate == 1) {
                System.out.println("Successfully  Updated Car");
                return car;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }


    public Car create(Car car) {


        ConnectionClass conClass = new ConnectionClass();
        Connection connection = conClass.getConnection();

        try{
            PreparedStatement prepstat = connection.prepareStatement("INSERT INTO Car ( 'id' , 'make' , 'model' , 'year' , 'color' , 'vin_number') VALUES (? , ? , ? , ? , ? , ? ");

            prepstat.setInt( 1 , car.getId() );
            prepstat.setString(2 , car.getMake() );
            prepstat.setString(3 , car.getModel() );
            prepstat.setDate(4 , (java.sql.Date) car.getYear() );
            prepstat.setString(5 , car.getColor() );
            prepstat.setInt(6 , car.getVin_number() );

            int goodUpdate = prepstat.executeUpdate();

            if( goodUpdate == 1) {
                System.out.println("Successfully Added Car");
                return car;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        ConnectionClass cf = new ConnectionClass();
        Connection connection = cf.getConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM car WHERE id=" + id);
            System.out.println("Delete successful");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getID() {
        return 0;
    }

    public Car getCarFromResultSet(ResultSet set) throws SQLException{

        Car car = new Car();
        car.setId( set.getInt("id") );
        car.setMake( set.getString("make") );
        car.setModel( set.getString("model") );
        car.setYear( set.getDate( "year"));
        car.setColor( set.getString("color"));
        car.setVin_number( set.getInt( "vin_number"));

        return car;
    }
}
