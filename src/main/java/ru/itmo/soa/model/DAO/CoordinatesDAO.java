package ru.itmo.soa.model.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itmo.soa.model.POJO.Coordinates;

/**
 * @program: SOA-Lab1
 * @author: Siyuan
 * @create: 2022-06-29 22:04
 **/
@Data
@AllArgsConstructor
public class CoordinatesDAO {
    private Integer id; // The field cannot be null, The field value must be greater than 0, The value of this field must be unique, The value of this field must be generated automatically
    private int x; // The field value must be greater than -479
    private Double y; // Field value must be greater than -89, Field cannot be null

    public Coordinates toPOJO() {
        return new Coordinates(x, y);
    }
}
