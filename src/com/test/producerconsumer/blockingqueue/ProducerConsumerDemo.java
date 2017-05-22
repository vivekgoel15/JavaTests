package com.test.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Using Blocking Queue to implement Producer Consumer Pattern
 * Read more: http://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html#ixzz4hOwpnNdT
 * @author vigoel
 *
 */
public class ProducerConsumerDemo {

	private static final int MAX_QUEUE_SIZE = 10;
	
    public static void main(String args[]){
  
     //Creating shared object
     BlockingQueue sharedQueue = new LinkedBlockingQueue(MAX_QUEUE_SIZE);
     int numberOfElements = 50;

     //Creating Producer and Consumer Thread
     Thread prodThread = new Thread(new Producer(sharedQueue, numberOfElements));
     Thread consThread = new Thread(new Consumer(sharedQueue));

     //Starting producer and Consumer thread
     prodThread.start();
     consThread.start();
    }
 
}


