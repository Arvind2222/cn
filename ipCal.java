
// TO FIND OUT CLASS OF A GIVEN IP ADDRESS, SUBNET MASK AND
//      FIRST AND LAST IP ADDRESS OF THAT BLOCK.


// IP CLASS
import java.util.*;
import java.io.*;

class ipCal
{
	public static int ip[] = new int[4];
	public static int ipBin[] = new int[32];
	public static int  prefix,s,i,j;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
				System.out.print("Enter your IP address: ");
		for(i=3; i>=0; i--)
			ip[i] = sc.nextInt();
		System.out.print("Enter the masking prefix: ");
		prefix = sc.nextInt();
		s = 32 - prefix;
		System.out.println("\nEntered IPaddress is:");
			binAddr();
			disp();
		System.out.println("\nThe starting address is:");
			startAddr();
			disp();
		System.out.println("\nThe ending address is:");
			endAddr();
			disp();
		System.out.print("\nClass of IP address: ");
			ipClass();
	}
		
	public static void binAddr()
	{
		int top=32,curr;
		int temp[] = new int[8];
		for(i=3; i>=0; i--)
		{
			curr = ip[i];
			for(j=0; j<8; j++)
			{
				if(curr > 0)
				{
					temp[j] = curr%2;
					curr = curr/2;
				}
				else
					temp[j] = 0;
			}		
			for(j=7; j>=0; j--)
				ipBin[--top] = temp[j];
		}
	}

	public static void disp()
	{
		System.out.println(ip[3]+"."+ip[2]+"."+ip[1]+"."+ip[0]);
		for(j=31;j>=0;j--)
		{
			System.out.print(ipBin[j]);
			if(j%8 ==0 && j != 0)
				System.out.print(".");
		}		
		System.out.println(); 
	}
	
	
	public static void decAddr()
	{
		double temp,top;
		for(i=3;i>=0;i--)
		{
			ip[i]=0;
			top = i*8;
			for( j=(int)top ; j<=top+7; j++)
			{
				temp = ipBin[j] * Math.pow(2,(j-top));
				ip[i] = ip[i]+ (int)temp;
			}
		}
		
	}	
	
	public static void startAddr()
	{
		for(i=0;i<s;i++)
			ipBin[i]=0;
		decAddr(); 
	}	 
	
	
	public static void endAddr()
	{
		for(i=0;i<s;i++)
			ipBin[i]=1;
		decAddr(); 
	}	

	public static void ipClass()
	{
		if(ipBin[31] == 0)
			System.out.println(" Class A");
		else if(ipBin[30] == 0)
			System.out.println(" Class B");	
		else if(ipBin[29] == 0)
			System.out.println(" Class C");	
		else if(ipBin[28] == 0)
			System.out.println(" Class D");	
		else
			System.out.println(" Class E");	
	}
}	

// Output:


