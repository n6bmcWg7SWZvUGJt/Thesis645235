/*
 * Copyright (c) 2020 com.company.itogovaya.web.contractorlookup
 */
package com.company.itogovaya.web.contractorlookup;

import com.company.itogovaya.service.ApplicationCountService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.thesis.core.entity.Contractor;
import com.haulmont.thesis.core.entity.Individual;
import com.haulmont.thesis.web.ui.contractor.ConrtactorLookup;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author Lebedev
 */
public class ExtConrtactorLookup extends ConrtactorLookup {
    @Inject
    ApplicationCountService applicationCountService;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        companyTable.addGeneratedColumn("GeneratedColumn", new Table.ColumnGenerator() {
            @Override
            public Component generateCell(Entity entity) { // В переменную сохраняем значение сервиса
                return new Table.PlainTextCell("text");
                //((Contractor) entity).toString()
            }
        });
    }
}

