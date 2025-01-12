package com.easyevent.sendingemailmodule.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;
import java.util.Map;

public record EmailMessage(
    SenderMessage sender,
    List<ToMessage> to,
    @JsonProperty("templateId")
    Integer templateId,
    Map<String, Object> params
){}
