package com.sydx.aqsc.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CommonUtil {
	public static String getMd5(String source) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(source.getBytes());
			byte[] digest = md5.digest();
			BigInteger code = new BigInteger(1, digest);
			return (code.toString(16)).toUpperCase();
		} catch (Exception e) {
			return null;
		}
	}
	public static Date dateAdd(Date d1, int AddType, int val){
		Calendar cl=Calendar.getInstance();
		
		cl.setTime(d1);
		int nType;
		
		switch(AddType){
			case 0:
				nType=Calendar.YEAR;
			break;
			case 1:
				nType=Calendar.MONTH;
			break;
			case 2:
				nType=Calendar.DAY_OF_MONTH;
			break;
			case 3:
				nType=Calendar.HOUR;
			break;
			case 4:
				nType=Calendar.MINUTE;
			break;
			case 5:
				nType=Calendar.SECOND;
			break;
			case 6:
				nType=Calendar.MILLISECOND;
			break;
			default:
				nType=Calendar.DATE;
		}
		cl.add(nType,val);
		return cl.getTime();
	}
	
	public static int myTS(String date1,String date2){
		int ts=0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		long to,from;
		try {
			to = df.parse(date2).getTime();
			from = df.parse(date1).getTime();
			ts=(int) ((to - from)/(1000 * 60 * 60 * 24));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return ts;
	}
}
