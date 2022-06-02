package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

        JSONArray jsonArray = (JSONArray) jsonObject.get("exchangeRate");

        System.out.println("Date : " + date);
        System.out.println("Bank : " + bank);
        System.out.println("Base currency : " + baseCurrency);
        System.out.println("Base currency lit : " + baseCurrencyLit);

        System.out.println("Exchange rate : " + jsonArray);





    }
}

