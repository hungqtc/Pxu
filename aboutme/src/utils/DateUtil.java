package utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.Experience;

public class DateUtil {
	// Function to convert java.util Date to java.sql Date in Java
		public static java.sql.Date convert(java.util.Date date)
		{
			return new java.sql.Date(date.getTime());
		}

		public static String convert2(java.util.Date date)
		{	
			
			return new SimpleDateFormat("dd-MM-yyyy").format(date);
		}
		
		public static String[] splitString(Experience objEx) {
			
			String[] splitString = (DateUtil.convert2(objEx.getTime())).split("-");
			
			return  splitString;
		}
		
}
