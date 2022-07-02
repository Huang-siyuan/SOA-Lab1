package ru.itmo.soa.model.mappers;

import org.apache.ibatis.annotations.*;
import ru.itmo.soa.model.DAO.VehicleDAO;
import ru.itmo.soa.model.POJO.Vehicle;

/**
 * @program: SOA-Lab1
 * @author: Siyuan
 * @create: 2022-06-29 19:54
 **/
@Mapper
public interface VehicleMapper {

    @Insert("INSERT INTO vehicle (id, name, coordinates_id, creation_date, engine_power, fuel_consumption, distance_travelled, fuel_type) " +
            "VALUES (#{id}, #{name}, #{coordinatesId}, #{creationDate}, #{enginePower}, #{fuelConsumption}, #{distanceTravelled}, #{fuelType})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insertVehicle(VehicleDAO vehicle);

    @Select("SELECT * FROM vehicle WHERE id = #{id}")
    @ResultMap("vehicleResult")
    VehicleDAO findVehicleById(Long id);

    @Update("UPDATE vehicle SET name = #{name}, creation_date = #{creationDate}, engine_power = #{enginePower}, fuel_consumption = #{fuelConsumption}, " +
            "distance_travelled = #{distanceTravelled}, fuel_type = #{fuelType}, coordinates_id = #{coordinatesId} WHERE id = #{id}")
    Integer updateVehicle(VehicleDAO vehicleDAO);

    @Delete("DELETE FROM vehicle WHERE id = #{id}")
    Integer deleteVehicle(Integer id);

    @Select("SELECT * FROM vehicle")
    @Results(id = "vehicleResult", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "creationDate", column = "creation_date"),
            @Result(property = "enginePower", column = "engine_power"),
            @Result(property = "fuelConsumption", column = "fuel_consumption"),
            @Result(property = "distanceTravelled", column = "distance_travelled"),
            @Result(property = "fuelType", column = "fuel_type"),
            @Result(property = "coordinatesId", column = "coordinates_id")
    })
    VehicleDAO[] findAllVehicles();
}
