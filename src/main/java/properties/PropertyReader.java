package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class PropertyReader {
	private static final String PROPERTIES_PATH = "src/main/resources/config.properties";
	private final static java.util.Properties properties;

	static {
		properties = getProperties();
	}

	private static java.util.Properties getProperties() {
		Properties properties = new Properties();
		try (FileInputStream fis = new FileInputStream(PROPERTIES_PATH)) {
			properties.load(fis);
		} catch (IOException e) {
			System.out.println("Property file doesn't exist. Probably run started from CI");
		}
		return properties;
	}

	public static String findProperty(String... keys) {
		for (String key : keys) {
			String envVariable = System.getenv(key);
			String property = properties.getProperty(key);
			if (envVariable != null) return envVariable;
			if (property != null) return property;
		}
		System.out.println("Cannot find variable in range: " + Arrays.toString(keys));
		return "";
	}

}
