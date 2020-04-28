/*
 * Copyright (c) 2020 com.company.itogovaya.entity
 */
package com.company.itogovaya.entity;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.thesis.core.entity.Templatable;
import javax.persistence.Column;
import java.util.Locale;
import com.haulmont.cuba.core.entity.annotation.EnableRestore;
import com.haulmont.cuba.core.entity.annotation.TrackEditScreenHistory;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import com.haulmont.chile.core.annotations.NamePattern;

/**
 * @author YobaEtoYa
 */
@NamePattern("%s|templateName")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("3")
@Entity(name = "itogovaya$CarTemplate")
@EnableRestore
@TrackEditScreenHistory
public class CarTemplate extends CarBase implements Templatable {
    private static final long serialVersionUID = -429944838985087636L;

    @Column(name = "TEMPLATE_NAME")
    protected String templateName;

    @Column(name = "GLOBAL_", length = 50)
    protected Boolean global = false;

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateName() {
        return templateName;
    }


    public void setGlobal(Boolean global) {
        this.global = global;
    }

    public Boolean getGlobal() {
        return global;
    }

    @Override
    public boolean isTemplateInstance() {
        return true;
    }

    @Override
    public String getTemplatePrefix(Locale locale) {
        Messages messages = AppBeans.get(Messages.NAME);
        return messages.getMessage(getClass(), "CarTemplate");
    }
}