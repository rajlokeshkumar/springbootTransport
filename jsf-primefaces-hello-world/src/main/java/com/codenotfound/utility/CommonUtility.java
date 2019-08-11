package com.codenotfound.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtility {

public static Date DateFormatConverted(Date pInputDate) throws ParseException {

	   SimpleDateFormat sm = new SimpleDateFormat("dd-MMM-yyyy");
	    // myDate is the java.util.Date in yyyy-mm-dd format
	    // Converting it into String using formatter
	    String strDate = sm.format(pInputDate);
	    //Converting the String back to java.util.Date
	    Date dt = sm.parse(strDate);
		return dt;
	    
}

	
}
