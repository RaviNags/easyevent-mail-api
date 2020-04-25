package com.easyevent.sendingemailmodule.model;

import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
public class EmailMessage {

    SenderMessage sender;

    List<ToMessage> to;

    Integer templateId;

    Map<String, Object> params;
}
