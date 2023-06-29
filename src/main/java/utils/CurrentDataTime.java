package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDataTime {
	public static String getCurrentDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date now = new Date();
		return dateFormat.format(now);
	}
}
