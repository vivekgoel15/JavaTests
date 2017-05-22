package com.test.designpatterns.behavioral.observer.javautil;

import java.util.Observable;
import java.util.Observer;

public class ObserverPatternDemo extends Observable {

	public static void main(String[] args) {
		MessageBoard board = new MessageBoard();
		Student bob = new Student();
		Student joe = new Student();
		board.addObserver(bob);
		board.addObserver(joe);
		board.changeMessage("More Homework!");
	}
}
