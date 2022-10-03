/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package order;

import java.io.Serializable;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Dushyantha
 */
@Stateless
@LocalBean
public class Customer implements Serializable{

    @EJB
    private Customer customer;

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
    
    public void registerCustomer(Customer customer) throws ClassNotFoundException {
        if (validateCustomer(customer)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                String query = "INSERT INTO CUSTOMER(CUSTOMER_VEHICLE_NO, CUSTOMER_VEHICLE_TYPE) VALUES(?, ?)";
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FUEL_STATION_DB?useSSL=false", "root", "P@ssw0rd");
                if(conn.isValid(0)) {
                    out.println("connection is ready");
                } else {
                    out.println("connection is not ready");
                }
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, customer.vehicleNo); 
                ps.setString(2, customer.vehicleType);
                int i = ps.executeUpdate(); 
                if(i > 0) { 
                    out.println("Customer sucessfully register");
                } else {
                    out.println("There is a error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
//            "Invalid customer"
        }        
    }
    
    public Customer getCustomerByVehicleNo(String vehicleNo) throws ClassNotFoundException {
        if (vehicleNo != null && !vehicleNo.isEmpty()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                String query = "SELECT CUSTOMER_ID, CUSTOMER_VEHICLE_NO, CUSTOMER_VEHICLE_TYPE, CUSTOMER_CREATED_TIMESTAMP FROM CUSTOMER WHERE CUSTOMER_VEHICLE_NO = ?";
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FUEL_STATION_DB?useSSL=false", "root", "P@ssw0rd");
                if(conn.isValid(0)) {
                    out.println("connection is ready");
                } else {
                    out.println("connection is not ready");
                }
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, vehicleNo); 
//                int i = ps.executeUpdate();
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    customer.setCustomerID(rs.getLong(1));
                    customer.setVehicleNo(rs.getString(2));
                    customer.setVehicleType(rs.getString(3));
                }
                return customer;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
//            "Invalid customer vehicle number"
        }
        return null;
    }
    
    private boolean validateCustomer(Customer customer) {
        if (customer == null) {
            return false;
//            "Customer should not be empty"
        }
        
        if (customer.getVehicleNo() == null || customer.getVehicleNo().isEmpty()) {
            return false;
//            "Vehicle number should not be empty"
        }
        if (!isInVehicleTypeEnum(customer.vehicleType)) {
            return false;
//            "Invalid vehicle type"
        }
        return true;
    }
    
    private boolean isInVehicleTypeEnum(String enumName) {
        for (VehicleTypeEnum enumValue: VehicleTypeEnum.values()) {
            if (enumValue.name().equals(enumName)) {
                return true;
            }
        }
        return false;
    }
}
