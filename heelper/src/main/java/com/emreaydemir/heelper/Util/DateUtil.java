package com.emreaydemir.heelper.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String DATEFORMAT_FULL = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ";
    public static String DATEFORMAT_SHORT = "dd.MM.yyyy, HH:mm";


    public static Date stringToDate(String value, String dateFormatType){

        SimpleDateFormat format = new SimpleDateFormat(dateFormatType, java.util.Locale.getDefault());
        try {
            return format.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String dateToString(Date value, String dateFormatType){
        if(value!=null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatType, java.util.Locale.getDefault());
            String dateTime = dateFormat.format(value);
            return dateTime;
        }
        else {
            return null;
        }
    }


}
