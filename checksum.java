// TO IMPLEMENT CHECKSUM ERROR DETECTION MECHANISM.

import java.util.*;
class checksum
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the no of bit in array ");
int n=sc.nextInt();
int arr[]=new int[n];
System.out.println("Enter bits in array: ");
for(int i=0;i<n;i++)
{
arr[i]=sc.nextInt();
}
int arr1[]=new int[n/2];
int arr2[]=new int[n/2];
int div=n/2;
for(int i=0;i<div;i++)
{
arr1[i]=arr[i];
}
for(int i=0;i<div;i++)
{
arr2[i]=arr[i+div];
}
int arr3[]=new int[div];
for(int i=0;i<div;i++)
{
arr3[i]=arr1[i]^arr2[i];
}
System.out.println("Bits after addition are:");
for(int i=0;i<div;i++)
{
System.out.print(arr3[i]);
}
int arr4[]=new int[div];
for(int i=0;i<div;i++)
{
arr4[i]=arr3[i]^1;
}
System.out.println();
System.out.println("The 1’s compliment:");
for(int i=0;i<div;i++)
{
System.out.print(arr4[i]);
}
int arr5[]=new int[div];
for(int i=0;i<div;i++)
{
arr5[i]=arr3[i]^arr4[i];
}
System.out.println();
System.out.println(" Addition:");
for(int i=0;i<div;i++)
{
System.out.print(arr5[i]);
}

for(int i=0;i<div;i++)
{
arr5[i]=arr5[i]^1;
}
System.out.println();
System.out.println("The final output is:");
for(int i=0;i<div;i++)
{
System.out.print(arr5[i]);
}
}
}
