package org.zimincredit.utils;

import java.io.IOException;
import java.util.Properties;

public class UserInfoPropertiesFileLoad {
	
	public String getValue(String username) throws IOException{
		String value = null;
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/data/data_name_password.properties"));
		value = properties.getProperty(username);
		return value;
	}
	
}