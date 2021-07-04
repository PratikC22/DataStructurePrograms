/**************************************************************************************
 * purpose : Read a List of Numbers from a file and arrange it ascending Order
 * in a Linked List. Take user input for a number, if found then pop the number
 * out of the list else insert the number in appropriate position b. I/P -> Read
 * from file the list of Numbers and take user input for a new number c. Logic
 * -> Create a Ordered Linked List having Numbers in ascending order. d. O/P ->
 * The List of Numbers to a File.
 *
 * @author Pratik Chaudhari
 * @since 01/07/2021
 ***************************************************************************************/
package OrderedList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderedListMain {
	private static SortedLinkedList<Integer> slist = new SortedLinkedList<Integer>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		readFile();
		System.out.println("Enter a number from the list to search");
		int searchNumber = sc.nextInt();
		int searchResult = slist.searchByValue(searchNumber);
		if (searchResult == -1) {
			slist.add(searchNumber);
			slist.show();
		} else {
			slist.removeAtIndex(searchResult);
			slist.show();
		}
		writeFile();
	}

	/**
	 * This method writes an output file
	 *
	 * @throws IOException
	 */
	private static void writeFile() throws IOException {
		String str = "";
		for (int i = 0; i < slist.size(); i++) {
			str = str.concat(String.valueOf(slist.get(i))).concat(",");
		}
		FileWriter fw = new FileWriter("D:\\InputOutputFiles\\outputNumber.txt");
		for (int i = 0; i < str.length(); i++) {
			fw.write(str.charAt(i));
		}
		System.out.println("Writing successful");
		fw.close();
	}

	/**
	 * This method reads an input file
	 *
	 * @throws IOException
	 */
	private static void readFile() throws IOException {
		int ch;
		FileReader fr = null;
		String lines = "";
		try {
			fr = new FileReader("D:\\InputOutputFiles\\inputNumber.txt");
		} catch (FileNotFoundException fe) {
			System.out.println("File not found");
		}
		// read from FileReader till the end of file
		while ((ch = fr.read()) != -1) {
			System.out.print((char) ch);
			lines = lines.concat(String.valueOf((char) ch));
		}
		System.out.println();
		fr.close();
		String[] wordArray = lines.split(",");
		for (String word : wordArray) {
			slist.add(Integer.valueOf(word));
		}
		slist.show();
	}
}
