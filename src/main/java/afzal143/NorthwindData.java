package afzal143;

import java.sql.*;
import java.util.*;

public class NorthwindData {


    public List<Customer> getCustomers() throws SQLException {

        ResultSet resultSet = null;
        List<Customer> customers = new ArrayList<Customer>();

        try {
            Function f = new Function();
            resultSet = f.getAllCustomers();
            while (resultSet.next()) {
                Customer c = new Customer(resultSet.getString("first_name"), resultSet.getString("last_name"));
                customers.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer getCustomerById(String id) throws SQLException {
        ResultSet resultSet = null;
        Customer c = null;
        try {
            Function f = new Function();
            resultSet = f.findCustomerById(id);
            while (resultSet.next()) {
                c = new Customer(resultSet.getString("first_name"), resultSet.getString("last_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public List<OrderDetails> getOrderDetails() throws SQLException {

        ResultSet resultSet = null;
        List<OrderDetails> orders = new ArrayList<OrderDetails>();

        try {
            Function f = new Function();
            resultSet = f.getOderDetailsbyOrder();
            while (resultSet.next()) {
                OrderDetails m = new OrderDetails(resultSet.getInt("customer_id"), resultSet.getString("ship_address"), resultSet.getString("ship_city"), resultSet.getInt("shipping_fee"));
                orders.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;


    }
}
