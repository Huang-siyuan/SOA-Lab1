package ru.itmo.soa.model.POJO;

/**
 * @program: SOA-Lab1
 * @author: Siyuan
 * @create: 2022-05-31 01:34
 **/
public enum FuelType {
    KEROSENE("KEROSENE"),
    DIESEL("DIESEL"),
    MANPOWER("MANPOWER"),
    NUCLEAR("NUCLEAR"),
    PLASMA("PLASMA");

    private String name;
    FuelType(String name) {
        this.name = name;
    }
}
