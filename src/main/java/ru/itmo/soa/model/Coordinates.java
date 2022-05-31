package ru.itmo.soa.model;

import lombok.Data;

/**
 * @program: SOA-Lab1
 * @author: Siyuan
 * @create: 2022-05-31 01:34
 **/

@Data
public class Coordinates {
    private int x; // The field value must be greater than -479
    private Double y; // Field value must be greater than -89, Field cannot be null
}
