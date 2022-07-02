package ru.itmo.soa.model.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.soa.model.DAO.CoordinatesDAO;

import java.util.Objects;

/**
 * @program: SOA-Lab1
 * @author: Siyuan
 * @create: 2022-05-31 01:34
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates {
    private int x; // The field value must be greater than -479
    private Double y; // Field value must be greater than -89, Field cannot be null

    public CoordinatesDAO toDAO() {
        return new CoordinatesDAO(null, x, y);
    }
}
