package com.example.currencyconverter.dotenv;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvLoader {
    public static final Dotenv dotenv = Dotenv.load();
    public static String getApiKey(){
        if(dotenv.get("API_KEY")==null){
            throw new RuntimeException("API_KEY not found in .env file");
        }
        return dotenv.get("API_KEY");
    }
}
