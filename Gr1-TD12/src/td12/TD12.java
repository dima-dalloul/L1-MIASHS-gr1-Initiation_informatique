package td12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TD12 {

	public static void main(String[] args) throws IOException {
		//exercise1();

		//exercise2();
		
		exercise3();
	}

	/**
	 * Write the function deviationAverage which, given an 
	 * array of integers, returns the average of the differences between
	 * adjacent values. For example, the differences in the table opposite are 5 (difference between 7 and
	 * 12), 8 (difference between 12 and 4)… and 7 (difference between 2 and 9). The average of these deviations is therefore
	 * (5 + 8 + 7 + 6 + 14 + 1 + 8) / 7 = 6.857. Be careful not to go beyond the table, to the left or to the
	 * law.
	 */
	public static void exercise1() {
		int[] marks = {7, 12, 4, 11, 17, 3, 2, 9};

		System.out.println("The result is : "+ ecartMoyen(marks));
	}

	public static double ecartMoyen(int[] array) {
		int sum = 0;
		double result = 0.0;

		// We advance in the loop but not to the end since we will access the item at the position i + 1
		for(int i = 0; i < array.length-1; i++) {
			sum += Math.abs(array[i]-array[i+1]);
		}

		// we divide the global sum by the number of ecarts
		result = (double) sum / (array.length-1);

		// we return the result
		return result;	
	}

	/**
	 * Write a function which, given two ordered strings, returns one
	 * chain merging the two, while maintaining order. It suffices to move forward simultaneously in
	 * each of the strings by copying the "smaller" character of the two into the string. Through
	 * example, if the two strings are "BDKKL" and "FKLM", this function should return
	 * "BDFKKKLLM"
	 */
	public static void exercise2() {
		String a = "BDKKL";
		String b = "FKLM";

		System.out.println("The result is : " + mergeWords(a, b));
	}

	public static String mergeWords(String a, String b) {
		String result = "";
		int i = 0;
		int j = 0;

		while(i < a.length() && j < b.length()) {
			if(a.charAt(i) < b.charAt(j)) {
				result += a.charAt(i);
				i++;
			} else {
				result += b.charAt(j);
				j++;
			}
		}

		if(i < a.length()){
			result += a.substring(i);
		}

		if(j < b.length()) {
			result += b.substring(j);
		}

		return result;
	}

	/**
	 * Write a program that reads a java file name and indicates the number of instructions
	 * while of this program. We assume that it suffices to look for the string "while" in the lines
	 * from the program. To do this, you can use the indexOf function which returns the index of the
	 * first occurrence of one string within another. For example, if ch1 = "Nobody can
	 * prevail over the turpitude of others ", then ch1.indexOf (" be worth ") returns 18, then
	 * that ch1.indexOf ("toast") returns -1, which is the indication that the substring is not
	 * present in the chain.
	 * Bonus: considering only the braces in the java file, check that they are
	 * correctly placed. For example, this is correct: "... {…. {… ..}…. {….} ..}" but not this
	 * "{….}… ..}… ..". You can use a counter, initialized to 0, which is incremented each time
	 * opening parenthesis and decremented at each closing parenthesis. This meter must not
	 * never be negative.
	 * @throws IOException 
	 */
	public static void exercise3() throws IOException {		
		// we will test on the current file
		BufferedReader f = new BufferedReader(new FileReader("src/td12/TD12.java"));
		int total = 0;
		
		// we will loop on the file
		String line = f.readLine();
		while(line != null) {
			// we will check if "while" is in the line
			if(line.indexOf("while") != -1)
				total++;
			
			// we advance to the next
			line = f.readLine();
		}
		
		// we print out the result and close the reader
		System.out.println("Total number of while is : " + total);
		f.close();
		
	}
}
