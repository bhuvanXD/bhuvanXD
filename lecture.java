import java.util.Scanner;
class lecture
{
	public static void main(String args[])
	{
		char ch;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a character");
		ch=sc.next().charAt(0);
		int x=ch;
		System.out.println("ASCII VALUE OF YOUR CHARACTER IS:"+x);
	}
}

