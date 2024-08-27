package com.example.currencyconverter.dotenv;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvLoader {
    public static final Dotenv dotenv = Dotenv.load();
    public static String getApiKey(){
        return dotenv.get("API_KEY");
    }
}
