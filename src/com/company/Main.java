package com.company;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class Main {

    public static void main(String[] args) throws Exception {

        HttpURLGetConnection test = new HttpURLGetConnection();
        System.out.println(test.sendGET());
        System.out.println("GET DONE");

        String exampleJSON = test.sendGET().toString();

        Object object = new JSONParser().parse(exampleJSON);

        JSONObject jsonObject = (JSONObject) object;

        String date = (String) jsonObject.get("date");
        String bank = (String) jsonObject.get("bank");
        long baseCurrency = (long)jsonObject.get("baseCurrency");
        String baseCurrencyLit = (String) jsonObject.get("baseCurrencyLit");

        Map exchangeRate = ((Map)jsonObject.get("exchangeRate"));

        Iterator<Map.Entry> itr1 = exchangeRate.entrySet().iterator();

        while(itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }




    }
}

