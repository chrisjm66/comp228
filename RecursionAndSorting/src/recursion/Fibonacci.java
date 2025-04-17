package recursion;

import java.util.Scanner;


public class Fibonacci {
	
	static long factorialIterative(long n) {
		
		long result = 1;
		
		for (long factor = n; factor > 0; factor--) {
			result = result * factor;
		}
		
		return result;
	}

	static long factorialRecursive(long n) {
		if (n > 0) {
			return n * factorialRecursive(n-1);
		}
		else {
			return 1;
		}
	}

	public static void main(String[] args) {

		Scanner consoleInput = new Scanner(System.in);
	
	long n = 0;
	
    do
    {
      // Get next expression to be processed.
      System.out.println("Enter an integer value for factorial calculation, 0 to quit: ");
      n = consoleInput.nextInt();
      
      System.out.println(n + " factorial, iteratively: " + factorialIterative(n));
      System.out.println(n + " factorial, recursively: " + factorialRecursive(n));
    }
    while (n != 0);
}

}


