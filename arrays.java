package com.dnapass.java.training.arrays.sample;

import java.util.Scanner;

public class ArrayPrint {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array :");
		int arrayLen=sc.nextInt();
		int[] array1=new int[arrayLen];
		for(int i=0;i<arrayLen;i++)
		{
			System.out.print("Enter Element "+(i+1)+" :");
			array1[i]=sc.nextInt();
		}
		//print array using for loop
		for(int i:array1)
		{
			System.out.println(i);
		}

	}
}
//findelement
package com.dnapass.java.training.arrays.sample;

import java.util.Scanner;

public class FindElement {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array :");
		int find,arrayLen=sc.nextInt();
		int[] array1=new int[arrayLen];
		for(int i=0;i<arrayLen;i++)
		{
			System.out.print("Enter Element "+(i+1)+" :");
			array1[i]=sc.nextInt();
		}
		System.out.print("Enter Element to find :");
		find=sc.nextInt();
		//Check element in array using for loop
		block1:for(int i=0;i<arrayLen;i++)
		{
			if(array1[i]==find)
			{
				System.out.println("Element found");
				break block1;
			}

		}
	}

}
//findindex
package com.dnapass.java.training.arrays.sample;

import java.util.Scanner;

public class FindIndex {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array :");
		int find,arrayLen=sc.nextInt();
		int[] array1=new int[arrayLen];
		for(int i=0;i<arrayLen;i++)
		{
			System.out.print("Enter Element "+(i+1)+" :");
			array1[i]=sc.nextInt();
		}
		System.out.print("Enter Element to find index :");
		find=sc.nextInt();
		//Check element in array using for loop
		block1:for(int i=0;i<arrayLen;i++)
		{
			if(array1[i]==find)
			{
				System.out.println("Element Index :"+i);
				//break block1;
			}

		}
	}

}
//insert
package com.dnapass.java.training.arrays.sample;

import java.util.Scanner;

public class Insert {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array :");
		int  find,insert, arrayLen = sc.nextInt();
		int[] array1 = new int[arrayLen], array2 = new int[arrayLen];
		for (int i = 0; i < arrayLen; i++) {
			System.out.print("Enter Element " + (i + 1) + " :");
			array1[i] = sc.nextInt();
		}
		System.out.print("Enter Position to Insert :");
		find = sc.nextInt();
		System.out.print("Enter Element to Insert :");
		insert = sc.nextInt();
		
		for(int i=0;i<arrayLen;i++)
		{
			if(i==find-1)
			{
				System.out.println("Element Replaced :"+i);
				array1[i]=insert;
			}

		}
		for(int i:array1)
		{
			System.out.print(i+"\t");
		}
	}

}
//min2max2
package com.dnapass.java.training.arrays.sample;

import java.util.Scanner;

public class Min2Max2 {
	public static void main(String... args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array :");
		int max1=0,min1=999,max2=0,min2=999,arrayLen=sc.nextInt();
		int[] array1=new int[arrayLen];
		for(int i=0;i<arrayLen;i++)
		{
			System.out.print("Enter Element "+(i+1)+" :");
			array1[i]=sc.nextInt();
		}
		for(int i=0;i<arrayLen;i++)
		{
			if(max1<array1[i])
				max1=array1[i];
			if(min1>array1[i])
				min1=array1[i];
		}
		System.out.println("min :"+min1+"\tmax :"+max1);
		
		for(int i=0;i<arrayLen;i++)
		{
			if(max2<array1[i] && max1>array1[i])
				max2=array1[i];
			if(min2>array1[i] && min1<array1[i])
				min2=array1[i];
		}
		System.out.println("min :"+min2+"\tmax :"+max2);
	}

}
//minmax
package com.dnapass.java.training.arrays.sample;

import java.util.Scanner;

public class MinMax {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array :");
		int max=0,min=999,arrayLen=sc.nextInt();
		int[] array1=new int[arrayLen];
		for(int i=0;i<arrayLen;i++)
		{
			System.out.print("Enter Element "+(i+1)+" :");
			array1[i]=sc.nextInt();
		}
		for(int i=0;i<arrayLen;i++)
		{
			if(max<array1[i])
				max=array1[i];
			if(min>array1[i])
				min=array1[i];
		}
		System.out.println("min :"+min+"\tmax :"+max);
	}

}
//remove
package com.dnapass.java.training.arrays.sample;

import java.util.Scanner;

public class Remove {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array :");
		int j = 0, count = 0, find, arrayLen = sc.nextInt();
		int[] array1 = new int[arrayLen], array2 = new int[arrayLen];
		for (int i = 0; i < arrayLen; i++) {
			System.out.print("Enter Element " + (i + 1) + " :");
			array1[i] = sc.nextInt();
		}
		System.out.print("Enter Element to Remove :");
		find = sc.nextInt();
		// Check element in array using for loop
		for (int i = 0; i < arrayLen; i++) {
			if (array1[i] != find) {
				array2[j] = array1[i];
				j++;
			}
		}
		if (j == 0)
			System.out.println("Array Empty");
		else {
			for (int i = 0; i < j; i++) {
				System.out.println(array2[i]);
			}
		}
	}
}

//removemethod
package com.dnapass.java.training.arrays.sample;

import java.util.Scanner;

public class RemoveMethod {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array :");
		int find, arrayLen = sc.nextInt();
		int[] array1 = new int[arrayLen];
		for (int i = 0; i < arrayLen; i++) {
			System.out.print("Enter Element " + (i + 1) + " :");
			array1[i] = sc.nextInt();
		}
		System.out.print("Enter Element to find :");
		find = sc.nextInt();
		
		// Check element in array using for loop
		for (int i = 0; i < arrayLen; i++) {
			if (array1[i] == find) {
				System.out.println( "Element "+find+" found");
				removeElement(i, array1,arrayLen);
				array1[arrayLen - 1] = 0;
				arrayLen--;
				i--;
			}
		}
		
		//print array
		if (arrayLen == 0) {
			System.out.println("Array Empty");
		} else {
			for (int i = 0; i < arrayLen; i++) {
				System.out.print(array1[i] + "\t");
			}
		}

	}

	private static void removeElement(int index, int[] array1,int arrayLen) {
		if (index == arrayLen - 1) {
			System.out.println(" 0 ");
		} else {
			for (int i = index; i < arrayLen; i++) {
				array1[i] = array1[i + 1];
			}
		}
	}


}
//sumaverage
package com.dnapass.java.training.arrays.sample;

import java.util.Scanner;

public class SumAverage {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter length of array :");
			int sum=0,arrayLen=sc.nextInt();
			int[] array1=new int[arrayLen];
			for(int i=0;i<arrayLen;i++)
			{
				System.out.print("Enter Element "+(i+1)+" :");
				array1[i]=sc.nextInt();
			}
			for(int i:array1)
			{
				sum+=i;
			}
			System.out.print("SUM :"+sum+"\nAverage :"+sum/(double)arrayLen);
		}
}
