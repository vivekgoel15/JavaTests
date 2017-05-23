package com.test.designpatterns.creational.builder;

import com.test.designpatterns.creational.builder.User.UserBuilder;

/**
 * Builder pattern builds a complex object using simple objects and using a step
 * by step approach. This pattern can be used e.g. to reduce the number of
 * parameters required for a constructor.
 * 
 * @author vigoel
 *
 */
public class BuilderPatternDemo1 {

	public static void main(String[] args) {
		UserBuilder userBuilder = new UserBuilder("first", "last");
		User user = userBuilder.salutation("Mr.").streetAddress("IT Park").city("Chandigarh").country("India")
				.zip("160101").createUser();
	}
}

class User {

	private final String lastName;
	private final String firstName;
	private final String salutation;
	private final String streetAddress;
	private final String city;
	private final String state;
	private final String country;
	private final String zip;

	public User(final String newLastName, final String newFirstName, final String newSalutation,
			final String newStreetAddress, final String newCity, final String newState, final String newCountry,
			final String newZip) {
		this.lastName = newLastName;
		this.firstName = newFirstName;
		this.salutation = newSalutation;
		this.streetAddress = newStreetAddress;
		this.city = newCity;
		this.state = newState;
		this.country = newCountry;
		this.zip = newZip;
	}

	public static class UserBuilder {
		private String nestedLastName;
		private String nestedFirstName;
		private String nestedSalutation;
		private String nestedStreetAddress;
		private String nestedCity;
		private String nestedState;
		private String nestedCountry;
		private String nestedZip;

		public UserBuilder(final String firstName, final String lastName) {
			this.nestedFirstName = firstName;
			this.nestedLastName = lastName;
		}

		public UserBuilder lastName(String newLastName) {
			this.nestedLastName = newLastName;
			return this;
		}

		public UserBuilder firstName(String newFirstName) {
			this.nestedFirstName = newFirstName;
			return this;
		}

		public UserBuilder salutation(String newSalutation) {
			this.nestedSalutation = newSalutation;
			return this;
		}

		public UserBuilder streetAddress(String newStreetAddress) {
			this.nestedStreetAddress = newStreetAddress;
			return this;
		}

		public UserBuilder city(String newCity) {
			this.nestedCity = newCity;
			return this;
		}

		public UserBuilder state(String newState) {
			this.nestedState = newState;
			return this;
		}

		public UserBuilder country(String newCountry) {
			this.nestedCountry = newCountry;
			return this;
		}

		public UserBuilder zip(String newZip) {
			this.nestedZip = newZip;
			return this;
		}

		public User createUser() {
			return new User(nestedLastName, nestedFirstName, nestedSalutation, nestedStreetAddress, nestedCity,
					nestedState, nestedCountry, nestedZip);
		}
	}
}