package com.dnapass.java.training.day4;

import java.util.Scanner;
public class ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] array1=new int[10];
		
		for(int i=0;i<10;i++)
		{
			System.out.print("Enter Element "+(i+1)+" :");
			array1[i]=sc.nextInt();
		}
		System.out.println("Element to be found :");
		int flag=0,find=sc.nextInt();
		for(int i=0;i<10;i++) {
			if(find==array1[i])
			{
				flag=1;
				break;		
			}
		}
		if(flag==1)
			System.out.println(find+" is found");
		else
			System.out.println(find+" not found");
	}
	

}
//arraysort
package com.dnapass.java.training.day4;

import java.util.*;
public class ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] array1=new int[10];
		for(int i=0;i<10;i++)
		{
			System.out.print("Enter Element "+(i+1)+" :");
			array1[i]=sc.nextInt();
		}
		Arrays.sort(array1);
		for(int i:array1) {
			System.out.println(i);
		}
	}

}
//palindrome
package com.dnapass.java.training.day4;
import java.util.Scanner;

public class PalindromeOrNot {
	


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the string :");
			String str=sc.next();
			if(str.length()%2==0)
			{
				checkPalindrome(str.substring(0,str.length()/2),str.substring((str.length()/2),str.length()));
				//System.out.println(str.length()/2);
			}
			else {
				checkPalindrome(str.substring(0,str.length()/2),str.substring((str.length()/2)+1,str.length()));
			}
		}
		private static void checkPalindrome(String str1,String str2)
		{
			System.out.println(str1+" "+str2);
			StringBuilder sb=new StringBuilder(str2);  
		    sb.reverse();
		    if(str1.contentEquals(sb)) {
		    	System.out.println("string is palindrome");
		    }
		    else {
		    	System.out.println("string is not a palindrome");
		    }
		}
}
	


//pangrams
package com.dnapass.java.training.day4;

import java.util.Scanner;

public class Pangrams {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		String s;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string :");
		String str=sc.nextLine().replace(" ", "").toLowerCase();
//		for(String s:str) {
//			System.out.println(s);
//		}
		char[] alphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<alphabets.length;j++)
			{
				if((str.charAt(i))==(alphabets[j])) {
					alphabets[j]= 0;
					count++;
				}
			}
		}

		if(count==26) {
			System.out.println("Pangram");
		}
		else{
				System.out.println("not Pangram");
		}
	}

}
//replacechar
package com.dnapass.java.training.day4;

import java.util.Scanner;

public class ReplaceCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string :");
		String str=sc.nextLine();
		System.out.println("\'d\' is replaced with \'h\'\n"+str.replace('d', 'h'));
	}

}

//stringmodi
package com.dnapass.java.training.day4;

import java.util.Scanner;

public class StringModification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string :");
		String str = sc.next();
		if (str.length() < 100) {
			System.out.println(getString(str.toLowerCase()));
		} else {
			System.out.println("String length should be within 100.");
		}
	}

	private static String getString(String Str) {
		StringBuilder sb=new StringBuilder(Str);
		if (sb.charAt(0) != 'k') {
			sb.deleteCharAt(0);
			if (sb.charAt(0) != 'b') {
				sb.deleteCharAt(0);
			} 
		} 
		else {
			if (sb.charAt(1) != 'b') {
				sb.deleteCharAt(1);
			} 
		}
		//System.out.println((sb.charAt(0) != 'k')?( (sb.charAt(0) != 'b') ? sb.delete(0,1) :(sb.deleteCharAt(0))):(sb.charAt(1) != 'b')?sb.deleteCharAt(1):sb);
		return sb.toString();
	}
}
//sundtring
package com.dnapass.java.training.day4;

import java.util.Scanner;

public class ReplaceCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string :");
		String str=sc.nextLine();
		System.out.println("\'d\' is replaced with \'h\'\n"+str.replace('d', 'h'));
	}

}

//tolower
package com.dnapass.java.training.day4;

import java.util.Scanner;

public class ToLower {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string :");
		String str=sc.nextLine();
		System.out.println(str.toLowerCase());
	
	}


}
