package td5;

import java.util.Scanner;

public class TD5 {

	public static void main(String[] args) {
		//exercise1();

		//exercise2();

		//exercise3();

		//exercise4();

		exercise5();
	}

	/**
	 * Écrire la fonction avantDernierCar qui prend en paramètre une chaîne de caractères 
	 * et qui retourne l’avant-dernier caractère de cette chaîne
	 */
	private static void exercise1() {
		// Case 1 : Input from the developer
		// Step 1 : declare the variable
		//		String test = "Hello World in MIASHS Grenoble";
		//		
		//		// Step 2 : print out the letter before the last one in the string test
		//		System.out.println("The original string is : " + test);
		//		System.out.println("The letter before the last one is : " + test.charAt(test.length()-2));

		// Case 2 : Input from the user
		// Step 1 : declare the variable
		String inputUser;
		Scanner scanner;

		// Step 2 : get the input from the user
		System.out.println("Write something");
		scanner = new Scanner(System.in);
		inputUser = scanner.nextLine();


		// Step 3 : print out the letter before the last one in the inputUser
		System.out.println("The letter before the last one is : " + inputUser.charAt(inputUser.length()-2));
	}

	/**
	 * Écrire une fonction qui prend en paramètre deux entiers et qui retourne le plus grand. Écrire
	 * un programme principal qui lit deux entiers et qui affiche le plus grand en appelant la
	 * fonction.
	 */
	private static void exercise2() {
		// Step 1 : declare the variables
		int number1, number2;
		int result;
		Scanner scanner;

		// Step 2 : get the input from the user
		System.out.println("Write the first numter");
		scanner = new Scanner(System.in);
		number1 = scanner.nextInt();

		System.out.println("Write the second numter");
		number2 = scanner.nextInt();

		// Ste 3 : call the method biggerValue() and print the result
		result = biggerValue(number1, number2);
		System.out.println("the bigger value between " + number1 + " and " + number2 + " is " + result );
	}

	/** Method BiggerValue 
	 * It will return the bigger value between the 2 parameters */
	private static int biggerValue(int a, int b) {
		if(a < b)
			return b;
		else
			return a;
	}

	/**
	 * Écrire une action qui, étant donné un tableau d'entiers et un entier N, affiche les N premiers 
	 * éléments du tableau (les éléments d'indice 0 à N-1).
	 */
	private static void exercise3() {
		// Step 1 : declare the variables
		int[] table = {1 , 2 ,3,4,5,5,6,6,4,2,7,5,5,2,4,8,5,1,4,5,8};
		int n = 5;

		// Step 2 : call the method printNElementsFromArray() 
		printNElementsFromArray(table, n);
	}

	/**
	 * Method printNElementsFromArray
	 * It will print in the console the N elements of the array
	 */
	private static void printNElementsFromArray(int[] array, int n) {
		// Test if n is smaller than the array's length
		if(n <= array.length) {
			
			// Print the elements from 0 to n-1
			System.out.print("[");
			for(int i = 0; i < n; i++) {
				System.out.print(" " + array[i]);
			}
			System.out.print(" ]");
		} else {
			// if n is bigger than the array's length, tell the user
			System.out.println("N is out of boundaries of the array");
		}
	}

	/**
	 * Écrire une fonction qui, étant donné un tableau de booléens, retourne la proportion (entre 0
	 * et 1) de valeurs true de ce tableau.
	 */
	private static void exercise4() {
		// Step 1 : declare the array
		boolean[] table = {true, true, false, false};

		// Step 2 : call the method proportionOfTrueInArray() 
		System.out.print("the proportion is : "+ proportionOfTrueInArray(table));
	}

	/**
	 * Method proportionOfTrueInArray
	 * It will return the proportion of True in the given array
	 */

	private static double proportionOfTrueInArray(boolean[] array) {
		// Step 1 : declare the variable
		int trueCounter = 0;
		
		// Step 2 : Loop in the array and count the "true"
		for (int i = 0; i < array.length; i++) {
			if(array[i]) {
				// count the number of true in it and increment the counter
				trueCounter++;
			}
		}
		
		// Step 3 : return the proportion
		return ( (double) trueCounter / array.length);
	}

	/**
	 * Écrire un programme qui permette de retrouver des mots dans une liste de mots. On utilise
	 * un tableau de chaîne de caractères initialisé au début du programme. Par exemple :
	 * String[]t= {"chocolat","caramel","farine","sel","sucre","chou"};
	 * Le programme lit une lettre au clavier et affiche tous les mots qui commencent par cette
	 * lettre, puis redemande une autre lettre, etc. Le programme s’arrête quand on tape ‘#’ :
	 */
	private static void exercise5() {
		// Step 1 : declare the variables
		Scanner scanner;
		String[] array = {"chocolate","caramel","flour","salt","sugar","cabbage"};
		char inputUser;
		
		// Step 2 : get the user's input and enter the loop
		scanner = new Scanner(System.in);
		do {
			System.out.print("Letter ? ");
			inputUser = scanner.nextLine().charAt(0);
			
			// Test to see if the input is not empty
			if (inputUser!=' ') {
				// Loop in the array
				for(int i=0; i < array.length; i++) {
					// check if the word's initial matches the letter
					if (array[i].charAt(0) == inputUser) {
						// Write the word if the match is correct
						System.out.println(array[i]);
					}
				}
			}			
		} while (inputUser != '#');
	}
}
