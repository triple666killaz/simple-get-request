package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class HttpURLGetConnection {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "https://api.privatbank.ua/p24api/exchange_rates?json&date=01.12.2014";

    public StringBuffer sendGET() throws IOException {

        URL url = new URL(GET_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = connection.getResponseCode();
        System.out.println("GET Response code : " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response;

        } else {
            System.out.println("GET request not worked");
            return null;
        }

    }


}
