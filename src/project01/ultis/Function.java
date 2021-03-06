package project01.ultis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Function {
	public static String generateUniqueFileName() {
	    String filename = "";
	    long millis = System.currentTimeMillis();
	    String datetime = new Date().toGMTString();
	    datetime = datetime.replace(" ", "");
	    datetime = datetime.replace(":", "");
	    filename = datetime + "_" + millis;
	    return filename;
	}
	public static Date StringtoDate(String date, String format) {
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	public static java.sql.Date convertDate(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}
	
}
