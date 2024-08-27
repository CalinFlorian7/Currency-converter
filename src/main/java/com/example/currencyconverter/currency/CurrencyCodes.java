package com.example.currencyconverter.currency;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class CurrencyCodes {
    private List<String> currencyCodes;
    public CurrencyCodes()
    {
        this.currencyCodes = new ArrayList<>();
    }
    public List<String> getCurrencyCodes() {
        return currencyCodes;
    }

    public void setCurrencyCodes(List<String> currencyCodes) {
        this.currencyCodes = currencyCodes;
    }
    public void uploadCodes()
    {
        try {
            Resource resource=new ClassPathResource("data/CurrencyCodes.txt");
            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(resource.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                String [] parts = line.split("\\s+");
                currencyCodes.add(parts[0]);
            }
                reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "CurrencyCodes{" +
                "currencyCodes=" + currencyCodes +
                '}';
    }
}
