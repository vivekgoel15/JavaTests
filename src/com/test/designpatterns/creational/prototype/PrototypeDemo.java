package com.test.designpatterns.creational.prototype;

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
public class PrototypeDemo {

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
