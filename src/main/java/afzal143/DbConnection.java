package afzal143;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class DbConnection {

    private static final Logger logger  = LoggerFactory.getLogger(DbConnection.class);

    private Connection conn = null;
    public Connection getConn() throws SQLException, ClassNotFoundException {
        logger.info(" DB Connection Setup");
        if(conn==null){
            setConnection();
            return conn;
        }else{
            return conn;
        }
    }

    private void setConnection() throws ClassNotFoundException, SQLException {
        logger.info("DB Connection Established");
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/northwind?" + "user=root&password=root");

    }

}



