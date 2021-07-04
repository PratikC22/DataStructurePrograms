/**
 * Purpose:a. Desc -> Create a Program which creates Banking Cash Counter where people come in to 
 * deposit Cash and withdraw Cash. Have an input panel to add people to Queue to either deposit 
 * or withdraw money and dequeue the people. Maintain the Cash Balance.
 * b. I/P -> Panel to add People to Queue to Deposit or Withdraw Money and dequeue c. Logic ->
 * Write a Queue Class to enqueue and dequeue people to either deposit or withdraw money and
 * maintain the cash balance 

 * @author Pratik Chaudhari
 * @since 01/07/2021
 */
package BankingCashCounter;

public class BankingCashCounter {
	private double totalCash = 0;

	public BankingCashCounter(double totalCash) {
		this.totalCash = totalCash;
	}

	public static void main(String[] args) {
		BankingCashCounter bcc = new BankingCashCounter(0);
		Queue<Person> personQueue = new Queue<Person>();
		bcc.createPersonAndEnqueue(personQueue);
		bcc.depositOrWithdraw(personQueue);
		bcc.dequeuePerson(personQueue);
		System.out.println("Total cash after all transactions: " + bcc.totalCash);
	}

	/**
	 * This method dequeues person
	 * 
	 * @param personQueue
	 */
	private void dequeuePerson(Queue<Person> personQueue) {
		System.out.println();
		final int queueSize = personQueue.size();
		for (int i = 0; i < queueSize - 1; i++) {
			Node<Person> poppedPerson = personQueue.dequeue();
			System.out.println("Person dequeued is " + poppedPerson.value);
		}
		System.out.println();
	}

	/**
	 * This creates a person and enqueues them to queue
	 * 
	 * @param personQueue
	 */
	private void createPersonAndEnqueue(Queue<Person> personQueue) {
		Person person1 = new Person(100, Action.DEPOSIT);
		Person person2 = new Person(50, Action.DEPOSIT);
		Person person3 = new Person(900, Action.DEPOSIT);
		Person person4 = new Person(170, Action.WITHDRAW);
		Person person5 = new Person(10, Action.WITHDRAW);
		Person person6 = new Person(140, Action.WITHDRAW);
		Person person7 = new Person(600, Action.DEPOSIT);
		personQueue.enqueue(person7);
		personQueue.enqueue(person6);
		personQueue.enqueue(person5);
		personQueue.enqueue(person4);
		personQueue.enqueue(person3);
		personQueue.enqueue(person2);
		personQueue.enqueue(person1);
		personQueue.show();
	}

	private void depositOrWithdraw(Queue<Person> personQueue) {
		for (int i = 0; i < personQueue.size(); i++) {
			switch (personQueue.get(i).getAction()) {
			case WITHDRAW:
				totalCash = totalCash - personQueue.get(i).getAmount();
				break;
			case DEPOSIT:
				totalCash = totalCash + personQueue.get(i).getAmount();
				break;
			default:
				break;
			}
		}
	}
}
