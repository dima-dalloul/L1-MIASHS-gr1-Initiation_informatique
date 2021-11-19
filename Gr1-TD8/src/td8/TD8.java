package td8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TD8 {
	public static void main(String[] args) throws IOException {
		exercise1();
		exercise2();
		exercise3();
		exercise4();
	}

	/**
	 * We consider an integer matrix, a two-dimensional array of type int [] [].
	 * a) Write the function max which returns the largest element of the matrix. You have to go through all the
	 * rows and for each one browse all the columns.
	 * b) Write the function identicalDiagonal which returns true if all the elements of the diagonal are
	 * identical. The elements of the diagonal are at subscripts [1] [1], [2] [2], [3] [3]…
	 */
	private static void exercise1() {
		int[][] matrix = new int[10][10];
		matrix = fillMatrix(matrix);

		// Answer of question A: 
		int result = max(matrix);
		System.out.println("The maximum value is "+ result);

		// Answer of question B: 
		boolean diagonalIdentical = identicalDiagonal(matrix);
		System.out.println("The answer to Identical Diagonal is "+ diagonalIdentical);
	}

	/**
	 * Function to fill the matrix with random data
	 */
	private static int[][] fillMatrix(int[][] array){
		Random random = new Random();
		int		min = -1,
				max = 1;

		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = min + (int)(Math.random() * ((max - min) + 1));
			}
		}

		return array;
	}

	/**
	 * Function that returns the largest element of the matrix
	 * @param matrix m
	 * @return maximum found
	 */
	private static int max(int[][] m) {
		// Step 1 : declare the variables
		int result = 0;
		
		// Step 2: Loop all the rows and the columns
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				if(result < m[i][j]) {
					result = m[i][j];
				}
			}
		}
		
		// Step 3: return the result
		return result;
	}


	/**
	 * Function that returns true if all the elements of the diagonal are the same
	 * @param matrix m
	 * @return boolean.
	 */
	private static boolean identicalDiagonal(int[][] m) {
		// Step 1 : declare the variables
		boolean same = false;
		int i = 0;
		
		// Step 2 : Loop to see if the values are identical in the diagonal
		while(i < m.length && m[i][i] == m[0][0]) {
			i++;
		}
		
		//Step 3 : return the result
		return (i == m.length);
		//EQUALS TO 
		//return !(i < m.length);
	}


	/**
	 * We have a text file containing, on each line, two series of letters separated by a
	 * space. Write a function which, given the name of the file and a character, returns the number of
	 * lines whose two words both begin with this character.
	 */
	private static void exercise2() {
		int result = nbLines("ex2.txt", 'B');
		System.out.println("Number of lines : " + result);
	}

	/**
	 * Function which, given the name of the file and a character, returns the number of
	 * lines whose two words both begin with this character.
	 * @param the name of the file to read
	 * @param the character to find
	 * @return number of lines in which 2 words start with the same character
	 */
	private static int nbLines(String fileName, char c){
		// Step 1 : declare the variables
		int counter = 0;
		
		// Use try/catch for the case the file doesn't exist
		try {
			// Step2: Use BufferedReader to read the file
			// If it doesn't exist, the program won't stop but we will have an error log
			BufferedReader f = new BufferedReader(new FileReader(fileName));
			String word1, word2;
			String line = f.readLine();
			int idspace;
			
			// Loop on the lines
			while(line != null){
				// Locate the space
				idspace = line.indexOf(' ');
				if(idspace > 0 ) {
					// Get the word 1 and word 2
					word1 = line.substring(0, idspace);
					word2 = line.substring(idspace+1);
					
					// If the first letters of word 1 and 2 are equal to the character, then increase the counter
					if(word1.charAt(0) == c && word2.charAt(0) == c) {
						counter++;
					}
				}
				
				// Go to the next line
				line = f.readLine();
			}
			// Close the reader to free the resources
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return counter;
	}

	/**
	 * Write the action to the power of 2 which, given an integer n, writes the first n
	 * powers of 2 in the "powers2.txt" file, one number per line. Through
	 * example, with the value 6, this action will have to create the file opposite.
	 * @throws IOException 
	 */
	private static void exercise3() throws IOException {
		puissance2(5);
	}

	
	/**
	 * Function that writes the first n powers of 2 in the "powers2.txt" file, one number per line
	 * @param n first n powers of 2 
	 * @throws IOException
	 */
	private static void puissance2(int n) throws IOException{	
		// Step 1 : Open the file writer
		// if the file exists, it will erase it and write as if new
		// if it doesn't exist, then it will create it and write in it
		BufferedWriter f = new BufferedWriter(new FileWriter("puissances2.txt"));
		
		long result = 1;
		
		// Step 2 : Fill with the puissances of 2
		for(int i = 0; i < n ; i ++) {
			f.write(result + "\n");
			result = result * 2;
		}

		// Close the writer to free the resources
		f.close();
	}

	/**
	 * Write the instructions to copy the contents of the integer array tab to a text file, an integer
	 * by line. For example, if the array contains the values {1,2,3,4,5}, then a text file will be created
	 * with 5 lines: 1 on the first line, 2 on the 2nd, etc. Please note, the action of writing to a file
	 * takes as parameter a string and not an integer.
	 * @throws IOException 
	 */
	private static void exercise4() throws IOException {
		int[] array = new int[] {1,2,3,4,5,6,7,8,9,10};
		ecrireTableauDansFichier(array, "ex4.txt");
	}
	
	/**
	 * Function that copies the contents of the integer array tab to a text file, an integer
	 * by line. The file will be written this way: 1 on the first line, 2 on the 2nd, etc.
	 * @param array to write
	 * @param name of the file that will contain the array
	 */
	private static void ecrireTableauDansFichier(int[] array, String fileName) throws IOException {		
		// Step 1 : Open the file writer
		// if the file exists, it will erase it and write as if new
		// if it doesn't exist, then it will create it and write in it
		BufferedWriter f = new BufferedWriter(new FileWriter(fileName));

		// Step 2 : Fill with the contents of the array
		for(int i = 0; i < array.length; i++) {
			f.write(""+array[i]);
			f.newLine();
		}

		// Close the writer to free the resources
		f.close();
	}
}
