package BankingCashCounter;

import java.util.NoSuchElementException;

public class LinkedList<T> {
	Node<T> head;
	private int size = 0;

	/**
	 * Appends the specified element to the end of this list.
	 */
	public void add(T value) {
		Node<T> newNode = new Node<T>();
		newNode.value = value;
		newNode.next = null;
		if (head == null) {
			head = newNode;
			size++;
		} else {
			Node<T> currNode = head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newNode;
			size++;
		}
	}

	/**
	 * It is looping through the nodes and printing their values till the last
	 * node's next element is null
	 */
	public void show() {
		Node<T> currNode = head;
		while (currNode.next != null) {
			System.out.println(currNode.value);
			currNode = currNode.next;
		}
		System.out.println(currNode.value);
	}

	/**
	 * Inserts the specified element at the start of the list.
	 */
	public void addAtStart(T value) {
		Node<T> newNode = new Node<T>();
		newNode.value = value;
		newNode.next = head;
		head = newNode;
		size++;
	}

	/**
	 * Inserts the specified element at the specified position in this list
	 */
	public void addAtIndex(T value, int index) {
		if (index == 0) {
			addAtStart(value);
		} else {
			Node<T> newNode = new Node<T>();
			newNode.value = value;
			Node<T> nodeAtPreviousIndex = head;
			for (int i = 0; i < index - 1; i++) {
				nodeAtPreviousIndex = nodeAtPreviousIndex.next;
			}
			newNode.next = nodeAtPreviousIndex.next;
			nodeAtPreviousIndex.next = newNode;
			size++;
		}
	}

	/**
	 * Retrieves, but does not remove, the head (first element) of this list.
	 *
	 * @return the head of this list, or {@code null} if this list is empty
	 */
	public T peek() {
		final Node<T> f = head;
		return (f == null) ? null : f.value;
	}

	/**
	 * Removes the first element from this list, if it is present
	 */
	public Node<T> remove() {
		final Node<T> f = head;
		if (f == null)
			throw new NoSuchElementException();
		return unlinkFirst(f);

	}

	public Node<T> unlinkFirst(Node<T> f) {
		Node<T> removedItem = head;
		Node<T> newHead = head.next;
		head = newHead;
		size--;
		return removedItem;
	}

	/**
	 * Removes the last element from this list, if it is present
	 */
	public void removeLast() {
		Node<T> currNode = head;
		Node<T> prevNode = head;
		while (currNode.next != null) {
			prevNode = currNode;
			currNode = currNode.next;
		}
		prevNode.next = null;
		size--;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the lowest index {@code i} such that {@code Objects.equals(o, get(i))}, or -1
	 * if there is no such index.
	 */
	public <T extends Comparable<T>> int searchByValue(T value) {
		Node<T> currNode = (Node<T>) head;
		int index = 0;
		if (null != currNode) {
			while ((null != currNode.next) || (null != currNode.value)) {
				if (currNode.value.compareTo(value) == 0) {
					break;
				}
				currNode = currNode.next;
				if (null == currNode) {
					return -1;
				}
				index++;
			}
		}
		return index;
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public T get(int index) {
		if (head == null) {
			return null;
		}
		Node<T> currNode = head;
		int i = 0;
		if (null != currNode) {
			while ((null != currNode.next) || (null != currNode.value)) {
				if (i == index) {
					return currNode.value;
				}
				currNode = currNode.next;
				i++;
			}
		}
		return null;
	}

	/**
	 * Removes the element at the specified position in this list
	 */
	public void removeAtIndex(int index) {
		if (index == 0) {
			remove();
		} else {
			Node<T> prevNode = head;
			Node<T> currNode = head;
			for (int i = 0; i < index; i++) {
				prevNode = currNode;
				currNode = currNode.next;
			}
			prevNode.next = currNode.next;
			size--;
		}
	}

	/**
	 * Returns the number of elements in this list. If this list contains more than
	 * {@code Integer.MAX_VALUE} elements, returns {@code Integer.MAX_VALUE}.
	 */
	public int size() {
		Node<T> currNode = head;
		int count = 0;
		if (null != currNode) {
			while ((null != currNode.next) || (null != currNode.value)) {
				currNode = currNode.next;
				count++;
				if (null == currNode) {
					break;
				}
			}
		}
		count = (count > Integer.MAX_VALUE) ? Integer.MAX_VALUE : count;
		return count;
	}
}
