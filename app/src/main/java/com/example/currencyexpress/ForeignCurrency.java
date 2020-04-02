package com.example.currencyexpress;

public class ForeignCurrency {

    public static final String EURO = "EUR";
    public static final String KENYA_SHILLING = "KES";
    public static final String INDIAN_RUPEE ="INR";
    public static final String EMIRATI_DIRHAM = "AED";
    public static final String MEXICAN_PESO = "MXN";

    private int currencyName;
    private int currencyImage;
    private double exchangeRate;

    public ForeignCurrency(int currencyName, int currencyImage, double exchangeRate) {
        this.currencyName = currencyName;
        this.currencyImage = currencyImage;
        this.exchangeRate = exchangeRate;
    }

    public int getCurrencyName() {
        return this.currencyName;
    }

    public int getCurrencyImage() {
        return this.currencyImage;
    }

    public double getExchangeRate() {
        return this.exchangeRate;
    }
}
