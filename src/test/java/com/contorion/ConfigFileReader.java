package com.contorion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFileName = "config.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(getFileURI(propertyFileName)));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFileName);
		}
	}

	public String getFileURI(String fileName) {
		return getClass().getClassLoader().getResource(fileName).getFile();
	}

	public String getWebDriverName() {
		String webDriverName = properties.getProperty("driverName");
		if (webDriverName != null)
			return webDriverName;
		else
			throw new RuntimeException("webDriverName not specified in the config.properties file.");
	}

	public String getWebDriverLocation() {
		String webDriverLocation = properties.getProperty("webDriverLocation");
		if (webDriverLocation != null)
			return webDriverLocation;
		else
			throw new RuntimeException("webDriverLocation not specified in the config.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getEmail() {
		String email = properties.getProperty("email");
		if (email != null)
			return email;
		else
			throw new RuntimeException("email not specified in the Configuration.properties file.");
	}

	public String getPassword() {
		String password = properties.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("password not specified in the Configuration.properties file.");
	}

	public String getWelcomeText() {
		String welcomeText = properties.getProperty("welcomeText");
		if (welcomeText != null)
			return welcomeText;
		else
			throw new RuntimeException("welcomeText not specified in the Configuration.properties file.");
	}

}