package afzal143;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

public class NorthwindData {
    private static final Logger logger = LoggerFactory.getLogger(NorthwindData.class);

    public List<Customer> getCustomers() throws SQLException {


        ResultSet resultSet = null;
        List<Customer> customers = new ArrayList<Customer>();

        try {
            logger.info(" Displaying successfully" );
            Function f = new Function();
            resultSet = f.getAllCustomers();

            while (resultSet.next()) {
                Customer c = new Customer(resultSet.getString("first_name"), resultSet.getString("last_name"));
                customers.add(c);

            }
        } catch (Exception e) {
            logger.error("Error while displaying ");
            e.printStackTrace();
        }
        return customers;
    }

    public Customer getCustomerById(String id) throws SQLException {
        ResultSet resultSet = null;
        Customer c = null;
        try {
            logger.info(" Customer Name successfully found" );
            Function f = new Function();
            resultSet = f.findCustomerById(id);
            while (resultSet.next()) {
                c = new Customer(resultSet.getString("first_name"), resultSet.getString("last_name"));
            }
        } catch (Exception e) {
            logger.error("Error while fetching ");
            e.printStackTrace();
        }
        return c;
    }

    public List<OrderDetails> getOrderDetails() throws SQLException {

        ResultSet resultSet = null;
        List<OrderDetails> orders = new ArrayList<OrderDetails>();

        try {
            logger.info(" successfully executed the list" );
            Function f = new Function();
            resultSet = f.getOderDetailsbyOrder();
            while (resultSet.next()) {
                OrderDetails m = new OrderDetails(resultSet.getInt("customer_id"), resultSet.getString("ship_address"), resultSet.getString("ship_city"), resultSet.getInt("shipping_fee"));
                orders.add(m);
            }
        } catch (Exception e) {
            logger.error(" Order Details could not found");
            e.printStackTrace();
        }
        return orders;


    }
}
