/*
 * Copyright (c) 2020 com.company.itogovaya.web.contractorlookup
 */
package com.company.itogovaya.web.contractorlookup;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.thesis.web.ui.contractor.ConrtactorLookup;

import java.util.Map;

/**
 * @author Lebedev
 */
public class ExtConrtactorLookup extends ConrtactorLookup {

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        companyTable.addGeneratedColumn("GeneratedColumn", new Table.ColumnGenerator() {
            @Override
            public Component generateCell(Entity entity) {
                return new Table.PlainTextCell("text");
            }
        });
    }
}

