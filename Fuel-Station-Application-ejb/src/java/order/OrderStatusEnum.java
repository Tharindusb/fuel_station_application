/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package order;

/**
 *
 * @author dushyantha
 */
public enum OrderStatusEnum {
    NOT_COMPLETE("NOT_COMPLETE"),
    SUCCESS("SUCCESS"),
    PROCESSING("PROCESSING"),
    COMPLETE("COMPLETE");
    
    private String value;

    OrderStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
