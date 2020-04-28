/*
 * Copyright (c) 2020 com.company.itogovaya.core.app.reassignment.commands
 */
package com.company.itogovaya.core.app.reassignment.commands;


import com.haulmont.thesis.core.app.reassignment.commands.AbstractDocReassignmentCommand;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import com.company.itogovaya.entity.ApplicationForPurchaseACar;

/**
 * @author Lebedev
 */
@ManagedBean(ApplicationForPurchaseACarReassignmentCommand.NAME)
public class ApplicationForPurchaseACarReassignmentCommand extends AbstractDocReassignmentCommand<ApplicationForPurchaseACar> {
    protected static final String NAME = "applicationforpurchaseacar_reassignment_command";

    @PostConstruct
    protected void postInit() {
        type = "ApplicationForPurchaseACar";
        docQuery = String.format(DOC_QUERY_TEMPLATE, "itogovaya$ApplicationForPurchaseACar");
    }

    @Override
    public String getName() {
        return NAME;
    }
}