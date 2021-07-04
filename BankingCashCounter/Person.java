package BankingCashCounter;

public class Person {
	private double amount;
	private Action action;

	public Person(double amount, Action action) {
		this.amount = amount;
		this.action = action;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Person [amount=" + amount + ", action=" + action + "]";
	}
}
