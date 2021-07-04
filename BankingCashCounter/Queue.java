package BankingCashCounter;

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
	 *
	 * @return the element at the front of this list (which is the top of the stack
	 *         represented by this list)
	 * @throws NoSuchElementException if this list is empty
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
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public T get(int index) {
		return list.get(index);
	}
}
