package com.company.itogovaya.web.applicationforpurchaseacar;

import com.haulmont.thesis.web.actions.PrintReportAction;
import com.haulmont.thesis.web.ui.basicdoc.editor.AbstractDocEditor;
import com.haulmont.workflow.core.app.WfUtils;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import org.apache.commons.lang.StringUtils;
import com.haulmont.cuba.core.entity.Entity;

import java.util.*;

import com.company.itogovaya.entity.ApplicationForPurchaseACar;

public class ApplicationForPurchaseACarEdit extends AbstractDocEditor<ApplicationForPurchaseACar> {


    @Override
    public void init(Map<String, Object> params) {

        super.init(params);

    }

    @Override
    protected String getHiddenTabsConfig() {
        return "correspondenceHistoryTab,docLogTab,cardLinksTab,processTab,securityTab,docTransferLogTab,cardProjectsTab,versionsTab,openHistoryTab";
    }

    @Override
    public void setItem(Entity item) {
        super.setItem(item);
        printButton.addAction(new PrintReportAction("printExecutionList", this, "printDocExecutionListReportName"));
        buttonMethod();
    }

    @Override
    protected Component createState() {
        if (WfUtils.isCardInState(getItem(), "New") || StringUtils.isEmpty(getItem().getState())) {
            Label label = componentsFactory.createComponent(Label.NAME);
            label.setValue(StringUtils.isEmpty(getItem().getState()) ? "" : getItem().getLocState());
            return label;
        } else {
            return super.createState();
        }
    }

    @Override
    protected void fillHiddenTabs() {
        hiddenTabs.put("office", getMessage("office"));
        hiddenTabs.put("attachmentsTab", getMessage("attachmentsTab"));
        hiddenTabs.put("docTreeTab", getMessage("docTreeTab"));
        hiddenTabs.put("cardCommentTab", getMessage("cardCommentTab"));
        super.fillHiddenTabs();
    }

    public void onRefreshButtonClick(Component source) {
        buttonMethod();
    }

    private void buttonMethod() {
        try {
            Collection<Component> components = actionsFrame.getOwnComponents();
            if (components != null) {
                ArrayList<Component> al = new ArrayList<>(components);
                boolean btnStat = false;
                if (getItem().getCarPaid() == true) btnStat = true;
                for (Component component : al) {
                    if (component.getId().equals("Proverka_dokumentov.Provereno_BTN")) component.setEnabled(btnStat);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}