package com.easyevent.sendingemailmodule.model;

public enum EmailTemplate {

    REGISTER(1),
    HEBDO_SITUATION(2);

    private final int templateId;

    EmailTemplate(int templateId) {
        this.templateId = templateId;

    }

    public int getTemplateId() {
        return templateId;
    }
}
