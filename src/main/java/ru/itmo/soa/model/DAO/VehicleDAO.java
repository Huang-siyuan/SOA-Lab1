package ru.itmo.soa.model.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SOA-Lab1
 * @author: Siyuan
 * @create: 2022-06-29 22:05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDAO {
    // ID will be created by database.
    private Long id; // The field cannot be null, The field value must be greater than 0, The value of this field must be unique, The value of this field must be generated automatically
    private String name; // Field cannot be null, String cannot be empty
    private Integer coordinatesId; // ID of coordinates.
    private java.time.LocalDateTime creationDate; // The field cannot be null, the value of this field must be generated automatically
    private Double enginePower; // The field cannot be null, the field value must be greater than 0
    private long fuelConsumption; // The field value must be greater than 0
    private Long distanceTravelled; // The field can be null, the field value must be greater than 0
    private String fuelType;

}
