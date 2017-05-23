package com.test.designpatterns.structural.facade;

/**
 * The Facade pattern is typically used when a simple interface is required to
 * access a complex system.
 * 
 * This pattern involves a single class which provides simplified methods
 * required by client and delegates calls to methods of existing system classes.
 * 
 * @author vigoel
 *
 */
public class FacadePatternDemo {
	public static void main(String args[]) {
		OrderFacade orderFacade = new OrderFacade();
		orderFacade.placeOrder("OR123456");
		System.out.println("Order processing completed");
	}
}

class InventoryApi {
	public String checkInventory(String OrderId) {
		return "Inventory checked";
	}

	public String updateInventory(String OrderId) {
		return "Inventory updated";
	}
}

class PaymentApi {
	public String deductPayment(String orderID) {
		return "Payment deducted successfully";
	}
}

class EmailApi {
	public String sendEmail() {
		return "Email sent to client";
	}
}

class OrderFacade {
	private InventoryApi inventry = new InventoryApi();
	private PaymentApi pymt = new PaymentApi();
	private EmailApi email = new EmailApi();

	public void placeOrder(String orderId) {
		String step1 = inventry.checkInventory(orderId);
		String step2 = inventry.updateInventory(orderId);
		String step3 = pymt.deductPayment(orderId);
		String step4 = email.sendEmail();
		System.out.println("Following steps completed:" + step1 + " & " + step2 + " & " + step3 + " & " + step4);
	}
}
