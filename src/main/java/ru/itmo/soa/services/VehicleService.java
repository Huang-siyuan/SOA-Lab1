package ru.itmo.soa.services;

import ru.itmo.soa.model.DAO.VehicleDAO;
import ru.itmo.soa.model.POJO.Vehicle;

import java.io.IOException;

/**
 * @program: SOA-Lab1
 * @author: Siyuan
 * @create: 2022-07-02 16:39
 **/
public interface VehicleService {
    Vehicle getVehicleById(Long id);

    Integer updateVehicle(Vehicle vehicle);

    Integer deleteVehicle(Long id);

    Integer insertVehicle(Vehicle vehicle);

    Vehicle[] getAllVehicles();
}
