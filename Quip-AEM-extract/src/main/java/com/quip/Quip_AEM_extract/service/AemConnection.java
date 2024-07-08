package com.quip.Quip_AEM_extract.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quip.Quip_AEM_extract.utilities.Constants;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

@Service
public class AemConnection {

    public String getConnection(URL url) throws IOException {

        HttpURLConnection httpUrlconnection = (HttpURLConnection) url.openConnection();
        httpUrlconnection.setRequestMethod("GET");

        String credentials = Constants.USERNAME + ":" + Constants.PASSWORD;
        String authHeaderValue = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());

        httpUrlconnection.setRequestProperty("Authorization", authHeaderValue);
        httpUrlconnection.setRequestProperty("Content-Type", "application/json");

        if (httpUrlconnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStreamReader inputStreamReader = new InputStreamReader(httpUrlconnection.getInputStream());
            String data = FileCopyUtils.copyToString(inputStreamReader);
            if (data.equals("{}")) {
                return null;
            }
            return data;
        }
        return null;
    }
}