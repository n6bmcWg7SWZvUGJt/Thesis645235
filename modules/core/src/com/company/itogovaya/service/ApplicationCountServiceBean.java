/*
 * Copyright (c) 2020 com.company.itogovaya.service
 */
package com.company.itogovaya.service;

import com.company.itogovaya.entity.Car;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.thesis.core.entity.Contractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Lebedev
 */


@Service(ApplicationCountService.NAME)
public class ApplicationCountServiceBean implements ApplicationCountService {

    @Inject
    Persistence persistence;

    @Override
    public int CountOfApplication(Car car){
        return loadCars(car).size();
    }

    @Override
    public int CountOfApplication(Contractor contractor){
        return loadApplication(contractor).size();
    }

    private List<Car> loadCars(Car car) {
        persistence.createTransaction();
        Query query = persistence.getEntityManager().createQuery("select o from itogovaya$ApplicationForPurchaseACar o where o.car.id = :carId");
       query.setParameter("carId", car.getId());
        return query.getResultList();
    }

    private List<Car> loadApplication(Contractor contractor) {
        persistence.createTransaction();
        Query query = persistence.getEntityManager().createQuery("select o from itogovaya$ApplicationForPurchaseACar o where o.carContractor.id = :contractorId");
        query.setParameter("contractorId", contractor.getId());
        return query.getResultList();
    }
}