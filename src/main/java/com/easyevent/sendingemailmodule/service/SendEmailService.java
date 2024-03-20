package com.easyevent.sendingemailmodule.service;

import com.easyevent.sendingemailmodule.config.EmailSettingConfig;
import com.easyevent.sendingemailmodule.model.EmailMessage;
import com.easyevent.sendingemailmodule.model.EmailTemplate;
import com.easyevent.sendingemailmodule.model.SenderMessage;
import com.easyevent.sendingemailmodule.model.ToMessage;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class SendEmailService {

    private final EmailSettingConfig config;

    private final RestTemplate restTemplate;

    private static String EMAIL_SERVICE_URL = "https://api.sendinblue.com/v3/smtp/email";

    public SendEmailService(EmailSettingConfig config, RestTemplateBuilder restTemplateBuilder) {
        this.config = config;
        this.restTemplate = restTemplateBuilder.build();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public Object sendTransactionalMail(List<String> to, EmailTemplate template, Map<String, Object> params) {

        List<ToMessage> emails = new ArrayList<>();
        to.forEach(email -> {
            emails.add(new ToMessage(email));
        });

        EmailMessage message = new EmailMessage(
                new SenderMessage("Easyevent", "contact@easyevent.fr"),
                emails,
                template.getTemplateId(),
                params
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("content-type", "application/json");
        headers.set("api-key", config.getKey());

        // build the request
        HttpEntity<EmailMessage> request = new HttpEntity<>(message, headers);

        ResponseEntity<Object> response = this.restTemplate.exchange(SendEmailService.EMAIL_SERVICE_URL, HttpMethod.POST, request, Object.class, 1);
        return response.getStatusCode() == HttpStatus.OK ?
                response.getBody() : null;
    }
}
