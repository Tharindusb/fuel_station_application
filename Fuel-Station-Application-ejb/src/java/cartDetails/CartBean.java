/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package cartDetails;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import order.Customer;

/**
 *
 * @author tharindu
 */
@Stateless
@LocalBean
public class CartBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private double unitprice;
    private String fuelType;
    
    
    
    public CartBean(){}

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    
    public List<String> getOrder() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        List<String> orderList = new ArrayList<String>();
    
    try {
            String query = "SELECT CUSTOMER_VEHICLE_NO,CUSTOMER_VEHICLE_TYPE FROM CUSTOMER WHERE CUSTOMER_ID =1";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FUEL_STATION_DB?useSSL=false", "root", "Password123#@!");
            if(conn.isValid(0)) {
                out.println("connection is ready");
            } else {
                out.println("connection is not ready");
            }
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String cvn = rs.getString("CUSTOMER_VEHICLE_NO");
                String cvt = rs.getString("CUSTOMER_VEHICLE_TYPE");
                orderList.add(cvn);
                orderList.add(cvt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
    return orderList;
    }
}
