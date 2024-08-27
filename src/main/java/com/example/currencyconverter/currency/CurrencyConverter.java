package com.example.currencyconverter.currency;

public class CurrencyConverter {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;
    private CurrencyCodes currencyCodes;

    public CurrencyCodes getCurrencyCodes() {
        return currencyCodes;
    }

    public void setCurrencyCodes(CurrencyCodes currencyCodes) {
        this.currencyCodes = currencyCodes;
    }

    public CurrencyConverter()
    {
        this.currencyCodes = new CurrencyCodes();
        currencyCodes.uploadCodes();
        this.fromCurrency="EUR";
        this.toCurrency="RON";
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
    private void convertCurrency() {
        
    }
}
