package recursion;

import java.util.Scanner;


public class Factorial {
	
	static long fiboIterative(long n) {
		
		long result = 1;
		
		if (n > 2) {
			long back1 = 1;
			long back2 = 1;
			for (int i = 3; i <= n; i++) {
				result = back1 + back2;
				// set up next iteration of the loop
				back2 = back1;
				back1 = result;
			}
		}
		return result;
	}

	static long fiboRecursive(long n) {
		
		if (n <= 2) {
			return 1;
		}
		else {
			return fiboRecursive(n-1) +
					fiboRecursive(n-2);
		}
	}

	public static void main(String[] args) {

		Scanner consoleInput = new Scanner(System.in);
		
		long n = 0;
		
		do {
			// Get next expression to be processed.
			System.out.println("Enter an integer value for factorial calculation, 0 to quit: ");
			n = consoleInput.nextInt();
			
			System.out.println(n + " Fibo, iteratively: " + fiboIterative(n));
			System.out.println(n + " Fibo, recursively: " + fiboRecursive(n));
		}
		while (n != 0);
	}
}


