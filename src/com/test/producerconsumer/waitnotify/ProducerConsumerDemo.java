package com.test.producerconsumer.waitnotify;

import java.util.Vector;

/**
 * How to solve producer consumer problem in Java using wait and notify method.
 * Read more:
 * http://www.java67.com/2012/12/producer-consumer-problem-with-wait-and-notify-example.html#ixzz4hOtS5yJ0
 * 
 * @author vigoel
 *
 */
public class ProducerConsumerDemo {

	public static void main(String args[]) {
		Vector sharedQueue = new Vector();
		int numberOfElements = 50;
		Thread prodThread = new Thread(new Producer(sharedQueue, numberOfElements), "Producer");
		Thread consThread = new Thread(new Consumer(sharedQueue), "Consumer");
		prodThread.start();
		consThread.start();
	}
}
