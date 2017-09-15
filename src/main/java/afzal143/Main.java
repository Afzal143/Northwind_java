package afzal143;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        NorthwindData nw = new NorthwindData();

        System.out.println("_____________________________________________________________________________");

        for (OrderDetails mn : nw.getOrderDetails()){
            System.out.println(mn.getCustomer_id() + " " +mn.getShip_address() + " " + mn.getShip_city() + " " + mn.getShipping_fee());
        }


        System.out.println("_____________________________________________________________________________");

        Customer cid= nw.getCustomerById("1");
        System.out.println(cid.getFirstName() + " " + cid.getLastName());

        System.out.println("_____________________________________________________________________________");

        for (Customer c:   nw.getCustomers()){
            System.out.println(c.getFirstName() + " " + c.getLastName());



        }

    }
}
