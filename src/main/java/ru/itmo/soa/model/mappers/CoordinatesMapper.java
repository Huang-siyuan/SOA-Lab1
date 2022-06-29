package ru.itmo.soa.model.mappers;

import org.apache.ibatis.annotations.*;
import ru.itmo.soa.model.DAO.CoordinatesDAO;

@Mapper
public interface CoordinatesMapper {
    @Insert("INSERT INTO coordinates (x, y) VALUES (#{coordinate_x}, #{coordinate_y})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insertCoordinates(CoordinatesDAO coordinates);

    @Select("SELECT * FROM coordinates WHERE id = #{id}")
    Integer findCoordinatesById(Long id);

    @Delete("DELETE FROM coordinates WHERE id = #{id}")
    Integer deleteCoordinates(Long id);

    @Update("UPDATE coordinates SET x = #{coordinate_x}, y = #{coordinate_y} WHERE id = #{id}")
    Integer updateCoordinates(CoordinatesDAO coordinates);
}
