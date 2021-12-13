package td11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TD11 {

	public static void main(String[] args) throws IOException {
		exercise1();
		exercise2();
		exercise3();
	}
	
	/**
	 * Write the function greaterThan which, given an array of integers representing a binary tree of
	 * search, returns the largest value in the array. It is not necessary to seek linearly in the
	 * chart as usual, but follow the branches of the tree. The biggest element is indeed the
	 * rightmost leaf in the tree.
	 */
	public static void exercise1() {
		int[] binaryTree = {0, 4, 2, 7, -1, -1, 5, 13, -1, -1, -1, -1, 6, -1, -1, -1, -1};
		
		System.out.println("Biggest Value of the tree is " + greaterThan(binaryTree));
	}
	
	/**
	 * returns the largest value in the array
	 * @param binary tree 
	 * @return largest value
	 */
	static int greaterThan(int[] tree) {
		// Step 1: We start from the root
		int currentNode = 1;
		
		// Step 2: We loop until we get the greater leftmost value possible. If we encounter -1, it means that we can stop and return the result
		while(tree[currentNode * 2 + 1] != -1) {
			currentNode = currentNode * 2 + 1;
		}
		
		// Step 3: Return the greater value found
		return tree[currentNode];
	}

	/**
	 * A- Write the AllIdentical boolean function which, given a
	 * string, returns true if all characters are equal and
	 * false otherwise. For example, identical ("2222") returns true but
	 * identical ("bbbabb") returns false. If the string is empty, the
	 * function returns false.
	 * B- Write a program that uses the previous function to determine the number of lines in the
	 * myFile.txt file which contain all identical characters. For example, with the file opposite,
	 * the program should display:
	 * "The file contains 3 lines with all identical characters"
	 * C- Same thing but the program also displays the last line whose characters are all
	 * identical:
	 * "The file contains 3 lines with all identical characters and the last one is: aaaaa"
	 * @throws IOException 
	 */
	public static void exercise2() throws IOException {
		// Part A
		String a = "2222";
		String b = "bbbabb";
		System.out.println(a + " All identical ? " + allIdentical(a));
		System.out.println(b + " All identical ? " + allIdentical(b));
		
		// Part B and C
		BufferedReader f  = new BufferedReader(new FileReader("file.txt"));
		String line = f.readLine();
		String lastIdenticalLine = "";
		int identicalLineCounter = 0;
		
		// We will loop in the file
		while (line != null) {
			// We call the function allIdentical
			if(allIdentical(line)) {
				// If it is identical, we update the counter and the last line
				identicalLineCounter++;
				lastIdenticalLine= line;
			}
			line = f.readLine();
		}
		// Show the result
		System.out.println("The file contains "+ identicalLineCounter+ " lines with all identical characters");
		System.out.println("The last identical line is : "+lastIdenticalLine);
		
		// Close the Buffered Reader
		f.close();
	}
	
	/**
	 * Function to test if all the characters of the string to test are identical
	 * @param stringToTest
	 * @return
	 */
	static boolean allIdentical(String stringToTest) {
		int i = 0;
		
		// Special Request from Anas
		// If wewant to be sure that the string doesn't contain only spaces, we can use the 
		// methode Trim() that removes all spaces
		stringToTest = stringToTest.trim();
		
		//If the string is empty then we return false
		if(stringToTest.equals("")) {
			return false;
		} else {
			// We loop on the string and see if each character is identical to the first
			while(i < stringToTest.length() && (stringToTest.charAt(0) == stringToTest.charAt(i))){
				i++;
			}
			
			// we return true if we have reached the end of the program
			return (i == stringToTest.length());
		}
	}
	
	/**
	 * Write a program that calculates this approximation of π by summing the first 10,000 terms and
	 * displaying them as you go.
	 */
	public static void exercise3() {
		int divider = 1, termCounter = 1;
		double pi=0;
		
		while (termCounter <= 10000) {
			if (termCounter % 2 == 0)
				pi = pi - 4 * 1/ (double) divider; // Don't forget to cast it, otherwise the division will be total !
			else
				pi = pi + 4 * 1/ (double) divider;
			
			// We print the result
			System.out.println(pi);
			
			// we change the divider in order to change + and -
			divider = divider+2;
			
			// We increment the counter
			termCounter++;
		}
	}
}
