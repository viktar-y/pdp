package properties;

public class Properties {
	public static int DEFAULT_TIMEOUT = Integer.parseInt(PropertyReader.findProperty("DEFAULT_TIMEOUT"));
	public static String BASE_URL = PropertyReader.findProperty("BASE_URL");
	public static String CORRECT_LOGIN = PropertyReader.findProperty("CORRECT_LOGIN");
	public static String CORRECT_PASSWORD = PropertyReader.findProperty("CORRECT_PASSWORD");
	public static String AVG_TEMP_FILE_PATH = PropertyReader.findProperty("AVG_TEMP_FILE_PATH");
	public static String CURRENT_TEMP_FILE_PATH = PropertyReader.findProperty("CURRENT_TEMP_FILE_PATH");
	public static String ITEM = PropertyReader.findProperty("ITEM");
	public static String CITY = PropertyReader.findProperty("CITY");
	public static String PRICE_FROM = PropertyReader.findProperty("PRICE_FROM");
	public static String PRICE_TO = PropertyReader.findProperty("PRICE_TO");

}
