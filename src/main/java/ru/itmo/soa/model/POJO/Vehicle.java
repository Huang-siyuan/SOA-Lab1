package ru.itmo.soa.model.POJO;

import lombok.Data;

/**
 * @program: SOA-Lab1
 * @author: Siyuan
 * @create: 2022-05-31 01:33
 **/

@Data
public class Vehicle {
    // ID will be created by database.
    private Long id; // The field cannot be null, The field value must be greater than 0, The value of this field must be unique, The value of this field must be generated automatically
    private String name; // Field cannot be null, String cannot be empty
    private Coordinates coordinates; // Field cannot be null.
    private java.time.LocalDateTime creationDate; // The field cannot be null, the value of this field must be generated automatically
    private Double enginePower; // The field cannot be null, the field value must be greater than 0
    private long fuelConsumption; // The field value must be greater than 0
    private Long distanceTravelled; // The field can be null, the field value must be greater than 0
    private FuelType fuelType; // Field cannot be null

    public Vehicle(String name, Coordinates coordinates, Double enginePower, long fuelConsumption, Long distanceTravelled, FuelType fuelType) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDateTime.now();
        this.enginePower = enginePower;
        this.fuelConsumption = fuelConsumption;
        this.distanceTravelled = distanceTravelled;
        this.fuelType = fuelType;
    }

    public Vehicle(String name, int coordinateX, Double coordinateY, Double enginePower, long fuelConsumption, Long distanceTravelled, FuelType fuelType) {

        if(this.coordinates == null) {
            this.coordinates = new Coordinates();
        }
        this.coordinates.setX(coordinateX);
        this.coordinates.setY(coordinateY);

        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDateTime.now();
        this.enginePower = enginePower;
        this.fuelConsumption = fuelConsumption;
        this.distanceTravelled = distanceTravelled;
        this.fuelType = fuelType;
    }
}
