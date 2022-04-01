import java.util.Scanner;

class b002
{
	public static void main(String args[])
	{
		int cp,sp,pr,lo;
		double lop=0.0,prp=0.0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the cost price");
		cp=sc.nextInt();
		System.out.println("Enter the selling price");
		sp=sc.nextInt();
		if(sp>cp)
		{
			pr=sp-cp;
			prp=(pr/cp)*100;
			System.out.println("Profit is:"+pr);
		    System.out.println("Profit percentage is:"+prp);
		}
		else if(cp>sp)
		{
			lo=cp-sp;
			lop=(lo/cp)*100;
			System.out.println("Loss is:"+lo);
		    System.out.println("Loss percentage is:"+lop);
		}
		else
		{
			System.out.println("Neither profit nor loss");
		}
	}
}
		
		
		