package com.company.itogovaya.web.applicationforpurchaseacar;

import java.util.Map;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.thesis.web.ui.basicdoc.browse.AbstractDocBrowser;
import com.company.itogovaya.entity.ApplicationForPurchaseACar;

public class ApplicationForPurchaseACarBrowse extends AbstractDocBrowser<ApplicationForPurchaseACar> {

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        entityName = "itogovaya$ApplicationForPurchaseACar";
    }
}