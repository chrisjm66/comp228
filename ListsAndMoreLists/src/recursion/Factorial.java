package recursion;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner consoleInput = new Scanner(System.in);
		
		long numToFactorial;
		do {
			System.out.println("\nEnter a number and I will recursively factorial it (0 to quit):");
			numToFactorial = consoleInput.nextLong();
			System.out.println("Answer: " + factorial(numToFactorial));
		} while (numToFactorial != 0);
		consoleInput.close();
	}

	private static long factorial(long i) {
		if (i <= 1) {
			return 1;
		}
		
		return i * factorial(i-1);
	}
}
