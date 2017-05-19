package com.test.producerconsumer.waitnotify;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Producer Thread will keep producing values for Consumer to consume. It will
 * use wait() method when Queue is full and use notify() method to send
 * notification to Consumer Thread.
 * 
 * @author vigoel
 *
 */
class Producer implements Runnable {

	private final Vector sharedQueue;
	private final int MAX_QUEUE_SIZE = 10;
	private final int numberOFElements;

	public Producer(Vector sharedQueue, int numberOFElements) {
		this.sharedQueue = sharedQueue;
		this.numberOFElements = numberOFElements;
	}

	@Override
	public void run() {
		for (int i = 1; i <= numberOFElements; i++) {
			try {
				synchronized (sharedQueue) {
					produce(i);
				}
			} catch (InterruptedException ex) {
				Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void produce(int i) throws InterruptedException {

		// wait if queue is full
		while (sharedQueue.size() == MAX_QUEUE_SIZE) {
			System.out.println(
					"Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + sharedQueue.size());
			sharedQueue.wait();
		}

		// producing element and notify consumers
		sharedQueue.add(i);
		System.out.println("Produced: " + i);
		sharedQueue.notifyAll();
	}
}
