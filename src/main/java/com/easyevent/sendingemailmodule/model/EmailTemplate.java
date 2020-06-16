package com.easyevent.sendingemailmodule.model;

public enum EmailTemplate {

    HEBDO_SITUATION(1),
    REGISTER(3),
    COLLABORATOR_INVITATION(4),
    RESA_CONTACT(6);

    private final int templateId;

    EmailTemplate(int templateId) {
        this.templateId = templateId;
    }

    public int getTemplateId() {
        return templateId;
    }
}
