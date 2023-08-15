package utils;

import static properties.Properties.PRICE_FROM;
import static properties.Properties.PRICE_TO;

public class StringUtils {
	public static String getPriceRangeInString() {
		return PRICE_FROM + PRICE_TO;
	}
}
