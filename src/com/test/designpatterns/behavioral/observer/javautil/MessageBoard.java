package com.test.designpatterns.behavioral.observer.javautil;

import java.util.Observable;

public class MessageBoard extends Observable {
	private String message;

	public String getMessage() {
		return message;
	}

	public void changeMessage(String message) {
		this.message = message;
		setChanged();
		notifyObservers(message);
	}
}
