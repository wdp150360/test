package org.zimincredit.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {
	
	public String getTimeStamp(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = sdf.format(date);
		return str;
	}
}
