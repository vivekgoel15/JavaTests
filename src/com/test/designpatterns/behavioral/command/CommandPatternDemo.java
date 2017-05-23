package com.test.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Command pattern is a behavioral design pattern in which an object is used to
 * encapsulate all information needed to perform an action or trigger an event
 * at a later time.
 * 
 * A request is wrapped under an object as command and passed to invoker object.
 * Invoker object looks for the appropriate object which can handle this command
 * and passes the command to the corresponding object which executes the
 * command.
 * 
 * It allows saving the requests in a queue.
 * 
 * e.g. Runnable interface
 * 
 * @author vigoel
 *
 */
public class CommandPatternDemo {

	public static void main(String[] args) {
		Stock abcStock = new Stock();

		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStockOrder = new SellStock(abcStock);

		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);

		broker.placeOrders();
	}
}

// Invoker class
class Broker {
	private List<Order> orderList = new ArrayList<Order>();

	public void takeOrder(Order order) {
		orderList.add(order);
	}

	public void placeOrders() {

		for (Order order : orderList) {
			order.execute();
		}
		orderList.clear();
	}
}

// Command interface
interface Order {
	public void execute();
}

// ConcreteCommand Class.
class BuyStock implements Order {
	private Stock stock;

	public BuyStock(Stock st) {
		stock = st;
	}

	public void execute() {
		stock.buy();
	}
}

// ConcreteCommand Class.
class SellStock implements Order {
	private Stock stock;

	public SellStock(Stock st) {
		stock = st;
	}

	public void execute() {
		stock.sell();
	}
}

// Request class
class Stock {

	private String name = "ABC";
	private int quantity = 10;

	public void buy() {
		System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
	}

	public void sell() {
		System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
	}
}
