package td3;

import java.util.Scanner;

public class TD3 {
	
	public static void main(String[] args) {
		//exercice1();
		
		//exercice2();
		
		//exercice3();
		
		//exercice4();
		
		//exercice5();
		
		exercice6();
	}

	/**
	 * Write down a program that prints all the multiples of 7 between 0 and 1000.
	 */
	private static void exercice1() {
		// --------METHOD 1--------
		/*// 1st step : initialise the variables
		int numberToPrint = 0;
		
		// With the "while", print out all the multiples of 7
		while(numberToPrint <= 1000) {
			if(numberToPrint % 7 == 0) {
				System.out.print(numberToPrint + ", ");
			}
			numberToPrint++;
		}
		*/

		// --------METHOD 2--------
		// initialise the variables
		/*int number = 0;
		
		while(number <= 1000) {
			System.out.print(number + ", ");
			number = number +  7;
		}*/
		
		// --------METHOD 3--------		
		for(int number = 0; number <= 1000 ; number = number + 7) {
			System.out.print(number + ", ");
		}
	}



	/**
	 * Write down a program that prints the first and last character of a given string
	 * Example : giving "BARBAPAPA" to the program will print B and A
	 */
	private static void exercice2() {
		// Step 1 : declare and initialise the variables
		String inputUser;
		char first, last;
		
		// Step 2 : get the string from the user
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please write anything:");
		inputUser = scanner.nextLine();
		
		// Step 3 : extract the first and last letters from inputUser
		first = inputUser.charAt(0);
		last = inputUser.charAt(inputUser.length() - 1);
		
		// Step 4 : print the result
		System.out.print("Here is the first letter: " + first + " and the last one : " + last);	
	}
	
	/**
	 * A- write -22 on 10 bits by using the method "All true"
	 * What is the number represented by this, when all the negatives are encoded by "All true": 11100001 ?
	 */
	private static void exercice3() {
		System.out.println("A");
		System.out.println("22 becomes (00010110)2. So -22 will be 11101010. We either do 11111111 - the number + 1 OR " +
					"we go from the right, we write down the 0 when they are there, we write down the first 1 that follows," + 
					" and then we invert the rest");
		

		System.out.println("B");
		System.out.println("It is a negative, so the bit that it the most to the left is equal to 1, and then we use the same method." + 
				" 00011111 equals to 31, so the number 11100001 is -31");
	}

	/**
	 * Write down a program that prints OK if the difference of the lengths of 2 strings is equal to 1 (or -1)
	 */
	private static void exercice4() {
		// Step 1 : declare and initialise the variables
		String inputUser1, inputUser2;
		int resultLengths;
		
		// Step 2 : get the strings from the user
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please write the first string:");
		inputUser1 = scanner.nextLine();
		
		System.out.println("Please write the second string:");
		inputUser2 = scanner.nextLine();
		
		// Step 3 : check the lengths
		resultLengths = inputUser1.length() - inputUser2.length();
		
		// Print the result
		//if(resultLengths == 1 || resultLengths == -1) {
		if(Math.abs(resultLengths) == 1) {	
			System.out.print("OK");
		}
	}
	
	/**
	 * A - Write a program that plays a string and displays one character out of 2 starting with the first
	 * B - Same question by asking the user the step which is not necessarily 2.
	 */
	private static void exercice5() {
		System.out.println("Question A");
		
		// Step 1 : declare and initialise the variable
		String inputUserA;
		
		// Step 2 : get the strings from the user
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please write a string:");
		inputUserA = scanner.nextLine();
		
		// Print the result
		for (int i = 0; i < inputUserA.length(); i = i + 2) {
			System.out.println(inputUserA.charAt(i));
		}
		
		System.out.println("Question B");
		
		// Step 1 : declare and initialise the variables
		String inputUserB;
		int stepUser;
		
		// Step 2 : get the strings from the user
		System.out.println("Please write a second string:");
		inputUserB = scanner.nextLine();
		System.out.println("Please write the step you want:");
		stepUser = scanner.nextInt();
		
		// Print the result
		for (int i = 0; i < inputUserA.length(); i = i + stepUser) {
			System.out.println(inputUserA.charAt(i));
		}
	}
	
	/**
	 * Write a program that reads a sum of money less than 50€ and
	 * shows how to distribute it according to the usual notes and coins.
	 * We want to provide the minimum of banknotes and coins.
	 */
	private static void exercice6() {
		// Step 1 : declare and initialise the variables
		int amountBankNote20, amountBankNote10, amountBankNote5;
		int amountCoin2, amountCoin1, amountCoin50c, amountCoin20c, amountCoin10c, amountCoin5c, amountCoin2c, amountCoin1c;
		float amountUser;
		int euros, cents;
		Scanner scanner = new Scanner(System.in);
		
		// Step 2 : get the amount from the user
		System.out.println("Enter an amount: ");
		amountUser = scanner.nextFloat();
		
		// Step 3 : recover the entire part of the amount, as well as the decimal part
		euros = (int) amountUser;
		cents = (int) (Math.round(100 * (amountUser - euros)));
		// Math.round is used to correct Java precision errors: 0.4999999999 instead of 0.5

		// Step 4: Return banknotes and coins
		if(amountUser >= 50) {
			System.out.println("Less than 50€ please!");
		} else {
			// Get the number of coins and banknotes to display
			amountBankNote20 = euros / 20;
			amountBankNote10 = (euros % 20) / 10;
			amountBankNote5 = (euros % 10) / 5;
			
			amountCoin2 = (euros % 5) / 2;
			amountCoin1 = euros % 2;
			
			amountCoin50c = cents / 50;
			amountCoin20c = (cents % 50) / 20;
			amountCoin10c = ( (cents % 50) % 20) / 10;
			amountCoin5c = ( cents %10 ) / 5;
			amountCoin2c = ( cents % 5 ) / 2;
			amountCoin1c = ( cents % 5 ) % 2;
			
			if (amountBankNote20 > 0)
				System.out.println(" " + amountBankNote20 + " banknote(s) of 20€");
			
			if (amountBankNote10 > 0)
				System.out.println(" " + amountBankNote10 +" banknote(s) of 10€");
			
			if (amountBankNote5 > 0)
				System.out.println(" " + amountBankNote5 + " banknote(s) of 5€");
			
			if (amountCoin2 > 0)
				System.out.println(" " + amountCoin2 + " coin(s) of 2€");
			
			if (amountCoin1 > 0)
				System.out.println(" " + amountCoin1 + " coin(s) of 1€");
			
			if (amountCoin50c > 0)
				System.out.println(" " + amountCoin50c + " coin(s) of 50 cents");
			
			if (amountCoin20c > 0)
				System.out.println(" " + amountCoin20c + " coin(s) of 20 cents");
			
			if (amountCoin10c > 0)
				System.out.println(" " + amountCoin10c + " coin(s) of 10 cents");
			
			if (amountCoin5c > 0)
				System.out.println(" " + amountCoin5c + " coin(s) of 5 cents");
			
			if (amountCoin2c > 0)
				System.out.println(" " + amountCoin2c + " coin(s) of 2 cents");
			
			if (amountCoin1c > 0)
				System.out.println(" " + amountCoin1c + " coin(s) of 1 cents");
		}
	}
}
