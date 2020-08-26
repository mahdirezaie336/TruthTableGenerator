/**
 * This program generates the truth table of a function "f" which user
 * types it in the code.
 * 
 * User must define the function in "f" method and number of bits in main method.
 * 
 * @author Mahdi Rezaie
 * @version 1.0
 */
public class Function
{
	public Function()
	{
		
	}
	
	public static boolean ifAThenB(boolean a, boolean b)
	{
		return (!a)||b;
	}
	
	/**
	 * Calculates sum of minterms with a given values.
	 * @param values Values of the variables
	 * @param minterms The minterms numbers
	 * @return Sum of minterms with given values
	 */
	public static boolean sumOfMinterms(boolean[] values, int...minterms)
	{
		boolean sum = false;
		for(int minterm : minterms)
		{
			boolean product = ((minterm%2)==1?values[values.length-1]:!values[values.length-1]);
			for(int i = values.length - 1; i >= 0 ; --i)
			{
				product = product && ((minterm%2)==1?values[i]:!values[i]);
				minterm /= 2;
			}
			sum = sum || product;
		}
		return sum;
	}
	
	/**
	 * Calculates product of maxterms with a given values
	 * @param values Values of the variables
	 * @param maxterms The maxterm numbers
	 * @return Product of maxterms with given values
	 */
	public static boolean productOfMaxterms(boolean[] values, int...maxterms)
	{
		boolean product = true;
		for(int maxterm : maxterms)
		{
			boolean sum = ((maxterm%2)==1?!values[values.length-1]:values[values.length-1]);
			for(int i = values.length - 1; i >= 0 ; --i)
			{
				sum = sum || ((maxterm%2)==1?!values[i]:values[i]);
				maxterm /= 2;
			}
			product = product && sum;
		}
		return product;
	}
	
	/**
	 * Converts the "args" number from base 2 to 10.
	 * @param args The number in base 2
	 * @return The number in base 10
	 */
	public static int toInt(boolean... args)
	{
		int i = args.length;
		int number = 0;
		for(boolean digit : args)
			number += (digit?1:0)*Math.pow(2, --i);
		return number;
	}
	
	/**
	 * Calculates "Or" for given values.
	 * @param args The values to be calculated
	 * @return The "Or" of values "args"
	 */
	public static boolean or(boolean... args)
	{
		boolean f = args[0];
		for(boolean member : args)
			f = f || member;
		return f;
	}
	
	/**
	 * Calculates "And" for given values.
	 * @param args The values to be calculated
	 * @return The "And" of values
	 */
	public static boolean and(boolean... args)
	{
		boolean f = args[0];
		for(boolean member : args)
			f = f && member;
		return f;
	}
	
	/**
	 * Calculates "Xor" for given values.
	 * @param args The values to be calculated
	 * @return The "Xor" of the values
	 */
	public static boolean xor(boolean... args)
	{
		boolean result = false;
		for(boolean member : args)
		{
			result = or(and(!result,member),and(result,!member));
		}
		return result;
	}
	
	/**
	 * Calculates F = JQ' + K'Q
	 * @param j The j value
	 * @param k The k value
	 * @param q The q value
	 * @return Returns F
	 */
	public static boolean JK(boolean j, boolean k, boolean q)
	{
		return or(and(j,!q),and(!k,q));
	}
	
	/**
	 * Combines the array args with newNumber
	 * @param newMember
	 * @param args
	 * @return The combination in a new Array
	 */
	public static boolean[] combine(boolean newMember, boolean... args)
	{
		if( args == null ) 
		{
			boolean[] a = {newMember};
			return a;
		}
		boolean[] a = new boolean[args.length + 1];
		int i = 0;
		for(boolean member : args)
			a[i++] = member;
		a[i] = newMember;
		return a;
	}
	
	/**
	 * The function of truth table must be defined here. You can use above methods
	 * in your function. 
	 * @param args The values of the variables in function
	 * @return The output of function for values "args"
	 */
	public boolean f(boolean... args)
	{
		return false;
	}

}
