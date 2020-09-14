package com.benz.here.search.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigUtility {

	
	@Autowired
	private Environment env;

	public String getEvnProperty(String key) {
		return env.getProperty(key);
	}
}
