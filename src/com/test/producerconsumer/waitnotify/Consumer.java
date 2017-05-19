package com.test.producerconsumer.waitnotify;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Consumer Thread will consume values form shared queue. It will also use
 * wait() method to wait if queue is empty. It will also use notify method to
 * send notification to producer thread after consuming values from queue.
 * 
 * @author vigoel
 *
 */
class Consumer implements Runnable {

	private final Vector sharedQueue;

	public Consumer(Vector sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (sharedQueue) {
					consume();
					sharedQueue.wait(100);
				}
			} catch (InterruptedException ex) {
				Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void consume() throws InterruptedException {
		// wait if queue is empty
		while (sharedQueue.isEmpty()) {
			System.out.println(
					"Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + sharedQueue.size());

			sharedQueue.wait();
		}

		// Otherwise consume element and notify waiting producer
		int consumed = (Integer) sharedQueue.remove(0);
		System.out.println("Consumed: " + consumed);
		sharedQueue.notifyAll();
	}
}
