package com.easyevent.sendingemailmodule.model;

public enum EmailTemplate {
    HEBDO_SITUATION(1),
    REGISTER(3),
    COLLABORATOR_INVITATION(4),
    RESA_CONTACT(6),
    DEVIS(16),
    SUBSCRIPTIONS_SUCCESS(8),
    NOTIFICATION_NEW_DEVIS(12),
    REMIND_CONTRACT(14),
    REVIVAL_CONTRACT(17);

    private final int templateId;

    EmailTemplate(int templateId) {
        this.templateId = templateId;
    }

    public int getTemplateId() {
        return templateId;
    }
}
