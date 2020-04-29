/*
 * Copyright (c) 2020 com.company.itogovaya.core.listener
 */
package com.company.itogovaya.core.listener;

import com.haulmont.cuba.core.Persistence;
import org.apache.commons.lang.StringUtils;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Set;
import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.company.itogovaya.entity.Car;
/**
 * @author Lebedev
 */
@ManagedBean("itogovaya_CarListener")
public class CarListener implements BeforeUpdateEntityListener<Car>, BeforeInsertEntityListener<Car> {

    @Inject
    protected Persistence persistence;

    @Override
    public void onBeforeUpdate(Car entity) {

        Set<String> fields = persistence.getTools().getDirtyFields(entity);

        if (CollectionUtils.containsAny(fields, Arrays.asList("number"))){
            StringBuilder description=new StringBuilder();
            description.append(StringUtils.trimToEmpty(entity.<String>getValue("number")));
            entity.setDescription(description.toString());
        }
    }

    @Override
    public void onBeforeInsert(Car entity) {
        onBeforeUpdate(entity);
    }
}