/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package order;

/**
 *
 * @author dushyantha
 */
public enum VehicleTypeEnum {
    CAR("CAR"),
    VAN("VAN"),
    LORRY("LORRY");
    
    private String value;

    VehicleTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
