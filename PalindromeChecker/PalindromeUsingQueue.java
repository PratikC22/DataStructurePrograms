/**
 * Purpose:A palindrome is a string that reads the same forward and backward, 
 * for example, radar, toot, and madam. We would like to construct an algorithm to input
 * a string of characters and check whether it is a palindrome. 

 * @author Pratik Chaudhari
 * @version 1.0
 * @since 01/07/2021
 * 
 */
package PalindromeChecker;

public class PalindromeUsingQueue {
	private Queue<String> personQueue;

	public PalindromeUsingQueue() {
		this.personQueue = new Queue<String>();
	}

	public static void main(String[] args) {
		PalindromeUsingQueue p = new PalindromeUsingQueue();
		String str = "radar";
		String str1 = "radio";
		p.isPalindrome(str);
		p.isPalindrome(str1);
	}

	/**
	 * To check if the string is palindrome
	 */
	private void isPalindrome(String str) {
		String revStr = "";
		String[] arr = str.split("");
		for (int i = arr.length - 1; i >= 0; i--) {
			personQueue.enqueue(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			revStr = revStr.concat(personQueue.dequeue().value);
		}
		if (str.equals(revStr)) {
			System.out.println("String " + str + " is palindrome");
		} else {
			System.out.println("String " + str + " is not palindrome");
		}
	}
}
