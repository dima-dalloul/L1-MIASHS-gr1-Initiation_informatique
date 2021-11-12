package td7;

import java.util.Random;

public class TD7 {

	public static void main(String[] args) {
		//exercise1();

		//exercise2();

		//exercise3();

		exercise4();
	}

	/**
	 *  We have an array of a million float type cells. Write the Boolean function zero which
	 * returns true if there is a null value in this array. Do not go through the whole table unnecessarily.
	 */
	private static void exercise1() {
		float[] arrayOfFloat = constructorOfFloatArray();

		System.out.println("the result is : " + zero(arrayOfFloat));
	}

	/**
	 * Method to construct an array of 1000000 float
	 * @return array of 1000000 float
	 */
	private static float[] constructorOfFloatArray(){
		float[] array = new float[1000000];
		Random random = new Random();
		int		min = -1,
				max = 1;

		for(int i = 0; i < array.length; i++) {
			array[i] = min + random.nextFloat() * (max - min);
		}

		return array;
	}

	/**
	 * Write the Boolean function zero which returns true if there is a null value in this array.
	 * Do not go through the whole table unnecessarily.
	 * @param array of floats
	 * @return true if a null value exists in the array, false otherwise
	 */
	private static boolean zero(float[] array) {
		// Step 1 : declare a variable
		//boolean foundAZero = false;

		// FOR LOOP
		// Step 2 : iterate in the array
		/*for(int i = 0; i < array.length; i++) {
			if(array[i] == 0) {
				//foundAZero = true;
				return true;
			}
		}

		// Step 3: return the result
		return false;
		 */

		// WHILE LOOP
		// Step 1 : declare a variable
		int i = 0;

		// Step 2 : iterate in the array
		while(i < array.length && array[i] != 0) {
			i++;
		}

		// Step 3: return the result
		return (i < array.length);
	}

	/**
	 * Write the equal boolean function which determines if two strings are identical (without
	 * use equals obviously, only charAt). Do not browse all the channels unnecessarily.
	 */
	private static void exercise2() {
		String 	string1 = "hello",
				string2 = "",
				string3 = "ABCD",
				string4 = "ABCD",
				string5 = "test1",
				string6 = "test2";

		System.out.println(string1 + " = " + string2 + " ? The result is: " + equals(string1, string2));
		System.out.println(string3 + " = " + string4 + " ? The result is: " + equals(string3, string4));
		System.out.println(string5 + " = " + string6 + " ? The result is: " + equals(string5, string6));
	}

	/**
	 * Equals boolean function which determines if two strings are identical
	 * @param character string 1
	 * @param character string 2
	 * @return true if the 2 strings are identical, false otherwise
	 */
	private static boolean equals(String string1, String string2) {
		// Step 1 : declare the variables
		boolean isIdentical = true;

		// Step 2 : check the lengths of the words
		if(string1.length() == string2.length()){
			// We can proceed to checking each letter

			/*
			// FOR LOOP 
			// Iterate in the loop
			for (int i = 0; i < string1.length(); i++) {
				if(string1.charAt(i) != string2.charAt(i)) {
					//we have found a different letter, so we will break the loop
					isIdentical = false;
					return isIdentical;
				}
			}
			//return the result
			return isIdentical;
			 */

			// WHILE LOOP
			int i = 0;

			// Iterate in the loop
			while(i < string1.length() && string1.charAt(i) == string2.charAt(i)) {
				i++;
			}

			//return the result
			return (i == string1.length());

		} else {
			// the sizes are not identical, so we can return false
			isIdentical = false;
			return isIdentical;
		}

	}

	/**
	 *  A- We want to automatically check that a password is sufficiently complex. To write
	 * the checkPassword function, which given a string, returns true if this string
	 * has at least 8 characters including at least one uppercase, one lowercase and one number.
	 * B- To check this function, write another function generatePassword that generates a word
	 * 8 character random pass between ASCII codes 48 ('0') and 122 ('z').
	 */
	private static void exercise3() {
		int i=0;
		String password;
		while(i<=20) {
			password = generatePassword();
			System.out.println(password + " : "+verifyPassword(password));
			i++;
		}
	}

