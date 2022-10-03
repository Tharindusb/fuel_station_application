/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package order;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author tharindu
 */
@Stateless
@LocalBean
public class FuelBean {

    private int fuelToken;
    private String fuelType;
    private String fuelDesc;
    private double fuelPrice;

    public int getFuelToken() {
        return fuelToken;
    }

    public void setFuelToken(int fuelToken) {
        this.fuelToken = fuelToken;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelDesc() {
        return fuelDesc;
    }

    public void setFuelDesc(String fuelDesc) {
        this.fuelDesc = fuelDesc;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }
    
    public void fuelOrder(FuelBean fuelbean) throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
         try {
            String query = "INSERT INTO FUEL_DETAIL(FUEL_TYPE, FUEL_DESCRIPTION,FUEL_PRICE) VALUES(?, YES,?)";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FUEL_STATION_DB?useSSL=false", "root", "Password123#@!");
            
            if(conn.isValid(0)) {
                out.println("connection is ready");
            } else {
                out.println("connection is not ready");
            }
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, fuelbean.getFuelType());
            ps.setDouble(3, fuelbean.getFuelPrice());
         }catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
