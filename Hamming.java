//Hamming code exp2

import java.util.*;

class Hamming
{
	static int i;
	
	static void code_gen()
	{	
		Scanner sc=new Scanner(System.in);
		int data[]=new int[8];
		
		System.out.println("Enter the length of data(maximum 4):");
		int n=sc.nextInt();
		int temp[]=new int[8];
		System.out.println("Enter data bits");
		for(i=n;i>=1;i--)
			temp[i]=sc.nextInt();

		int p=0,j=1;
		for(i=1;i<8;i++)
		{

			if(i==Math.pow(2,p))
				p++;

			else
			{
				data[i]=temp[j];
				j++;
			}
		}
				
		data[1]=(data[3]+data[5]+data[7])%2;
		data[2]=(data[3]+data[6]+data[7])%2;
		data[4]=(data[5]+data[6]+data[7])%2;

		System.out.println("Generated code is:\n");
		for(i=7;i>=1;i--)
			System.out.print(data[i]);
		System.out.println("\n");
	}

	static void error()
	{
		Scanner sc=new Scanner(System.in);
		int code[]=new int[8];

		System.out.println("Enter the length of data");
		int l=sc.nextInt();

		System.out.println("Enter code:");
		for(i=l;i>=1;i--)		
			code[i]=sc.nextInt();

		int p1=(code[1]+code[3]+code[5]+code[7])%2;
		int p2=(code[2]+code[3]+code[6]+code[7])%2;
		int p4=(code[4]+code[5]+code[6]+code[7])%2;
		
		if(p1>0)
			p1=1;

		if(p2>0)
			p2=2;

		if(p4>0)
			p4=4;

		int p=p1+p2+p4;
		if(p>0)
		{
			System.out.println("Error found at position "+p);
			if(code[p]==0)
				code[p]=1;
			else
				code[p]=0;
		}
		else
			System.out.println("No Error Found!!!");

		System.out.println("Code is:\n");
		for(i=l;i>=1;i--)
			System.out.print(code[i]);
		System.out.println("\n");
	}
}

class Exp02
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Code generation");
		Hamming.code_gen();
		System.out.println("Code generation");
		Hamming.error();
		
	}
}

/*OUTPUT:

student@student-SIMBOS:~$ javac Exp02.java
student@student-SIMBOS:~$ java Exp02
Code generation
Enter the length of data(maximum 4):
4
Enter data bits
1 0 0 1
Generated code is:

1001100

Code generation
Enter the length of data
7
Enter code:
1 0 0 1 1 0 1
Error found at position 1
Code is:

1001100
*/
