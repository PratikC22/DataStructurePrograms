package PalindromeChecker;

import java.util.NoSuchElementException;

public class Queue<T> {
	LinkedList<T> list = new LinkedList<T>();

	/**
	 * Add elements to the queue
	 */
	public void enqueue(T value) {
		list.add(value);
	}

	/**
	 * Pops an element from the stack represented by this list. In other words,
	 * removes and returns the first element of this list
	 */
	public Node<T> dequeue() {
		return list.remove();

	}

	/**
	 * It is looping through the nodes and printing their values till the last
	 * node's next element is null
	 */
	public void show() {
		list.show();
	}

	/**
	 * returns size of list
	 * 
	 * @return
	 */
	public int size() {
		return list.size();
	}

	/**
	 * Returns the element at the specified position in this list.
	 */
	public T get(int index) {
		return list.get(index);
	}
}
