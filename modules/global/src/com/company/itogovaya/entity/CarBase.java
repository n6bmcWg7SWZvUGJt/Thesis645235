/*
 * Copyright (c) 2020 com.company.itogovaya.entity
 */
package com.company.itogovaya.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.PrimaryKeyJoinColumn;
import com.haulmont.cuba.core.entity.annotation.SystemLevel;
import com.haulmont.thesis.core.annotation.CardBase;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.thesis.core.entity.TsCard;

/**
 * @author YobaEtoYa
 */
@PrimaryKeyJoinColumn(name = "CARD_ID", referencedColumnName = "ID")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("1")
@Table(name = "ITOGOVAYA_CAR_BASE")
@Entity(name = "itogovaya$CarBase")
public class CarBase extends TsCard {
    private static final long serialVersionUID = 3643012350370501173L;

    @Column(name = "NUMBER_", length = 50)
    protected String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_MODEL_ID")
    protected CarModel carModel;

    @Column(name = "NAME", length = 50)
    protected String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "ISSUE", length = 50)
    protected Date issue;

    @Column(name = "PRICE", length = 50)
    protected BigDecimal price;

    @Column(name = "CAR_TYPE")
    protected String carType;

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarType() {
        return carType;
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIssue(Date issue) {
        this.issue = issue;
    }

    public Date getIssue() {
        return issue;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }


}