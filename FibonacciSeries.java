/**
 * The three Methods for calculation of the Fibonacci Series + The Running Time.
 * 1. Iterative Method.
 * 2. Recursive Method without Memoization.
 * 3. Recursive Method with Memoization
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the various Method of 
 * calculating Fibonacci Series and compares the running times of each method. 
 */

import java.util.Scanner;
import java.util.ArrayList;

public class FibonacciSeries
{
    public static void main(String[] args)
    {
        // Get the nth term for the Fibonacci Series
        int term = getTerm();

		// For recursion with memoization:if fibArr[i] is -1, it is not calculated yet
		for(int i = 0; i < 51; i++)
			fibArr[i] = -1;
        
        // Display the nth term of the Fibonacci Series.
        displayTerm(term);        
        
        // Display the first 10 values of the series.
        displaySeries();
    }

    /**
     * Displays the nth term of the Fibonacci Series, and compare the running time of the results.
     * @param num The term entered by the user.
     */
    public static void displayTerm(int num)
    {
		// Calculate time for recursive fib without Memoization.
		long recStart = System.currentTimeMillis();
		int fibResult1 = fibRec(num - 1);
		long recEnd = System.currentTimeMillis();

        System.out.println("The " + num + 
                            " term of the Recursive Fibonacci Series is " + fibResult1);

		// Calculate time for recursive fib with Memoization.
		long recMemoStart = System.currentTimeMillis();
		int fibResult2 = recMemo(num - 1);
		long recMemoEnd = System.currentTimeMillis();

        System.out.println("The " + num + 
                            " term of the Recursive Fibonacci Series is " + fibResult2);		

		// Calculate time for iterative fib.
		long iterativeStart = System.currentTimeMillis();
		int fibResult3 = fibIterative(num - 1);
		long iterativeEnd = System.currentTimeMillis();
	
	    System.out.println("The " + num + 
                            " term of the Iterative Fibonacci Series is " + fibResult3);
		
		// Display the running time of each method.
		System.out.println("The time for Recursive Method without Memoization Fibonacci Series: " + (recEnd - recStart) + " milliseconds"); 
		System.out.println("The time for Recursive Method with Memoization Fibonacci Series: " + (recMemoEnd - recMemoStart) + " milliseconds"); 
		System.out.println("The time for Iterative Method Fibonacci Series: " + (iterativeEnd - iterativeStart) + " milliseconds"); 
    }
    
    /**
     * @return The number entered by the user.
     */
    public static int getTerm()
    {
        return validateInteger("Enter the term for the Fibonacci series: ");
    }
    
    /**
     * Displays the first 10 terms of the Fibonacci Series.
     */
    public static void displaySeries()
    {
        System.out.println("\nThe first 10 terms of the Fibonacci Series: ");
        for(int i = 0; i < 10; i++)
        {
            if(i == 9)
                System.out.print(fibRec(i) + "\n");
            else
                System.out.print(fibRec(i) + ", ");
        }
    }
    
    /**
     * The fibRec method gets the value of the nth term 
	 * of the Fibonacci Series. [Recursive without Memoization Method].
     * @param n The nth term entered by the user.
     * @return The nth term of the Fibonacci Series.
     */
    public static int fibRec(int n)
    {
        if(n <= 1)
            return n;
        else
            return fibRec(n - 1) + fibRec(n - 2);
    }

	// Create an array object to keep the memoization terms in memory.
	public static int[] fibArr = new int[51];

	/**
     * The recMemo method gets the value of the nth term 
	 * of the Fibonacci Series [Recursive with Memoization Method].
     * @param n The nth term entered by the user.
     * @return The nth term of the Fibonacci Series.
     */
	public static int recMemo(int n)
	{
        if(n <= 1)
            return n;

		else if(fibArr[n] != -1)
			return fibArr[n];
		return recMemo(n - 1) + recMemo(n - 2);
	}

	/**
     * The fibIterative method gets the value of the nth term of
	 * the Fibonacci Series. [Iterarative Method].
     * @param n The nth term entered by the user.
     * @return The nth term of the Fibonacci Series.
     */
    public static int fibIterative(int num)
    {
		ArrayList<Integer> list = new ArrayList<Integer>();		

		for(int i = 0; i <= num; i++)
		{
			if(i <= 1)
				list.add(i);
			else
				list.add(list.get(i - 1) + list.get(i - 2));
		}
		return list.get(list.size() - 1);
	}
    
    /**
     * The validateInteger method validates the integer format of the number.
     * @param str The message prompt asking to enter the nth term of the Fibonacci Series.
     * @return The x in the proper integer format.
     * @exception NumberFormatException when x has a wrong integer format.
     */
    public static int validateInteger(String str)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean b = true;
        int x = 0;
        do
        {
            try 
            {
                do
                {
                    b = true;
                    System.out.print(str);
                    x = Integer.parseInt(keyboard.next());
                    if(x <= 0)
                        System.out.println("Must Enter a Number Greater than 0! Try again!");
                }
                while(x <= 0);
                System.out.println();
            }
            catch(NumberFormatException nfe) 
            {
                b = false;
                System.out.println("Must Enter Integer! Try again!");
            }
        }
        while(b == false);
        return x;
    }
}
