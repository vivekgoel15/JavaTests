package com.test.designpatterns.creational.prototype;

import java.util.Hashtable;

/**
 * This pattern is used when creation of object directly is costly. For example,
 * an object is to be created after a costly database operation. We can cache
 * the object, returns its clone on next request and update the database as and
 * when needed thus reducing database calls. e.g. when loading configuration
 * etc. from database.
 * 
 * @author vigoel
 *
 */
public class PrototypePatternDemo {

	public static void main(String[] args) {
		ConfigurationCache.init();

		Configuration userConfig = (Configuration) ConfigurationCache.getShape("userConfiguration");
		System.out.println("User Config : " + userConfig.getProperties());

		Configuration companyConfig = (Configuration) ConfigurationCache.getShape("companyConfiguration");
		System.out.println("Company Config : " + companyConfig.getProperties());

		// If we make multiple calls in application to find the configurations
		// then same configuration will be cloned and loaded from cache to avoid
		// costly object creation process

		Configuration userConfig2 = (Configuration) ConfigurationCache.getShape("userConfiguration");
		System.out.println("User Config : " + userConfig2.getProperties());
	}
}

class Configuration implements Cloneable {
	String properties;

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public Object clone() {

		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
	}
}

class UserConfiguration extends Configuration {
	public UserConfiguration() {
		// load configurations from DB
		System.out.println("*** Loading user default configurations from DB ***");
		properties = "user default configurations";
	}
}

class CompanyConfiguration extends Configuration {
	public CompanyConfiguration() {
		// load configurations from DB
		System.out.println("*** Loading company default configurations from DB ***");
		properties = "company default configurations";
	}
}

class ConfigurationCache {

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
