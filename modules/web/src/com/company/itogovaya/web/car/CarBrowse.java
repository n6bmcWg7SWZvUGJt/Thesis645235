package com.company.itogovaya.web.car;


import java.util.Map;
import javax.inject.Inject;
import com.company.itogovaya.entity.Car;
import com.company.itogovaya.entity.CarTemplate;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.thesis.web.ui.common.actions.SaveCardAsTemplateAction;
import com.haulmont.thesis.web.ui.common.cardcreator.CreateCardByTemplateWindow;
import com.haulmont.thesis.web.ui.tools.CardTools;

import com.company.itogovaya.entity.CarBase;
import com.haulmont.thesis.web.ui.basic.browse.AbstractCardBrowser;

public class CarBrowse<T extends CarBase> extends AbstractCardBrowser<T> {

    
    @Inject
    protected CardTools cardTools;
    @Inject
    protected Metadata metadata;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initSaveFromTemplateAction();
    }

    protected void initSaveFromTemplateAction() {
        Button saveAsTemplateButton = getComponent("saveAsTemplateButton");
        if (saveAsTemplateButton != null) {
            saveAsTemplateButton.setAction(new SaveCardAsTemplateAction<T>(cardsTable,
                    metadata.getClass(CarTemplate.class)));
        }
    }

    protected Action createCreateAction() {
        if (isCreateByTemplateActionEnabled()) {
            return new AbstractAction(CreateAction.ACTION_ID) {
                @Override
                public void actionPerform(Component component) {
                    final MetaClass cardMetaClass = metadata.getClassNN(Car.class);
                            MetaClass templateMetaClass = metadata.getClass(CarTemplate.class);
                    final CreateCardByTemplateWindow<T> creator = cardTools.showCardCreatorDialog(
                            cardMetaClass, templateMetaClass, getMessage("creatorWindowCaption"), null);
                    creator.addListener(new Window.CloseListener() {
                        @Override
                        public void windowClosed(String actionId) {
                            if (Window.Editor.WINDOW_COMMIT.equals(actionId)) {
                                Car card = (Car) creator.getCard();
                                Window editor = openEditor(cardMetaClass.getName() + ".edit",
                                card, WindowManager.OpenType.THIS_TAB);
                                editor.addListener(
                                    new CloseListener() {
                                        public void windowClosed(String actionId) {
                                            cardsDs.refresh();
                                        }
                                    }
                                );
                            }
                        }
                    });
                }

                @Override
                public String getCaption() {
                    return messages.getMainMessage("actions.Create");
                }

                @Override
                public String getIcon() {
                    return "icons/create.png";
                }
            };
        } else
            return super.createCreateAction();
    }

    protected boolean isCreateByTemplateActionEnabled() {
        return true;
    }
    
}