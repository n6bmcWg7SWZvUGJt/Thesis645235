/*
 * Copyright (c) 2020 com.company.itogovaya.service
 */
package com.company.itogovaya.service;

import com.company.itogovaya.entity.Car;
import com.haulmont.thesis.core.entity.Contractor;

/**
 * @author YobaEtoYa
 */
public interface ApplicationCountService {
    String NAME = "itogovaya_ApplicationCountService";

    int CountOfApplication(Car car);

    int CountOfApplication(Contractor contractor);
}