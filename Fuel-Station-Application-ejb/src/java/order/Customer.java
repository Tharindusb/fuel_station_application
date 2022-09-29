/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package order;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Dushyantha
 */
@Stateless
@LocalBean
public class Customer {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private Long customerID;
    private String vehicleNo;
    private String vehicleType;
    private Timestamp createdTimestamp;
    
    public Customer() {
        
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
    
//    public static void main(String[] args) {
//        try {
//            Customer customer = new Customer();
//            customer.registerCustomer(customer);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void registerCustomer(Customer customer) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("BBBBBBBBBBBBBBBBBB");
        try {
            String query = "INSERT INTO CUSTOMER(CUSTOMER_VEHICLE_NO, CUSTOMER_VEHICLE_TYPE) VALUES(?, ?)";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FUEL_STATION_DB?useSSL=false", "root", "P@ssw0rd");
            if(conn.isValid(0)) {
                out.println("connection is ready");
            } else {
                out.println("connection is not ready");
            }
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "CZZ-5555"); 
            ps.setString(2, "CAR");
//            ps.setString(2, student.getLastName());
            int i = ps.executeUpdate(); 
            if(i > 0) { 
                out.println("You are sucessfully register");
            } else {
                out.println("There is a error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
}
