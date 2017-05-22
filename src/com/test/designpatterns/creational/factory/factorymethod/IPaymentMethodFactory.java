package com.test.designpatterns.creational.factory.factorymethod;

public interface IPaymentMethodFactory {
	public PaymentMethod getPaymentMethod();
}

class CreditCardFactory implements IPaymentMethodFactory {
	public PaymentMethod getPaymentMethod() {
		return new CreditCard();
	}
}

class NetBankingFactory implements IPaymentMethodFactory {
	public PaymentMethod getPaymentMethod() {
		return new NetBanking();
	}
}