package com.test.designpatterns.creational.prototype;

import java.util.Hashtable;

public class ConfigurationCache {

	private static Hashtable<String, Configuration> configs = new Hashtable<String, Configuration>();

	public static Configuration getShape(String configName) {
		Configuration cachedShape = configs.get(configName);
		return (Configuration) cachedShape.clone();
	}

	// instead of creating init() method, we can use static block also to
	// initialize the configurations if we want eager initialization
	public static void init() {
		System.out.println("Initializing configurations...");
		Configuration config1 = new UserConfiguration();
		configs.put("userConfiguration", config1);

		Configuration config2 = new CompanyConfiguration();
		configs.put("companyConfiguration", config2);
		System.out.println("Initialization completed!");
	}
}
