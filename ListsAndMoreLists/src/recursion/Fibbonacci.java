package recursion;

import java.util.Scanner;

public class Fibbonacci {
	public static void main(String[] args) {
		Scanner consoleInput = new Scanner(System.in);
		
		long numToFib;
		do {
			System.out.println("\nEnter a number and I will recursively find a fibbonacci number with it (0 to quit):");
			numToFib = consoleInput.nextLong();
			System.out.println("Answer: " + getFibNumber(numToFib));
		} while (numToFib != 0);
		consoleInput.close();
	}
	
	public static long getFibNumber(long i) {
		if (i <= 1) {
			return i;
		} else {
			return getFibNumber(i-1) + getFibNumber(i-2);
		}
	}
}
