package com.test.designpatterns.behavioral.state;

/**
 * State design pattern is used when an Object change it’s behavior based on
 * it’s internal state. Context is the class that has a State reference to one
 * of the concrete implementations of the State and forwards the request to the
 * state object for processing.
 * 
 * e.g. Traffic Light System. {States: RED, YELLOW, GREEN.} {Transitions: After
 * a timer change RED to GREEN, GREEN to YELLOW, and YELLOW to RED.}
 * 
 * @author vigoel
 *
 */
public class StatePatternDemo {

	public static void main(String[] args) {
		TrafficLightContext context = new TrafficLightContext();
		ITrafficLight initialState = new GreenLight();
		context.setState(initialState);
		context.getState().reportState();
		while (true) {
			try {
				context.next();
			} catch (InterruptedException e) {
				System.out.println("Error occurred in lighting system.");
			}
		}
	}
}

interface ITrafficLight {
	public ITrafficLight change() throws InterruptedException;

	public void reportState();
}

class GreenLight implements ITrafficLight {
	public ITrafficLight change() throws InterruptedException {
		Thread.sleep(5000);
		return new YellowLight();
	}

	public void reportState() {
		System.out.println("GREEN LIGHT");
	}
}

class YellowLight implements ITrafficLight {
	public ITrafficLight change() throws InterruptedException {
		Thread.sleep(1000);
		return new RedLight();
	}

	public void reportState() {
		System.out.println("YELLOW LIGHT");
	}
}

class RedLight implements ITrafficLight {
	public ITrafficLight change() throws InterruptedException {
		Thread.sleep(5000);
		return new GreenLight();
	}

	public void reportState() {
		System.out.println("RED LIGHT");
	}
}

class TrafficLightContext {

	private ITrafficLight trafficState;

	public void setState(ITrafficLight state) {
		this.trafficState = state;
	}

	public ITrafficLight getState() {
		return this.trafficState;
	}

	public void next() throws InterruptedException {
		this.trafficState = this.trafficState.change();
		this.trafficState.reportState();
	}
}
