package afzal143;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Function {
    private static final Logger log = LoggerFactory.getLogger(Function.class);
    Connection con = null;
    PreparedStatement ps = null;

    public ResultSet findCustomerById(String s) {
        ResultSet rs = null;
        try {
            log.info(" SQL command executing");
            DbConnection dbc = new DbConnection();
            con = dbc.getConn();
            ps = con.prepareStatement("SELECT * FROM northwind.customers where id=?;");
            ps.setString(1, s);
            rs = ps.executeQuery();
        } catch (Exception ex) {
            log.warn(" Please correct the sql command");
            System.out.print("Error");
        }
        return rs;
    }

    public ResultSet getAllCustomers() {
        ResultSet rs = null;
        try {
            log.info(" SQL command executing");
            DbConnection dbc = new DbConnection();
            con = dbc.getConn();
            ps = con.prepareStatement("SELECT * FROM northwind.customers limit 10");
            rs = ps.executeQuery();
        } catch (Exception ex) {
            log.warn(" Please correct the sql command");
            System.out.print("Error");
        }
        return rs;
    }

    public ResultSet getOderDetailsbyOrder() {
        ResultSet rs = null;
        try {
            log.info(" SQL command executing");
            DbConnection dbc = new DbConnection();
            con = dbc.getConn();
            ps = con.prepareStatement("SELECT customer_id,ship_address,ship_city, shipping_fee FROM northwind.orders");
            rs = ps.executeQuery();
        } catch (Exception ex) {
            log.warn(" Please correct the sql command");
            System.out.print("Error");
        }
        return rs;

    }

}