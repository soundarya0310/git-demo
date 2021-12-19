package com.dnapass.java.training.day5;


	public interface AdvancedArithmetic {
		static int divisor_sum(int n) {
			return 0;
		}
	}

//card
package com.dnapass.java.training.day5;

 public abstract class Card {
	  protected String holderName;
	  protected String cardNumber;
	  protected String expiryDate;
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public   Card(String holderName, String cardNumber, String expiryDate)
	{
	    this.holderName=holderName;
	    this.cardNumber=cardNumber;
	    this.expiryDate=expiryDate;
	}


	}
	//paybackcard
package com.dnapass.java.training.day5;

public class PaybackCard extends Card {
private	 Integer pointsEarned;
private	 Double totalAmount;
public Integer getPointsEarned() {
	return pointsEarned;
}
public void setPointsEarned(Integer pointsEarned) {
	this.pointsEarned = pointsEarned;
}
public Double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(Double totalAmount) {
	this.totalAmount = totalAmount;
}
public PaybackCard(String holderName, String cardNumber, String expiryDate,Integer rating,Integer pointsEarned, Double totalAmount) {
	super(holderName,cardNumber,expiryDate);
	this.pointsEarned=pointsEarned;
	this.totalAmount=totalAmount;
	// TODO Auto-generated constructor stub
}
public void printDescription() {
	System.out.println(getHolderName());
	System.out.println(getCardNumber());
	System.out.println(getExpiryDate());
	System.out.println( "totalamount:" + getTotalAmount()+"|"+"pointsearned:" + getPointsEarned());
}
}

//membershipcard
package com.dnapass.java.training.day5;

public class MembershipCard extends Card {
private	 Integer rating;


public Integer getRating() {
	return rating;
}

public void setRating(Integer rating) {
	this.rating = rating;
}


public  MembershipCard(String holderName, String cardNumber, String expiryDate,Integer rating)
{
    super( holderName, cardNumber,expiryDate);
    this.rating=rating;
}
public void printDescription() {
	
	System.out.println("MembershipDetails\n");
	System.out.println( "rating:" + getRating() );
}
}
//main
package com.dnapass.java.training.day5;

import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Select the card \n 1.PaybackCard\n 2.MembershipCard\n");
		int card=sc.nextInt();
		sc.nextLine();
	    String[] in=new String[3];
		System.out.println("Enter the card Details:\n");
		in=sc.nextLine(). split("\\|");
		
		String a=in[0];
			String b= in[1];
			String c=in[2];
			
			if(card==1)
			{
		      System.out.println("Enter points in card:\n");
		      int n=sc.nextInt();
		      System.out.println("Enter the amount:\n");
		      double h=sc.nextDouble();
		      PaybackCard P=new PaybackCard(a,b,c,n,n, h);
		      
		      P.printDescription();
			} 
			
		      
			else if(card==2)
			{
				System.out.println("Enter Rating:\n");
			      int r=sc.nextInt();
			      MembershipCard M=new MembershipCard(a,b,c,r);
			      M.printDescription();
			}
}
}
//shapes
package com.dnapass.java.training.day5;

public abstract class Shapes {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public Shapes(String name) {
		super();
		this.name = name;
	}

	public abstract double calculateArea();
	public abstract void printArea();
}
//square
package com.dnapass.java.training.day5;

public class Square extends Shapes {
	private int side;

	public int getSide() {
		return side;
	}

	public void setSide(int radius) {
		this.side = radius;
	}

	public Square(String name, int side) {
		super(name);
		this.setSide(side);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return Math.pow(this.getSide(), 2);
	}

	@Override
	public void printArea() {
		// TODO Auto-generated method stub
		System.out.format("Area of "+super.getName()+" is %.2f\n",this.calculateArea());		
	}
}
//circle
package com.dnapass.java.training.day5;

import java.util.Scanner;

public class Circle extends Shapes {

	private int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Circle(String name, int radius) {
		super(name);
		this.setRadius(radius);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(this.getRadius(), 2);
	}
	@Override
	public void printArea() {
		System.out.format("Area of "+super.getName()+" is %.2f\n",this.calculateArea());
	}

}
//rectangle
package com.dnapass.java.training.day5;

public class Rectangle extends Shapes {
	private int length;
	private int breadth;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public Rectangle(String name, int length, int breadth) {
		super(name);
		this.setBreadth(breadth);
		this.setLength(length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return this.getLength() * this.getBreadth();
	}

	@Override
	public void printArea() {
		// TODO Auto-generated method stub
		System.out.format("Area of "+super.getName()+" is %.2f\n",this.calculateArea());
	}
}
//maintest
package com.dnapass.java.training.day5;

import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Shape :");
		String shape=sc.nextLine();
		System.out.println("Enter Radius :");
		int value=sc.nextInt();
		
		Circle c1 = new Circle(shape,value);
		c1.printArea();
		Square s1 = new Square("square1",10);
		s1.printArea();
		Rectangle r1 = new Rectangle("rectangle",7,8);
		r1.printArea();
}

}

