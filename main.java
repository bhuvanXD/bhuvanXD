import java.util.Scanner;
public class main
{
	//int b (this is instance variable that can be used in all the methods except the main method)
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		int ba,ht,ch;
		
		main obj=new main();
		
		System.out.println("Enter 1 for Area of parallelogram,2 for Area of rhombus,3 for trapezium");
		
		ch=sc.nextInt();
		
		switch(ch)
		{
			case 1:
		
			System.out.println("Enter the value of base");
			ba=sc.nextInt();
		
			System.out.println("Enter the value of height");
			ht=sc.nextInt();
		
			obj.aop(ba,ht);
			break;
			
			default:
			System.out.println("wrong choice");
		}
	}
			
		 void aop(int a,int b)
		 {
			 
		 int pg=a*b; //local variable(can be used only within the method it is declared in)
		 
		 System.out.println("Area of p is"+pg);
		 
		 }
}
		
		
	

			
		
		
		