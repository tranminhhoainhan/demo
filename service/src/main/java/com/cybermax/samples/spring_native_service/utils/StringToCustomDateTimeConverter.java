package com.cybermax.samples.spring_native_service.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class StringToCustomDateTimeConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
   		Date ret = null;
    	
    	if (s == null || s.isBlank()) {
    		return ret;
    	}
    	else {
    		SimpleDateFormat formatter = null;
    		if (s.matches("^([a-zA-Z]+)( )+([0-9][0-9][0-9][0-9])+")) {
    			formatter = new SimpleDateFormat("MMM yyyy");         			
    		}
    		else if (s.length() == 19) {
    			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
    		}
    		else if (s.length() == 10) {
    			formatter = new SimpleDateFormat("dd/MM/yyyy");
    		}
    		else {
    			formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
    		}    		
			try {
				ret = formatter.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		return ret;    		
    	}
    }
}