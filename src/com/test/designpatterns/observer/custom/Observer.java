package com.test.designpatterns.observer.custom;

public abstract class Observer {
	protected Subject subject;

	public abstract void update();
}
