package com.example.currencyconverter.currency;


import com.example.currencyconverter.dotenv.DotenvLoader;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class CurrencyConverter {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;
    private CurrencyCodes currencyCodes;
    private double conversionRate;

    private String conversionResult;
    public String getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(String conversionResult) {
        this.conversionResult = conversionResult;
    }







    public CurrencyCodes getCurrencyCodes() {
        return currencyCodes;
    }

    public void setCurrencyCodes(CurrencyCodes currencyCodes) {
        this.currencyCodes = currencyCodes;
    }

    public CurrencyConverter() {
        this.currencyCodes = new CurrencyCodes();
        currencyCodes.uploadCodes();
        this.fromCurrency = "EUR";
        this.toCurrency = "RON";
        this.amount = 1;
        this.conversionResult="";
        convertCurrency();
    }

    public void convertCurrency() {

        String url_str = "https://v6.exchangerate-api.com/v6/" + DotenvLoader.getApiKey() + "/pair/" + fromCurrency + "/" + toCurrency + "/" + amount;

        try {
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            int code= request.getResponseCode();
            if(code==403)
            {
                this.conversionResult="API key is invalid or has expired";
            }

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            String req_result = jsonobj.get("result").getAsString();

                this.conversionRate = Double.parseDouble(jsonobj.get("conversion_rate").getAsString());
                this.convertedAmount = Double.parseDouble(jsonobj.get("conversion_result").getAsString());







        } catch (Exception e) {
            System.out.println("Error in CurrencyConverter.convertCurrency()");
            e.printStackTrace();
        }


    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }


    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }
}
