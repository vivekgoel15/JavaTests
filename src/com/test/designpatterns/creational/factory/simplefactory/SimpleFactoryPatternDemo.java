package com.test.designpatterns.creational.factory.simplefactory;

/**
 * Creates objects without exposing the instantiation logic to the client.
 * Refers to the newly created object through a common interface
 * 
 * e.g. FileParser as a super class of CSVParser and ExcelParser
 * 
 * @author vigoel
 *
 */
public class SimpleFactoryPatternDemo {

	public static void main(String[] args) {
		PaymentMethodFactory factory = new PaymentMethodFactory();
		PaymentMethod paymentMethod = factory.getPaymentMethod("creditcard");
		paymentMethod.makePayment();
	}

}
