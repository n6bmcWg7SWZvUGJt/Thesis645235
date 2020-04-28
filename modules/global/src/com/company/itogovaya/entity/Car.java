/*
 * Copyright (c) 2020 com.company.itogovaya.entity
 */
package com.company.itogovaya.entity;


/**
 * @author YobaEtoYa
 */
import com.haulmont.cuba.core.entity.annotation.EnableRestore;
import com.haulmont.cuba.core.entity.annotation.TrackEditScreenHistory;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import com.haulmont.cuba.core.entity.annotation.Listeners;

@Listeners("itogovaya_CarListener")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("2")
@Entity(name = "itogovaya$Car")
@EnableRestore
@TrackEditScreenHistory
public class Car extends CarBase {
    private static final long serialVersionUID = -5273168879180696830L;

}