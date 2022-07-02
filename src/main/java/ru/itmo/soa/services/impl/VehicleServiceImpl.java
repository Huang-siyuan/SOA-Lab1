package ru.itmo.soa.services.impl;

import com.sun.xml.internal.bind.v2.TODO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ru.itmo.soa.model.DAO.CoordinatesDAO;
import ru.itmo.soa.model.DAO.VehicleDAO;
import ru.itmo.soa.model.POJO.Coordinates;
import ru.itmo.soa.model.POJO.FuelType;
import ru.itmo.soa.model.POJO.Vehicle;
import ru.itmo.soa.model.mappers.CoordinatesMapper;
import ru.itmo.soa.model.mappers.VehicleMapper;
import ru.itmo.soa.services.VehicleService;
import ru.itmo.soa.validator.Validator;
import ru.itmo.soa.validator.Validator.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: SOA-Lab1
 * @author: Siyuan
 * @create: 2022-07-02 16:39
 **/
public class VehicleServiceImpl implements VehicleService {

    private VehicleMapper vehicleMapper;
    private CoordinatesMapper coordinatesMapper;

    public VehicleServiceImpl() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        vehicleMapper = sqlSession.getMapper(VehicleMapper.class);
        coordinatesMapper = sqlSession.getMapper(CoordinatesMapper.class);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        VehicleDAO vehicleDAO = vehicleMapper.findVehicleById(id);
        if (vehicleDAO == null) {
            return null;
        }
        return toPOJO(vehicleDAO);
    }

    @Override
    public Integer updateVehicle(Vehicle vehicle) {
        VehicleDAO vehicleToUpdate = vehicleMapper.findVehicleById(vehicle.getId());
        if (vehicleToUpdate == null) return null;

        CoordinatesDAO coordinatesDAO = coordinatesMapper.findCoordinatesById(vehicleToUpdate.getCoordinatesId());
        Coordinates coordinates = vehicle.getCoordinates();


        if (!vehicle.getCoordinates().equals(toPOJO(coordinatesDAO))) {
            coordinatesDAO.setX(coordinates.getX());
            coordinatesDAO.setY(coordinates.getY());
            coordinatesMapper.updateCoordinates(coordinatesDAO);
        }

        vehicleToUpdate.setDistanceTravelled(vehicle.getDistanceTravelled());
        vehicleToUpdate.setFuelType(vehicle.getFuelType().toString());
        vehicleToUpdate.setEnginePower(vehicle.getEnginePower());
        vehicleToUpdate.setFuelConsumption(vehicle.getFuelConsumption());
        vehicleToUpdate.setName(vehicle.getName());

        return vehicleMapper.updateVehicle(vehicleToUpdate);
    }

    @Override
    public Integer deleteVehicle(Long id) {
        VehicleDAO vehicleDAO = vehicleMapper.findVehicleById(id);
        if (vehicleDAO == null) return null;
        Integer coordinatesId = vehicleDAO.getCoordinatesId();
        vehicleMapper.deleteVehicle(coordinatesId);
        return coordinatesMapper.deleteCoordinates(id);
    }

    @Override
    public Integer insertVehicle(Vehicle vehicle) {
        Validator.validateVehicle(vehicle);
        Coordinates coordinates = vehicle.getCoordinates();
        Integer coordinatesId = coordinatesMapper.insertCoordinates(coordinates.toDAO());

        VehicleDAO vehicleDAO = vehicle.toVehicleDAO();
        vehicleDAO.setCoordinatesId(coordinatesId);
        return vehicleMapper.insertVehicle(vehicleDAO);
    }

    @Override
    public Vehicle[] getAllVehicles() {
        // TODO: 2022/7/2
        return new Vehicle[0];
    }

    public Vehicle toPOJO(VehicleDAO vehicleDAO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDAO.getId());
        vehicle.setCreationDate(vehicleDAO.getCreationDate());
        vehicle.setDistanceTravelled(vehicleDAO.getDistanceTravelled());
        vehicle.setEnginePower(vehicleDAO.getEnginePower());
        vehicle.setFuelConsumption(vehicleDAO.getFuelConsumption());
        vehicle.setId(vehicleDAO.getId());
        vehicle.setName(vehicleDAO.getName());

        Coordinates coordinates = toPOJO(coordinatesMapper.findCoordinatesById(vehicleDAO.getCoordinatesId()));
        vehicle.setCoordinates(coordinates);

        Validator.validateVehicle(vehicle);
        return vehicle;
    }

    public Coordinates toPOJO(CoordinatesDAO coordinatesDAO) {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(coordinatesDAO.getX());
        coordinates.setY(coordinatesDAO.getY());
        Validator.validateCoordinates(coordinates);
        return coordinates;
    }
}

