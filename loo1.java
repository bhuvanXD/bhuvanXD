import java.util.Scanner;

class loo1
{
	public static void main(String args[])
	{
		int i;
		int ar[]=new int[9]
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n");
		for(i=0;i<9;i++)
		{
			if(i%2==0)
			System.out.println(" "+ar[i]);
		}
	}
}

	