	/**
	 * Function verifyPassword, which given a string, returns true if this string
	 * has at least 8 characters including at least one uppercase, one lowercase and one number.
	 * @param string
	 * @return true if the string has at least 8 characters including at least one uppercase, one lowercase and one number, false otherwise
	 */
	private static boolean verifyPassword(String passwordToTest) {
		// We will check the length of the password. If it is less than 8 characters, then we return false
		if(passwordToTest.length() < 8) {
			return false;
		} else {
			// FOR LOOP
			boolean upperCaseOK = false,
					lowerCaseOK = false,
					numberOK = false;

			// we will iterate on the password and see if there is an uppercase, lowercase and number in it
			for(int i = 0; i < passwordToTest.length(); i++) {
				if(passwordToTest.charAt(i) >= 'A' && passwordToTest.charAt(i) <= 'Z')
					upperCaseOK = true;
				else if(passwordToTest.charAt(i) >= 'a' && passwordToTest.charAt(i) <= 'z')
					lowerCaseOK = true;
				else if(passwordToTest.charAt(i) >= '0' && passwordToTest.charAt(i) <= '9')
					numberOK = true;

				// If those are 3 are here, then the password is secure enough
				if(upperCaseOK && lowerCaseOK && numberOK) {
					return true;
				}
			}

			// if we arrive here, then it means that the conditions were not met, and we return false
			return false;
		}
	}

	/**
	 * GeneratePassword function which generates a random password of 8 characters between the ASCII codes 48 ('0') and 122 ('z').
	 * @return 8-character random password between the ASCII codes 48 ('0') and 122 ('z').	
	 */
	private static String generatePassword() {
		String password = "";
		int i = 0;
		char randomCharacter;

		while(i < 8) {
			randomCharacter = (char) (Math.random() * ('z' - '0' + 1) + '0');
			// EQUALS TO 
			//randomCharacter = (char) (Math.random() * (122 - 48  + 1) + 48);

			// we add the random character to the password we are building
			password += randomCharacter;
			i++;
		}

		// we return the password
		return password;
	}

	/**
	 * We have a grid represented by a two-dimensional table t
	 * any Boolean. Black boxes are represented by the value true
	 * and the white boxes by the value false. This array is already initialized.
	 * Write the function proportionTrue which, given the array, returns the proportion (between 0 and 1) of black cells
	 */
	private static void exercise4() {
		boolean[][] t = {
				{false, false, true, false},
				{false, true, true, true},
				{false, false, false, false},
				{true, true, false, false}
		};
		double trueProportion = trueProportion(t) * 100;	// so that we can have a number in percentage
		System.out.println("The grid contains " + trueProportion + "% of 'true' cases.");

		if (whiteLine(t))
			System.out.println("There is a white line");
		else
			System.out.println("All the lines have at least one case 'true'");
	}

	/**
	 * ProportionTrue function, which given the array returns the proportion (between 0 and 1) of black cells
	 * @param 2-dimensional array t
	 * @return proportion (between 0 and 1) of black cells
	 */
	private static double trueProportion(boolean[][] array) {
		// Step 1 : declare the variable
		double counter=0;

		// Step 2: Loop in the array and count the black cases
		for(int i=0; i < array.length; i++)
			for(int j=0; j < array[0].length; j++)
				if (array[i][j])
					counter++;

		// Step 3 : return the proportion, which is counter divided by the full length
		return(counter / (array.length * array[0].length));
	}


	/**
	 * White line function which returns true if there is a line without any black box and false
	 * otherwise (do not systematically go through all the lines!).
	 * @param 2-dimensional array t
	 * @return true if there is a line without any black box and false otherwise
	 */
	private static boolean whiteLine(boolean[][] array) {
		// Step 1 : declare the variables
		int i = 0;
		int j;
		boolean found = false;
		
		// Step 2 : loop on the lines then loop on the columns
		while ( ( i < array.length) && !found) {
			j = 0;
			
			while ( ( j < array[0].length) && (array[i][j] == false)) {
				j++;
			}
				
			if (j < array[0].length)
				found = false;
			else
				found = true;
			
			i++;
		}
		
		return(found);
	}

}
