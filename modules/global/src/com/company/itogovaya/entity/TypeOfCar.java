/*
 * Copyright (c) 2020 com.company.itogovaya.entity
 */
package com.company.itogovaya.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;

/**
 * @author YobaEtoYa
 */
public enum TypeOfCar implements EnumClass<String> {

    Crossover("Crossover"),
    StationWagon("Station wagon"),
    Sedan("Sedan");

    private String id;

    TypeOfCar(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TypeOfCar fromId(String id) {
        for (TypeOfCar at : TypeOfCar.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}