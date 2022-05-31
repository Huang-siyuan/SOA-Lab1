package ru.itmo.soa.validator;

import ru.itmo.soa.model.Coordinates;
import ru.itmo.soa.model.Vehicle;

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
}
