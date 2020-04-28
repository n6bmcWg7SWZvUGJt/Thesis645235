/*
 * Copyright (c) 2020 com.company.itogovaya.web.companybrowse
 */
package com.company.itogovaya.web.companybrowse;

import com.company.itogovaya.service.ApplicationCountService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.thesis.core.entity.Contractor;
import com.haulmont.thesis.web.ui.company.CompanyBrowser;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author YobaEtoYa
 */
public class ExtCompanyBrowser extends CompanyBrowser {
    @Inject
    ApplicationCountService applicationCountService;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        companiesTable.addGeneratedColumn("Count of application", new Table.ColumnGenerator() {
            @Override
            public Component generateCell(Entity entity) { // В переменную сохраняем значение сервиса
                return new Table.PlainTextCell(String.valueOf(applicationCountService.CountOfApplication((Contractor)entity)));

            }
        });
    }
}
