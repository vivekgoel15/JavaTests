package com.test.designpatterns.structural.decorator;

/**
 * Decorator design pattern allows behavior to be added to an individual object,
 * either statically or dynamically, without affecting the behavior of other
 * objects from the same class.
 * 
 * The decorator pattern is often useful for adhering to the Single
 * Responsibility Principle, as it allows functionality to be divided between
 * classes with unique areas of concern. e.g. if we do not want to modify the
 * domain object for a specific case, then we can create wrapper class
 * 
 * e.g. Decorator pattern is used a lot in Java I/O classes, such as
 * FileInputStream, BufferedInputStream etc.
 * 
 * Another example is Collections.unmodifiableXXX()
 * 
 * @author vigoel
 *
 */
public class DecoratorPatternDemo {

	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");

		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}

}

interface Car {

	public void assemble();
}

class BasicCar implements Car {

	@Override
	public void assemble() {
		System.out.print("Basic Car.");
	}

}

class CarDecorator implements Car {

	protected Car car;

	public CarDecorator(Car c) {
		this.car = c;
	}

	@Override
	public void assemble() {
		this.car.assemble();
	}

}

class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.print(" Adding features of Sports Car.");
	}
}

class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.print(" Adding features of Luxury Car.");
	}
}