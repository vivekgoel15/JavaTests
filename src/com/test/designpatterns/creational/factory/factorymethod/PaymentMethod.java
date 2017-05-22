package com.test.designpatterns.creational.factory.factorymethod;

public interface PaymentMethod {
	public void makePayment();
}

class CreditCard implements PaymentMethod {
	public void makePayment() {
		System.out.println("Payment through credit card...");
	}
}

class NetBanking implements PaymentMethod {
	public void makePayment() {
		System.out.println("Payment through net banking...");
	}
}
