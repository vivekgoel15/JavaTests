package com.test.designpatterns.creational.prototype;

public class Configuration implements Cloneable {
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