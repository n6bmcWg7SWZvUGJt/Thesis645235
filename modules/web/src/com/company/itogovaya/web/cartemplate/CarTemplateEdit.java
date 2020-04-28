
package com.company.itogovaya.web.cartemplate;

import com.company.itogovaya.entity.CarTemplate;
import com.company.itogovaya.web.car.CarEdit;

public class CarTemplateEdit extends CarEdit<CarTemplate> {

    @Override
    protected boolean isNumberAssignNeeded() {
        return false;
    }

    @Override
    protected boolean isImportantButtonVisible() {
        return false;
    }
}