package ba.unsa.etf.rpr.hadi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBaseDao {
    private static Connection connection;

    private DateBaseDao(){

    }

    public static Connection getInstance() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("","","");
        }
        return connection;
    }
}
