package com.test.designpatterns.creational.builder;

/* "Product" */
class Pizza {
	private String dough = "";
	private String sauce = "";
	private String topping = "";

	public void setDough(String dough) {
		this.dough = dough;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public void serve() {
		System.out.println("Pizza {dough:" + dough + "},{sauce:" + sauce + "},{topping:" + topping + "}");
	}
}

/* "Abstract Builder" */
abstract class PizzaBuilder {
	protected Pizza pizza;

	public Pizza getPizza() {
		return pizza;
	}

	public PizzaBuilder createNewPizzaProduct() {
		pizza = new Pizza();
		return this;
	}

	public abstract PizzaBuilder buildDough();

	public abstract PizzaBuilder buildSauce();

	public abstract PizzaBuilder buildTopping();
}

/* "ConcreteBuilder" */
class HawaiianPizzaBuilder extends PizzaBuilder {
	public PizzaBuilder buildDough() {
		pizza.setDough("cross");
		return this;
	}

	public PizzaBuilder buildSauce() {
		pizza.setSauce("mild");
		return this;
	}

	public PizzaBuilder buildTopping() {
		pizza.setTopping("ham+pineapple");
		return this;
	}
}

/* "ConcreteBuilder" */
class SpicyPizzaBuilder extends PizzaBuilder {
	public PizzaBuilder buildDough() {
		pizza.setDough("pan baked");
		return this;
	}

	public PizzaBuilder buildSauce() {
		pizza.setSauce("hot");
		return this;
	}

	public PizzaBuilder buildTopping() {
		pizza.setTopping("pepperoni+salami");
		return this;
	}
}

/* "Director" */
class Waiter {
	private PizzaBuilder pizzaBuilder;

	public void setPizzaBuilder(PizzaBuilder pb) {
		pizzaBuilder = pb;
	}

	public Pizza getPizza() {
		return pizzaBuilder.getPizza();
	}

	public void constructPizza() {
		pizzaBuilder.createNewPizzaProduct().buildDough().buildSauce().buildTopping();
	}
}

/* A customer ordering a pizza. */
public class BuilderPatternDemo2 {
	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();

		waiter.setPizzaBuilder(hawaiianPizzabuilder);
		waiter.constructPizza();

		Pizza pizza = waiter.getPizza();
		pizza.serve();
	}
}