package com.test.designpatterns.behavioral.observer.custom2;

interface Subject {
	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObservers();
}
