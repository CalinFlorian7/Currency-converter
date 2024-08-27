package com.example.currencyconverter.controller;

import com.example.currencyconverter.currency.CurrencyCodes;
import com.example.currencyconverter.currency.CurrencyConverter;
import com.example.currencyconverter.dotenv.DotenvLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CurrencyController {
    @GetMapping("/")
    public String getCurrencyConverter(Model model) {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        System.out.println( currencyConverter.getCurrencyCodes().toString());
        model.addAttribute("currencyConverter", currencyConverter);
        model.addAttribute("currencyCodes", currencyConverter.getCurrencyCodes().getCurrencyCodes());
        model.addAttribute("fromCurrency",currencyConverter.getFromCurrency());
        model.addAttribute("toCurrency",currencyConverter.getToCurrency());

        return "currency";
    }
    @PostMapping("/")
    public String convertCurrency(CurrencyConverter currencyConverter, Model model) {
//        currencyConverter.convertCurrency();
        model.addAttribute("currencyConverter", currencyConverter);
        model.addAttribute("currencyCodes", currencyConverter.getCurrencyCodes().getCurrencyCodes());
        return "currency";
    }
}
