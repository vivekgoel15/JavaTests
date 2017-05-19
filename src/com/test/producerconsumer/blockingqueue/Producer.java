package com.test.producerconsumer.blockingqueue;

import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

class Producer implements Runnable {

    private final BlockingQueue sharedQueue;
    private final int numberOFElements;

    public Producer(BlockingQueue sharedQueue, int numberOFElements) {
        this.sharedQueue = sharedQueue;
        this.numberOFElements = numberOFElements;
    }

    @Override
    public void run() {
        for(int i=1; i<=numberOFElements; i++){
            try {
            	System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
