package com.easyevent.sendingemailmodule.service;

import com.squareup.okhttp.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Service
public class SendEmailService {

    public ResponseBody sendTransactionalMail (ArrayList<String> to, int templateId, Map<String, String> params, String apiKey) throws IOException {

        JSONArray emails = new JSONArray();
        to.forEach(e->{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", e);
            emails.put(jsonObject);
        });


        OkHttpClient client = new OkHttpClient();

        JSONObject content = new JSONObject("{\"sender\":{\"name\":\"Easyevent\",\"email\":\"contact@easyevent.fr\"}}");
        content.put("to", emails);
        content.put("templateId", templateId);
        content.put("params", params);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, String.valueOf(content));
        Request request = new Request.Builder()
                .url("https://api.sendinblue.com/v3/smtp/email")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("api-key", apiKey)
                .build();

        Response response = client.newCall(request).execute();
        return response.body();
    }
}
