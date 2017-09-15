package afzal143;

import java.sql.*;

public class Function {
    Connection con = null;
    PreparedStatement ps = null;

    public ResultSet findCustomerById(String s) {
        ResultSet rs = null;
        try {
            DbConnection dbc = new DbConnection();
            con = dbc.getConn();
            ps = con.prepareStatement("SELECT * FROM northwind.customers where id=?;");
            ps.setString(1, s);
            rs = ps.executeQuery();
        } catch (Exception ex) {
            System.out.print("Error");
        }
        return rs;
    }

    public ResultSet getAllCustomers() {
        ResultSet rs = null;
        try {
            DbConnection dbc = new DbConnection();
            con = dbc.getConn();
            ps = con.prepareStatement("SELECT * FROM northwind.customers limit 10");
            rs = ps.executeQuery();
        } catch (Exception ex) {
            System.out.print("Error");
        }
        return rs;
    }

    public ResultSet getOderDetailsbyOrder() {
        ResultSet rs = null;
        try {
            DbConnection dbc = new DbConnection();
            con = dbc.getConn();
            ps = con.prepareStatement("SELECT customer_id,ship_address,ship_city, shipping_fee FROM northwind.orders");
            rs = ps.executeQuery();
        } catch (Exception ex) {
            System.out.print("Error");
        }
        return rs;

    }

}