package com.sas.sanction.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SanctionUtils {

	public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

	public static boolean isStringNotNullorEmpty(String str){
		if(str != null && !str.isEmpty()){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws ParseException {
//		System.out.println(isStringNotNullorEmpty("asas"));
		
		 String sDate1="2018-04-04T18:30:00.000Z";  
		    Date date1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(sDate1); 
		
		convertIntoSQLDate(date1);
	}
	
	
	public static boolean checkBlank(String str){
		if(str != null && !(str.trim().length() > 0)){
			return true;
		}
		return false;
	}
	
	public static java.sql.Date convertIntoSQLDate(Date inputDate) throws ParseException{
		
	
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat1.format(inputDate));
		
		
		return null;
	}
	
}
