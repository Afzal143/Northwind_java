package afzal143;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class DbConnection {

    private Connection conn = null;
    public Connection getConn() throws SQLException, ClassNotFoundException {

        if(conn==null){
            setConnection();
            return conn;
        }else{
            return conn;
        }
    }

    private void setConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/northwind?" + "user=root&password=root");

    }

}



