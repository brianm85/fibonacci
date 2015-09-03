
import java.util.*;

public class fibonacci 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter how many fibonacci terms you want =");
		int number = sc.nextInt();
		sc.close();
		int[] array= new int[number];
		int[] array2=new int[array.length];

		//System.out.print("Fibonacci series upto " + number +" numbers : "); //printing Fibonacci series upto number
		for(int i=1; i<number; i++)
		{
			array[i]=fibonacci2(i);
			//System.out.print(array[i]);
			array2[i]=array[i];
			System.out.println(array2[i]);
		}


	} 

	public static int fibonacci2(int number){
		if(number == 1 || number == 2){
			return 1;
		}
		int num1=1, num2=1, Result=1;
		for(int i= 3; i<= number; i++){
			Result = num1 + num2;     //Fibonacci number is sum of previous two Fibonacci number
			num1 = num2;
			num2 = Result;

		}
		return Result; 

	}   
	public static int[] prime(int[]arr)
	{
		for(int i=0; i<=arr.length;i++)
		{
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					break;
				}
				else
				{
					i=arr[i];
				}
			}
		}
		return arr;
		
	}

}

