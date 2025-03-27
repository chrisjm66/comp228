//----------------------------------------------------------------------
// PFixConsole.java         by Dale/Joyce/Weems                Chapter 3
//
// Evaluates posfix expressions entered by the user.
// Uses a Console interface.
//----------------------------------------------------------------------
package apps;

import java.util.Scanner;


public class PFixConsole 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    String line = null;          // string to be evaluated
    // String more = null;          // used to stop or continue processing
    int result;                  // result of evaluation

    do
    {
      // Get next expression to be processed.
      System.out.println("Enter a postfix expression to be evaluated (or 'quit'):");
      line = conIn.nextLine();
      
      if (line.toLowerCase().equals("quit")) {
    	  break;
      }
      
      try
      {
        result = PostFixEvaluator.evaluate(line);
        System.out.println("Result = " + result + "\n");
      }
      catch (PostFixException error)
      {        
        // output error message
        System.out.println();
        System.out.println("Error in expression - " + error.getMessage());
      }
      
      /* /
      // Determine if there is another expression to process.
      System.out.println();
      System.out.print("Evaluate another expression? (Y=Yes): ");
      more = conIn.nextLine();
      System.out.println();
      /**/
    }
    // while (more.equalsIgnoreCase("y"));
    while (true);
    
    conIn.close();

    System.out.println("Program ended");
  }
}