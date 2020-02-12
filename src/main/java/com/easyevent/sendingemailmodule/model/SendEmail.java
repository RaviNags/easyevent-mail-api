package com.easyevent.sendingemailmodule.model;

import com.squareup.okhttp.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

public class SendEmail {

    public void sendTransactionalMail () throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody body = RequestBody.create(mediaType, "{\"sender\":{\"name\":\"Easyevent\",\"email\":\"alex.rajamohan@hotmail.fr\"},\"to\":[{\"email\":\"alex.rajamohan@hotmail.fr\"}],\"templateId\":2}");
        Request request = new Request.Builder()
                .url("https://api.sendinblue.com/v3/smtp/email")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("api-key", "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")
                .build();

        Response response = client.newCall(request).execute();
    }




    public void sendMail() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.sendinblue.com/v3/emailCampaigns/campaignId/sendTest")
                .post(null)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("api-key", "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")
                .build();

        Response response = client.newCall(request).execute();
    }


   /* @SpringBootApplication
    public static class SendinblueApplication {

        public static void main(String[] args) throws IOException {
            SpringApplication.run(SendinblueApplication.class, args);


            SendEmail sendEmail = new SendEmail();
            sendEmail.sendTransactionalMail();
            sendEmail.sendMail();
        }
    }*/
}
