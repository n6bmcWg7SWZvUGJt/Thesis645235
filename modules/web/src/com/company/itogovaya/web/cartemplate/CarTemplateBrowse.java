
package com.company.itogovaya.web.cartemplate;

import com.company.itogovaya.entity.Car;
import com.company.itogovaya.entity.CarBase;
import com.company.itogovaya.entity.CarTemplate;
import com.company.itogovaya.web.car.CarBrowse;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.thesis.web.ui.common.actions.CreateCardFromTemplateAction;

import javax.inject.Inject;
import java.util.Map;

public class CarTemplateBrowse extends CarBrowse<CarTemplate> {

    @Inject
    protected Button createCardFromTemplateButton;
    @Inject
    protected Metadata metadata;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initCreateCardFromTemplateAction();
    }

    protected void initCreateCardFromTemplateAction() {
        createCardFromTemplateButton.setAction(new CreateCardFromTemplateAction<CarBase>(
                metadata.getClass(Car.class), this, "createCardFromTemplate"));
    }

    protected boolean isCreateByTemplateActionEnabled() {
        return false;
    }

    @Override
    protected void addImportantColumn() {
    }

    @Override
    protected void addLocStateColumn() {
    }

    @Override
    protected void initCardDetailsFunctionality() {
    }

    @Override
    protected boolean isFilterImportantConditionEnabled() {
        return false;
    }
}