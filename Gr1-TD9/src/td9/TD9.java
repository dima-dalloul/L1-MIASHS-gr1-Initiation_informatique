package td9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TD9 {

	public static void main(String[] args) throws IOException {
		//exercise1();

		//exercise2();

		exercise3();
	}


	/**
	 * Write a program that displays the average length of the lines in a file whose name is entered on the keyboard.
	 * Blank lines are not taken into account.
	 * @throws IOException 
	 */
	private static void exercise1() throws IOException {
		// Step 1 : get the file name
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the name of the file?");
		String filename = scanner.next();

		// Step 2 : open the file
		BufferedReader f = new BufferedReader(new FileReader(filename));

		// Step 3: count the lines and their lengths
		int line_counter = 0;
		int total_line_lengths = 0;
		String line = f.readLine();

		// Step 4: Loop in the file
		while(line != null) {
			// If the line is not empty, then increment the counter and add the total length
			if(line.length() > 0) {
				line_counter++;
				total_line_lengths += line.length();
			}

			// Advance to the next Line
			line = f.readLine();
		}

		// Step 5: Close the BuffredReader
		f.close();

		// Step 6: print the result on the console
		double average_length = (double) total_line_lengths / line_counter;
		System.out.println("The average line length is "+ average_length);
	}


	/**
	 * We have files containing on each line a product name, a semicolon and a number floating.
	 * A - Write a "total" function that, given a file name, returns the sum of the numbers that are after the semicolons.
	 * You can use the substring function that returns a substring a string (ch.substring(start,length) or ch.substring(start))
	 * and the function indexOf which returns the index of the first occurrence of a character (ch.indexOf(car)).
	 * B- Write an action that takes as a parameter the name of a file, as well as a rate value and that creates a second file
	 * that contains the same information as the first file, except that the numbers after the semicolons will have been
	 * increased by a percentage equal to the rate parameter. 
	 * @throws IOException 
	 */
	private static void exercise2() throws IOException {
		// Answer to part A
		// Get the file name
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the name of the file?");
		String filenameA = scanner.next();

		double t = total(filenameA);
		System.out.println("The total price is " + t);


		// Answer to part B
		// Get the file name
		System.out.println("What is the name of the file?");
		String filenameB = scanner.next();

		// Get the rate
		System.out.println("What is the rate?");
		double rate = Double.parseDouble(scanner.next());
		newprice(filenameB, rate);
	}

	private static double total(String file) throws IOException {
		// Step 1 : open the given file
		BufferedReader f = new BufferedReader(new FileReader(file));

		// Step 2 : loop in the file and read lines
		String line = f.readLine();
		double totalPrice = 0.0;
		double price = 0;
		while(line != null) {
			String price_part = line.substring(line.indexOf(";")+1);
			price = Double.parseDouble(price_part);
			//price = Float.parseFloat(price_part);
			totalPrice += price;

			line = f.readLine();
		}

		// Step 3 : return the total price
		return totalPrice;
	}

	private static void newprice(String filename, double rate) throws IOException {
		// Step 1 : open the given file
		BufferedReader fr = new BufferedReader(new FileReader(filename));

		// Step 2 : create a new file using File Writer
		BufferedWriter fw = new BufferedWriter(new FileWriter("NEW_" + filename));

		// Step 3 : read the line in the original filename
		String line = fr.readLine();

		// Step 4 : loop in the file and get the product and the price
		String productName;
		double price, newPrice;

		while(line != null) {
			// Extract the product name
			productName = line.substring(0, line.indexOf(";"));

			// Extract the price : get it as a string and then convert it to double
			price = Double.parseDouble(line.substring(1 + line.indexOf(";")));

			// Calculate the new price using the rate
			newPrice = price + ( price * rate / 100);

			// write the product name and the new price in the new file
			fw.write(productName + ";" + newPrice + "\n");

			// advance to the next line
			line = fr.readLine();
		}

		// Step 5 : close the buffers
		fr.close();
		fw.close();
	}

	/**
	 * Write an action that reads a name and a number of seconds successively on the keyboard until the name entered is "*FIN*". 
	 * This action also writes to the result file.txt each name and each duration in the form HH:MM:SS (except possibly the 0 of the tens),
	 * at the rate of one per line.
	 * @throws IOException 
	 */
	private static void exercise3() throws IOException {
		// Step 1: Open the scanner to read the input of the user
		Scanner scanner = new Scanner(System.in);

		// Step 2: open the file writer
		BufferedWriter f = new BufferedWriter(new FileWriter("resultat.txt"));

		// Step 3: declare the variables name and time that will be written in the file
		String name;
		int time;

		// Step 4 : loop on the user's input until we get the word of end
		do {
			// Get the name
			System.out.print("Name ? ");
			name = scanner.nextLine();
			
			// Test if it is not the word of end
			if (!name.equals("*FIN*")) {
				
				// Get the time
				System.out.print("Time ? ");
				time = scanner.nextInt();
				scanner.nextLine(); // to delete the character "End of Line" that the user has put, this way there will be no problem for the next nextLine
				
				// Write the name and the time in the new file
				f.write(name + " " + (time/3600) + ":" + ((time/60)%60) + ":" + (time%60));
				// Add a new line to the file
				f.newLine();
			}
		}
		while (!name.equals("*FIN*"));
		
		// Step 5 : Alert the user of the end of our program and close the stream
		System.out.println("Thanks. The file \"resultat.txt\" has been generated.");
		f.close();
	}
}
