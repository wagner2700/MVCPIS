package br.com.fiap.patterns.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigSingleton {
	
	private static Properties prop;
	
	private ConfigSingleton() {
		// TODO Auto-generated constructor stub
	 
		
	}
	
	public static Properties getInstance()  {
		if(prop == null) {
			prop = new Properties();
			try {
				prop.load(ConfigSingleton.class.getResourceAsStream("/config.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return prop;
	}

}
