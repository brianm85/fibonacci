import java.math.BigInteger;
import java.util.*;

public class f 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter how many fibonacci terms you want =");
		double number = sc.nextDouble();
		sc.close();

		double sumofdigits = 0;// Declare a sum of digits
		double sumOfPrimes = 0; //Declare a sum of primes
		double[] array= new double[(int) number]; // Declare an array

           // Get the fibonacci numbers and add the primes
		for(int i=0; i < number; i++) // Fill the array
		{
			array[i]=fibonacci2(i+1); // Call the method fibonacci and store it in an array
			System.out.print(array[i] + ","); // print out the fibonacci numbers
			
			if(isPrime(array[i])) sumOfPrimes+=array[i]; // Find the primes and add them together. call from method isPrime
		}
		System.out.println(); // go to next line when printing
		System.out.println("These primes sum to = " + sumOfPrimes); //Print the sum of the primes
        
		// Seperate the digits
		while(sumOfPrimes> 0 ) // It has to be greater than 0 so we don't get minus numbers or error
		{
			sumofdigits += sumOfPrimes % 10;// This will take out the second number and store it into sumofdigits and will repeat itself and add them
			sumOfPrimes/=10; // This will get rid of the second number altogether so when it loops it will only have one number left. 

		}
		System.out.println("The digits add up to " + sumofdigits); // Print out the digits added together
        
		//Longest colletz sequence
		long [] arr = new long [3000];
		int answer = 0;
		long longest = 0,base = 0;

		for(int i = 2; i < sumofdigits;i++)
		{
			base = getSteps(i, arr);
			if(base> longest)
			{
				longest = base;
				answer = i;             
			}
		}
		System.out.println("Longest colletz sequence occurs at = " + answer);
		
		//Lowest common multiple
		int min = 0;// Declare min
		long max = 0;//Declare max

		if( number > answer) //Find out the smaller and larger number
		{
			max = (long) number; // Declare
			min = answer; // Declare

		}
		else // If it is the other way
		{

			min = (int) number; //Declare
			max = answer; //Declare
		}
		
		for(int i = min; i<= number*answer; i += min) // Check all the multiples
		{
			if(i % max == 0) //The maximum common multiple will be both numbers multiplied by each other so it will check multiples before then
			{
				System.out.println("The lowest common multiple of " + number + " and " + answer + " = " + i); break;
			}
		}
	}

	public static long getSteps(long n, long [] a) 
	{
		long count = 1,num = n;

		while(num != 1)
		{

			if(num < n)
			{
				a[(int)n] = (count - 1) + a[(int)num];
				return a[(int)n];
			}
			if(num % 2 == 0)
			{
				num /= 2;
			}
			else 
			{
				num = (num * 3) + 1;
			}

			count++;
		}

		a[(int)n] = count;
		return (long)count;     
	}

	
		public static boolean isPrime(double array) //isPrime method being called
		{
			if(array%2==0) 
				return false; // Set all even numbers to false
			
			for(int i = 3; i*i <= array; i+=2) //Check multiples of odds
			{
				if(array % i == 0)// If there is a multiple 
					return false; //Not a prime
			}
			return true; //Return prime number

		}
		public static int fibonacci2(int number)
		{
			if(number == 1 || number == 2)
			{
				return 1;
			}
			int num1=1, num2=1, Result=1;
			for(int i= 3; i <= number; i++) // going from 3 to the number entered
			{
				Result = num1 + num2; //Fibonacci number is sum of previous two Fibonacci number
				num1 = num2; //The second number added becomes the first number
				num2 = Result; // The result becomes the second number

			}
			return Result; //Return the fibonacci number

		}   
	}
