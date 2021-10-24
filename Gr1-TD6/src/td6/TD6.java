package td6;

public class TD6 {

	public static void main(String[] args) {
		//exercise1();

		//exercise2();

		//exercise3();
		
		//exercise4();
		
		exercise5();
	}

	/**
	 * Write a function that, given an array of doubles, returns the counter of negative values
	 */
	private static void exercise1() {
		// create an array of doubles
		double[] tab = {2.0, 1.0, 11.0, -100.0, 0, -29, 123548, -128};

		// Test the method counterNegativeValues with this array
		int counter = counterNegativeValues(tab);

		// Print out the result just to see if the test works
		System.out.println("The counter of negative values is equal to " + counter);
	}

	/**
	 * A method that gives the total number of negative values in the array of double given to it
	 * @param array of doubles
	 * @return total number of negative values
	 */
	private static int counterNegativeValues(double[] array) {
		// Step 1 : declare the variables
		int counter = 0;

		// Step 2: calculate the number of negative values
		for(int i = 0; i < array.length; i++) {
			// Check if the item is negative. If it is, then increment the counter
			if(array[i] < 0) {
				counter++;

				// Equals to this one
				//counter = counter + 1;
			}
		}

		// Return the counter
		return counter;
	}

	/**
	 * Write the "repeat" function that, when given a string and an integer N, returns the string repeated N times.
	 * For example, repeat("LA",4) returns "LALALALA". The function must return the empty string if N is
	 * negative or null.
	 */
	private static void exercise2() {
		// We will test the method repeat with the different values of N
		System.out.println(repeat("LA", 5));
		System.out.println(repeat("No",-1));
		System.out.println(repeat("Hello", 0));
		System.out.println(repeat("Test",25));
	}

	/**
	 * Method that will repeat the given stringToRepeat as many times as the value numberOfRepetitions and return the result
	 * @param stringToRepeat string to repeat
	 * @param numberOfRepetitions number of times to repeat
	 * @return result string
	 */
	private static String repeat(String stringToRepeat, int numberOfRepetitions) {
		// Step 1 : declare the variables
		String result = "";
		int i = 0;

		// Step 2: check if numberOfRepetitions is negative or null
		if(numberOfRepetitions <= 0) {
			// if it is, return an empty string
			return "";
		} else {
			// if it is positive, do a loop and add the string as many times as the value numberOfRepetitions
			while (i < numberOfRepetitions) {
				// we add the string to the result, this way it will be added at the end of result string
				result += stringToRepeat;

				//Equals to 
				//result = result + stringToRepeat;

				// increment the value of i to advance in the loop
				i++;
			}

			// return the result
			return result;
		}
	}

	/**
	 * Write in Java the "nbcommun" function that, when given two strings of the same length, returns the number 
	 * of identical elements at the same positions. 
	 * For example, nbcommun("ABC",DEF") returns 0 and nbcommun("ABCD",AMCZ") returns 2 
	 * (because the first and third characters are identical).
	 */
	private static void exercise3() {
		// We will test the method nbcommun with the different strings
		System.out.println(nbcommun("LA", "NY"));
		System.out.println(nbcommun("No","ON"));
		System.out.println(nbcommun("Hello", "HELP")); // uppercase and lowercase strings are not identical
		System.out.println(nbcommun("Test","Less"));
	}

	/**
	 * function that, when given two strings a and b, returns the number 
	 * of identical elements at the same positions.
	 * @param a first string
	 * @param b second string
	 * @return counter of identical characters at the same positions
	 */
	private static int nbcommun(String a, String b) {
		// Step 1 : declare the variables
		int counter = 0;

		// Test if a and b are the same d
		if(a.length() != b.length()) {
			// if not, return 0
			return 0;
		} else {
			// if yes, loop on the words
			for(int i = 0; i < a.length(); i++) {
				// test if they are identical
				if(a.charAt(i)  ==  b.charAt(i)) {
					// increment the counter if the letters are identical
					counter++;
				}
			}

			// return the counter
			return counter;
		}
	}


	/**
	 * Write an "allBefore" function that, given a string of letters and a 
	 * letter L1, returns true if all characters in the string are located before L1 in alphabetical order.
	 * For example: allBefore("GRENOBLE", 'W') returns true.
	 */
	private static void exercise4() {
		// View the result of the method allBefore
		System.out.println(allBefore("GRENOBLE", 'W'));
		System.out.println(allBefore("GRENOBLE", 'I'));
	}
	
	private static boolean allBefore(String a, char letterToTest) {
		// First way : use of FOR loop
		// Step 1 : declare the variable
//		boolean result = true;
//
//		Step 2 : Test whether the letter at position i is BEFORE the given letter as a parameter
//		for(int i = 0; i < a.length(); i++) {
//			if(a.charAt(i) < letterToTest) {
//				result = false;
//				return result;
//			}
//		}
//		return result;

		// Second way : use of While loop
		// Step 1 : declare the variables
		boolean result = true;
		int i  = 0;
		
		// Step 2 : Test whether the letter at position i is BEFORE the given letter as a parameter
		while(i < a.length() && result == true) {
			if(a.charAt(i) < letterToTest) {
				// if a letter of the word is equal to or after the given letter, then we set the boolean
				// to false
				result = false;
			}
			i++;
		}

		
		// Step 3 : we test the outcome. If we attained the end of the word, this means that no letter is 
		// after the letter to test and we return true. If not, it means that a letter after the letter to test has been found
		// and so we need to return false		
		if(i == a.length()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Write a program that reads a string of characters and creates another string of the same length
	 * but where each capital letter is replaced by the letter that is five characters before in the alphabet. 
	 * For example, the J will be replaced by E. If we fall before the A, we continue to retreat from Z.
	 * For example, B will be replaced by W. Other characters are not changed. For letters, it is not
	 * necessary to write a series of 26 tests, one for each letter, but to find a general formula
	 * with a test eventually. Test this program with the channel "FUWJX MZNY MJZWJ YWJSYJ H'JXY UQZX Q MJZWJ".
	 */
	private static void exercise5() {
		// View the result of the method wordTransform
		wordTransform("FUWJX MZNY MJZWJ YWJSYJ H’JXY UQZX Q MJZWJ");
		wordTransform("GRENOBLE");
	}


	/**
	 * This function reads the given word as a parameter and creates and displays another word of the same length
	 * but where each capital letter is replaced by the letter that is five characters before in
	 * the alphabet.
	 * @param word to transform
	 */
	static void wordTransform(String word) {
		// Step 1 : Declare the variables
		String result = "";
		
		// Step 2 : Iterate on each letter of the word
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) >= 'F' && word.charAt(i) <= 'Z') {
				// If the letter is between F and Z, then we can replace with the letter which is 5 letters before
				result += (char) (word.charAt(i) - 5);
			} else if(word.charAt(i) >= 'A' && word.charAt(i) <= 'E') {
				// If the letter is between A and E, then we continue to move backwards from Z
				result += (char) (word.charAt(i) + 'Z' - 'A' + 1 - 5);
			} else {
				// In all other cases, we do not transform the letters (because they are tiny)
				result += word.charAt(i);
			}			
		}
		
		// Step 3: Display the word in the console
		// NB: it has not been asked to return the word, so we will only display it in the console
		System.out.println(result);
	}
}
