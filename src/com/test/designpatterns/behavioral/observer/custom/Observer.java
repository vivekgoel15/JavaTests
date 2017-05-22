package com.test.designpatterns.behavioral.observer.custom;

public abstract class Observer {
	protected Subject subject;

	public abstract void update();
}
