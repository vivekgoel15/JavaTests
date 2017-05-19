package com.test.designpatterns.observer.javautil;

import java.util.Observable;
import java.util.Observer;

public class ObserverPatternJavaTest extends Observable {

	public static void main(String[] args) {
		MessageBoard board = new MessageBoard();
		Student bob = new Student();
		Student joe = new Student();
		board.addObserver(bob);
		board.addObserver(joe);
		board.changeMessage("More Homework!");
	}
}
