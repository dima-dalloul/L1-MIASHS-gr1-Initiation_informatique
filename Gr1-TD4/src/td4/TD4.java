package td4;

import java.util.Scanner;

public class TD4 {

	public static void main(String[] args) {
		// exercice1();
		
		//exercice2();
		
		//exercice3();
		
		//exercice4();
		
		exercice5();
	}
	
	/**
	 * Answer of exercice 1
	 */
	private static void exercice1() {
		System.out.println("Question A:");
		System.out.println("Each symbol is written as 4 bits. So \r\n"				+ "(3B,OC)16=(0011 1011, 0000 1100)2."
				+ " Then we start from the base 2 to group the bits by 3, \r\n"
				+ "on either side of the comma, which gives (73,03)8");
		
		System.out.println("\nQuestion B:");
		System.out.println("So there is 24-15-1 = 8 bits for the exponent \r\n"
				+ "-11001100.1=-1.10011001×2^7 \r\n"
				+ "The sign is 1 (negative)\r\n"
				+ "The exponent is 7+28-1-1 = 134 which is written 10000110\r\n"
				+ "The mantissa is 100110010000000\r\n"
				+ "The 24 bits are therefore 110000110100110010000000");
		
		System.out.println("\nQuestion C:");
		System.out.println("10010011 (which represents –(01101101)2 = -109)\r\n"
				+ " + 10011100 (which represents -(01100100)2 = -100)\r\n"
				+ " ---------- \r\n"
				+ "100101111\r\n"
				+ "There is a postponement (the 9th bit) and an overflow since we\r\n"
				+ " add 2 negatives and we find a positive.");		
	}
	
	/**
	 * Écrire un programme qui demande à l’utilisateur d’entrer une phrase et qui affiche 
	 * le nombre d’espaces de cette phrase.
	 */
	private static void exercice2() {
		// Step 1 : declare the variables
		String userSentence;
		int spaceCount = 0;
		Scanner scanner;
		
		// Step 2 : get the sentence from the user
		scanner = new Scanner(System.in);
		System.out.println("Please write a sentence ");
		userSentence = scanner.nextLine();
		
		// Step 3 : count the spaces in the sentence
		for (int i = 0; i < userSentence.length(); i++) {
			if(userSentence.charAt(i) == ' ') {
				spaceCount++;
			}
		}
		
		// Step 4 : show the result
		System.out.println("The number of spaces in your sentence is : " + spaceCount);
	}

	
	/**
	 * Answer of exercice 3
	 */
	private static void exercice3() {
		System.out.println("Question A:");
		System.out.println("There are 3 digits in hexadecimal after the \"1,\", so 12 bits.\r\n"
				+ " The 10-bit mantissa is therefore not Sufficient. It would have taken at least\r\n"
				+ " 12. We lost the last 2 bits of the 7 and so we have represented 0100\r\n"
				+ " instead of 0111 for this figure. So we represented the number (1,E04)16.");
		
		System.out.println("\nQuestion B:");
		System.out.println("The sign is negative (1).\r\n"
				+ "The exponent is 010011 which is worth 19 to which must be subtracted\r\n"
				+ "the surplus 26-1-1=31 that had been added to it to coding, which gives -12.\r\n"
				+ " The number is therefore\r\n"
				+ " -1.101 × 2-12 = -0.000000000001101");
		
	}
	
	/**
	 * Prenez un entier positif. S'il est pair, divisez-le par 2 ; s'il est impair, multipliez-le par 3 et ajoutez lui
	 * 1. Recommencez... Immanquablement, on aboutit à la valeur 1. Par exemple, à partir de l'entier 7, on
	 * obtient la suite suivante : 7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1. Cette conjecture
	 * attend toujours une preuve... Écrire un programme qui lit un entier et qui affiche les valeurs
	 * successives de la suite à partir de cet entier.
	 */
	private static void exercice4() {
		// Step 1 : declare the variables
		int userNumber, intermediateNumber;
		Scanner scanner;
		
		// Step 2 : get the sentence from the user
		scanner = new Scanner(System.in);
		System.out.println("Please write any number ");
		userNumber = scanner.nextInt();
		
		// Step 3 : Do the math if odd or even ad stop if the number is 1
		intermediateNumber = userNumber;
		System.out.print("" + intermediateNumber);
		while(intermediateNumber != 1) {
			if(intermediateNumber % 2 == 0)
				intermediateNumber = intermediateNumber / 2;
			else 
				intermediateNumber = (intermediateNumber * 3 ) + 1;
			
			// Show the result digit
			System.out.print("," + intermediateNumber);
		}
	}
	
	/**
	 * Écrire un programme qui lit une chaîne de caractères et qui indique le nombre de caractères de cette
	 * chaîne identiques au premier caractère (sans le compter lui-même).
	 */
	private static void exercice5() {
		// Step 1 : declare the variables
		String userSentence;
		int initialLetterCounter = 0;
		Scanner scanner;
		
		// Step 2 : get the sentence from the user
		scanner = new Scanner(System.in);
		System.out.println("Please anything ");
		userSentence = scanner.nextLine();
		
		// Step 3 : calculate the number of characters that are identical to the initial letter 
		// The statement tells us not to count the 1st, so the loop starts from the 2nd character
		for (int i = 1; i < userSentence.length(); i++) {
			if(userSentence.charAt(i) == userSentence.charAt(0)) {
				initialLetterCounter++;
			}
		}
		
		// Step 4 : show the result
		System.out.println("The number of the occurences of the first letter in your sentence is : " + initialLetterCounter);	
	}
}
