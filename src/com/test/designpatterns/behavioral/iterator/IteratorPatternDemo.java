package com.test.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator pattern provides a way to access the elements of an aggregate object
 * without exposing its underlying representation.
 * 
 * An iterator is used to traverse a container and access the container's
 * elements. The iterator pattern decouples algorithms from containers.
 * 
 * e.g. java.util.Iterator, java.util.Enumeration
 * 
 * @author vigoel
 *
 */
public class IteratorPatternDemo {

	public static void main(String[] args) {
		Item i1 = new Item("spaghetti", 7.50f);
		Item i2 = new Item("hamburger", 6.00f);
		Item i3 = new Item("chicken sandwich", 6.50f);

		Menu menu = new Menu();
		menu.addItem(i1);
		menu.addItem(i2);
		menu.addItem(i3);

		System.out.println("Displaying Menu:");
		Iterator<Item> iterator = menu.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			System.out.println(item);
		}

		System.out.println("\nRemoving last item returned");
		iterator.remove();

		System.out.println("\nDisplaying Menu:");
		iterator = menu.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			System.out.println(item);
		}
	}
}

// POJO class
class Item {

	String name;
	float price;

	public Item(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String toString() {
		return name + ": $" + price;
	}
}

// Container class
class Menu {

	List<Item> menuItems;

	public Menu() {
		menuItems = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		menuItems.add(item);
	}

	public Iterator<Item> iterator() {
		return new MenuIterator();
	}

	class MenuIterator implements Iterator<Item> {
		int currentIndex = 0;

		@Override
		public boolean hasNext() {
			if (currentIndex >= menuItems.size()) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Item next() {
			return menuItems.get(currentIndex++);
		}

		@Override
		public void remove() {
			menuItems.remove(--currentIndex);
		}

	}

}