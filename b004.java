import java.util.Scanner;

class b004
{
	public static void main(String args[])
	{
		int f,c,ch;
		double temp=0.0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the type of conversion 1[F to c] 2[C to f] ");
		ch=sc.nextInt();
		
		
		
		switch (ch)
		{
			case '1':
						System.out.println("Enter the value for F");
						f=sc.nextInt();
						temp=(5/9)*(f-32);
						break;
			
			case '2':
						System.out.println("Enter the value for C");
						c=sc.nextInt();
						temp=(c*9/5)+32;
						break;
			
			default:
						System.out.println("Invalid choice");
		}
		
						System.out.println("Temperature is:"+temp);
	}					
}		