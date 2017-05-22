package com.test.designpatterns.behavioral.observer.javautil;

import java.util.Observable;
import java.util.Observer;

class Student implements Observer {
	public void update(Observable o, Object arg) {
		System.out.println("Message board changed: " + arg);
	}
}