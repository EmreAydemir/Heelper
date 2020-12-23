package com.emreaydemir.heelper.util;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    public static final String TRY = "TRY";
    public static final String EUR = "EUR";
    public static final String USD = "USD";


    public static String convertCurrency(Double value, String currency){
        Locale locale;
        switch (currency){
            case TRY:
                locale= new Locale("tr","TR");
                break;
            case EUR:
                locale= new Locale("de","DE");
                break;
            case USD:
                locale= new Locale("us","US");
                break;
            default:
                locale= new Locale("tr","TR");
                break;
        }

        return NumberFormat.getCurrencyInstance(locale).format(value);
    }
}
