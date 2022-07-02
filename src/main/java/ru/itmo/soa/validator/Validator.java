package ru.itmo.soa.validator;

import ru.itmo.soa.model.POJO.Coordinates;
import ru.itmo.soa.model.POJO.FuelType;
import ru.itmo.soa.model.POJO.Vehicle;

public class Validator {

    public static boolean validateVehicle(Vehicle vehicle) {
        return vehicle.getName() != null && vehicle.getName().length() > 0 &&
               vehicle.getCoordinates() != null &&
               vehicle.getCreationDate() != null &&
               vehicle.getEnginePower() != null && vehicle.getEnginePower() > 0 &&
               vehicle.getFuelConsumption() > 0 &&
               (vehicle.getDistanceTravelled() == null || vehicle.getDistanceTravelled() > 0) &&
               vehicle.getFuelType() != null &&
               validateCoordinates(vehicle.getCoordinates());
    }

    public static boolean validateCoordinates(Coordinates coordinates) {
        return coordinates.getX() > -479 && coordinates.getY() > -89;
    }

    public static boolean validateFuelType(String fuelType) {
        return (fuelType != null) &&
               (fuelType.equals("KEROSENE") || fuelType.equals("DIESEL") || fuelType.equals("MANPOWER") || fuelType.equals("NUCLEAR") || fuelType.equals("PLASMA"));
    }
}
