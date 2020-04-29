package com.company.itogovaya.web.screens;

import com.company.itogovaya.entity.Car;
import com.company.itogovaya.service.ApplicationCountService;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.LookupField;

import javax.inject.Inject;

public class Screen extends AbstractWindow {

    @Inject
    private Label label;

    @Inject
    private ApplicationCountService applicationCountService;

    @Inject
    private LookupField lookupField;

    public void onButtonClick(Component source) {
        label.setValue(applicationCountService.CountOfApplication((Car)lookupField.getValue()));
    }
}