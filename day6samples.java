package com.dnapass.java.training.day6;

public class A {
	int a = 100;
	public void display() {
	System.out.printf("a in A = %d\n", a);
	}

}
//AA
package com.dnapass.java.training.day6;

public class AA {
	int a = 100;
	// a is declared in private change it to public because OOPExercise 
	//is using a. if declared private,it is visible only within the class.
	public void setA( int value) {
	a = value;
	}

	public int getA() {
	return a;
	}

}
//B
package com.dnapass.java.training.day6;

public class B extends A {
	private int a = 123;
	public void display() {
	System.out.printf("a in B = %d\n", a);
	}
 

}
//C
package com.dnapass.java.training.day6;

public class C extends B {
		private int a = 543;
		public void display() {
		System.out.printf("a in C = %d\n", a);
		}

}
//firstclass
package com.dnapass.java.training.day6;

public class FirstClass {
	int a = 100;
	public FirstClass () {
	System.out.println("in the constructor of class FirstClass: ");
	System.out.println("a = "+a);
	a = 333;
	System.out.println("a = "+a);
	}
	public void setFirstClass( int value) {
	a = value;
	}
	public int getFirstClass() {
	return a;
	}

}
//oopexercise
package com.dnapass.java.training.day6;

public class OOPExercises1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstClass objA = new FirstClass();
		SecondClass objB = new SecondClass();
		System.out.println("in main(): ");
		System.out.println("objA.a = "+objA.getFirstClass());
		System.out.println("objB.b = "+objB.getSecondClass());
		objA.setFirstClass (222);
		objB.setSecondClass (333.33);
		System.out.println("objA.a = "+objA.getFirstClass());
		System.out.println("objB.b = "+objB.getSecondClass());

	}

}

//secondclass
package com.dnapass.java.training.day6;

public class SecondClass {
	double b = 123.45;
	public SecondClass() {
	System.out.println("-----in the constructor of class B: ");
	System.out.println("b = "+b);
	b = 3.14159;
	System.out.println("b = "+b);
	}
	public void setSecondClass( double value) {
	b = value;
	}
	public double getSecondClass() {
	return b;
	}

}
