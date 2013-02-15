package utils

import java.text.SimpleDateFormat

class FormatUtils {

	private static String DATE_TO_STRING_PRESENTATION = "dd-MM-yyyy HH:mm:ss";
	private static SimpleDateFormat dateTime = new SimpleDateFormat(DATE_TO_STRING_PRESENTATION);
	
	static String dateTime(Date date){
		dateTime.format(date)
	} 
}
