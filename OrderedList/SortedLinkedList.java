package OrderedList;

import java.util.NoSuchElementException;

public class SortedLinkedList<T extends Comparable<T>> {
	Node<T> head;
	private int size;
	
	/**
	 * returns the size of list
	 */
	public int size() {
		return size;
	}

	/**
	 * If Linked list is empty then make the node as head and return it. If the
	 * value of the node to be inserted is smaller than the value of the head node,
	 * then insert the node at the start and make it head. In a loop, find the
	 * appropriate node after which the input node (let 9) is to be inserted. To
	 * find the appropriate node start from the head, keep moving until you reach a
	 * node GN (10 in the below diagram) who's value is greater than the input node.
	 * The node just before GN is the appropriate node (7).
	 */
	public void add(T value) {
		Node<T> newNode = new Node<T>();
		newNode.value = value;
		newNode.next = null;
		if (head == null) {
			head = newNode;
			size++;
		} else {
			if (value.compareTo(head.value) < 0) {
				newNode.next = head;
				head = newNode;
				size++;
				return;
			}
			Node<T> currNode = head;
			Node<T> prevNode = head;
			if (null != currNode) {
				while ((null != currNode.next) || (null != currNode.value)) {
					if (value.compareTo(currNode.value) <= 0) {
						prevNode.next = newNode;
						newNode.next = currNode;
						break;
					}
					prevNode = currNode;
					currNode = currNode.next;
					if (currNode == null) {
						break;
					}
				}
			}
			prevNode.next = newNode;
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
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the lowest index {@code i} such that {@code Objects.equals(o, get(i))}, or -1
	 * if there is no such index.
	 */
	public int searchByValue(T value) {
		Node<T> currNode = head;
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
}
