package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties readProperties() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Properties properites = new Properties();
		try {
			properites.load(classLoader.getResourceAsStream("/config/database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properites;
	}
		
}
