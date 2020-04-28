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
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;

@NamePattern("%s|name")
@Table(name = "ITOGOVAYA_CAR_MODEL")
@Entity(name = "itogovaya$CarModel")
@EnableRestore
@TrackEditScreenHistory
public class CarModel extends StandardEntity {
    private static final long serialVersionUID = -3173023558656970427L;

    @Column(name = "NAME", length = 50)
    protected String name;

    @Column(name = "CODE", length = 50)
    protected String code;

    @Column(name = "NOTE", length = 50)
    protected String note;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }


}