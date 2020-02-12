package com.easyevent.sendingemailmodule;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.easyevent.sendingemailmodule.model", "com.easyevent.sendingemailmodule.service"})
@EnableAutoConfiguration
public class SendingemailApplication {

    public static void main(String[] args) {

    }

    }
