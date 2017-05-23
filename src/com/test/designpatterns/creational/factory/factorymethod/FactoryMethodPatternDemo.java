package com.test.designpatterns.creational.factory.factorymethod;

/**
 * Defines an interface for creating objects, but let subclasses to decide which
 * class to instantiate. Refers the newly created object through a common
 * interface.
 * 
 * @author vigoel
 *
 */
public class FactoryMethodPatternDemo {

	public static void main(String[] args) {
		IPaymentMethodFactory factory = new CreditCardFactory();
		PaymentMethod paymentMethod = factory.getPaymentMethod();
		paymentMethod.makePayment();
	}
}
