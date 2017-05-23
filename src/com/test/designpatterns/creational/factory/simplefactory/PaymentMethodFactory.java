package com.test.designpatterns.creational.factory.simplefactory;

class PaymentMethodFactory {
	public static PaymentMethod getPaymentMethod(String method) {
		if ("creditcard".equalsIgnoreCase(method)) {
			return new CreditCard();
		} else if ("netbanking".equalsIgnoreCase(method)) {
			return new NetBanking();
		} else {
			throw new IllegalArgumentException("Payment method not supported!");
		}
	}
}