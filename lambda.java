package com.dnapass.java.training.lambda;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.dnapass.java.training.collections.DataLoader;
import com.dnapass.java.training.collections.Transaction;

import static java.util.Comparator.comparing;

interface Something{
	public String doit(Integer i);
	//public String doit1(Integer i);
}

interface HelloFunctionInterface {
public String sayHello();
//public String doit(Integer i);
}

public class LambdaDemo {
public static void main(String args[]) {
	HelloFunctionInterface msg=()->{
		return "Hello";
	};
	System.out.println(msg.sayHello());
	
	LambdaDemo lambdaDemo = new LambdaDemo();
	lambdaDemo.demo();
	
}

private void demo() {
	//without lambda
	Runnable r= new Runnable() {
		public void run(){
			System.out.println("Hello World!.. without lambda");
		}
	};
	r.run();
	//with lambda
	Runnable r1 = ()->{System.out.println("hello World with lambda");};
	r1.run();
	
	ArrayList <Integer> numbers = new ArrayList<Integer>();
	numbers.add(3);
	numbers.add(5);
	numbers.add(7);
	numbers.add(1);
	numbers.add(0);
	numbers.forEach(n->{System.out.print(n+" ");});
	System.out.print("\n");
	Consumer<Integer> method = m -> {System.out.print(m+" ");};
	numbers.forEach(method);
	//implicit return
	Comparator<String> c1 = (String lhs , String rhs) -> lhs.compareTo(rhs);
	int result =c1.compare("Hello", "Hello");
	int result1 =c1.compare("Hello", "World");
	System.out.println("\n"+result+"\n"+result1);
	// with return
	Comparator<String> c2 =(String lhs , String rhs)->{return lhs.compareTo(rhs);};
	int result2 =c2.compare("Hello", "Hello");
	int result3 =c2.compare("Hello", "World");
	System.out.println(result2+"\n"+result3);
	//type inference type not need to be declared
	Comparator<String> c3 =(lhs , rhs)->{return lhs.compareTo(rhs);};
	int result4 =c3.compare("Hello", "Hello");
	int result5 =c3.compare("Hello", "World");
	System.out.println(result4+"\n"+result5);
	
	LambdaDemo lambdaDemo = new LambdaDemo();
	List<Transaction> transactions= DataLoader.newTransactions();
	
	Comparator<Transaction> c4 = new Comparator<Transaction>() {

		@Override
		public int compare(Transaction o1, Transaction o2) {
			// TODO Auto-generated method stub
			return o1.getId().compareTo(o2.getId());
		}
	};
	Comparator<Transaction> c5 = new Comparator<Transaction>() {

		@Override
		public int compare(Transaction o1, Transaction o2) {
			// TODO Auto-generated method stub
			return o1.getAmount().compareTo(o2.getAmount());
		}
	};
	
	Collections.sort(transactions,c4);
	transactions.forEach(n->System.out.println(n.getId()+" "+n.getType()+" "+n.getAmount()+" "+n.getCity()+" "+n.getCurrency()));
	
	//lambda
	Collections.sort(transactions,(lhs,rhs)->lhs.getCity().compareTo(rhs.getCity()));
	transactions.forEach(n->System.out.println(n.getId()+" "+n.getType()+" "+n.getAmount()+" "+n.getCity()+" "+n.getCurrency()));

	Collections.sort(transactions,comparing(Transaction::getId));
	transactions.forEach(n->System.out.println(n.getId()+" "+n.getType()+" "+n.getAmount()+" "+n.getCity()+" "+n.getCurrency()));

	//static method
	transactions.stream().map(t->t.getAmount()).forEach(amt->System.out.println(String.valueOf(amt)));
	transactions.stream().map(t->t.getAmount()).forEach(String::valueOf);
	
	transactions.stream().sorted((a,b)->c4.compare(a, b));
	transactions.forEach(n->System.out.println(n.getId()+" "+n.getType()+" "+n.getAmount()+" "+n.getCity()+" "+n.getCurrency()));

	transactions.stream().sorted(c5::compare);
	transactions.forEach(n->System.out.println(n.getId()+" "+n.getType()+" "+n.getAmount()+" "+n.getCity()+" "+n.getCurrency()));

	transactions.stream().map(t->t.getAmount()).sorted((a,b)->a.compareTo(b));
	transactions.stream().map(t->t.getAmount()).sorted(Double::compareTo);
	
	
	Supplier<Transaction> t1=Transaction::new;
	System.out.println(t1.get());
	}
}

//lambdaexpression

package com.dnapass.java.training.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpressionDemo {
	@FunctionalInterface
	interface CheckPeople{
		boolean test(People p);
	}
	
	
	public static void printPeopleOlderThan(List<People> roster,int age)
	{
		for(People p: roster) {
			if(p.getAge()>=age) {
				p.printPeople();
			}
		}
	}
	
	public static void printPeopleWithinAgeRange(List<People> roster,int low, int high) {
		for(People p: roster) {
			if(low <= p.getAge() && p.getAge()<high) {
				p.printPeople();
			}
		}
	}
	
	public static void printPeople(List<People> roster,CheckPeople tester) {
		for(People p: roster) {
			if(tester.test(p)) {
				p.printPeople();
			}
		}
	}
	
	public static void printPeopleWithPredicate(List<People> roster,Predicate<People> tester) {
		for(People p: roster) {
			if(tester.test(p)) {
				p.printPeople();
			}
		}
	}
	
	
	public static void processPeople(List<People> roster,Predicate<People> tester,Consumer<People> block) {
		for(People p: roster) {
			if(tester.test(p)) {
				p.printPeople();
			}
		}
	}
	
	public static void processPeopleWithFunction(List<People> roster,Predicate<People> tester,Function<People,String> mapper,Consumer<People> block) {
		for(People p: roster) {
			if(tester.test(p)) {
				p.printPeople();
			}
		}
	}
	
	public static<X,Y> void processElements(Iterable<X> source,Predicate<X> tester,Function<X,Y> mapper,Consumer<Y> block) {
		for(X p: source) {
			if(tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<People> roster =People.createRoster();
		
		for(People p :roster) {
			p.printPeople();
		}
		
		//create method that search for people that match one characteristics
		System.out.println("People older than 20: ");
		printPeopleOlderThan(roster,20);
		System.out.println();
		
		//create more generalized search method
		System.out.println("People between the ages of 14 and 30: ");
		printPeopleWithinAgeRange(roster,14,30);
		System.out.println();
		
		//specify search criteria code in a local Class
		System.out.println("People Who are eligible for selective Service: ");
		class CheckPeopleEligibleForSelectiveService implements CheckPeople{
			public boolean test(People p) {
				return p.getGender()==People.Sex.MALE && p.getAge() >= 10 && p.getAge()<=25;
			}
		}
		
		printPeople(roster,new CheckPeopleEligibleForSelectiveService());
		System.out.println();
		
		//specify search criteria code in a Anonymous class
		System.out.println();
		
		printPeople(roster,new CheckPeople()
				{
				public boolean test(People p) {
					return p.getGender()==People.Sex.MALE && p.getAge()<=25;				
					}
				});
		printPeople(roster,new CheckPeopleEligibleForSelectiveService());
		
		System.out.println();
		
		//specify search criteria code in a lambda Expression
		System.out.println("People who are eligible for selective service "+"(lambda expression) : ");
		
		CheckPeople tester =(People p)->p.getGender() == People.Sex.MALE && p.getAge() >= 18 && p.getAge()<=25;
		printPeople(roster,tester);
		System.out.println();
		
		//Using lambda Expression throughout your Application
		System.out.println("People who are eligible for selective Service:"+"(with predicate and consumer parameter):");
		Consumer<People> block = p->p.printPeople();
		processPeople(roster,p -> p.getGender()== People.Sex.MALE &&p.getAge() >= 18 && p.getAge()<=25,block);
		System.out.println();
		//second example
		System.out.println("People who are eligible for selective Service:"+"(with predicate and consumer predicate):");
		Consumer<People> block1 = p->p.printPeople();
		processPeople(roster,p -> p.getGender()== People.Sex.MALE &&p.getAge() >= 18 && p.getAge()<=25,block1);
		System.out.println();
		
		//use generics more extensively
		System.out.println("People who are eligible for selective Service:"+"(with predicate and consumer predicate):");
		processElements(roster,p->p.getGender() == People.Sex.MALE && p.getAge() >= 18 && p.getAge()<=25,p->p.getEmailAddress(),email -> System.out.println(email));
		System.out.println();
		
		
	}
	


}
//method reference
package com.dnapass.java.training.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceDemo {

	@FunctionalInterface
	interface MyInterface{
		void display();
	}
	static class Example{
		public void myMethod() {
			System.out.println("Instance method");
		}
	}

	@FunctionalInterface
	interface BiFunction<T,U,V>{
		void apply();
	}
	static class Multiplication{
		public static int multiply(int a,int b) {
			return a+b;
		}
	}
	@FunctionalInterface
	interface HelloInterface{
		Hello display(String say);
	}
	static class Hello{
		public Hello(String say) {
			System.out.println(say);
		}
	}
	
	private static Collection<Bicycle> createBicyclesList(){
		return null;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Example obj = new Example();
		MyInterface ref = obj::myMethod;
		ref.display();
		
		BicycleComparator bikeFrameSizeComparator = new BicycleComparator();
		//createBicyclesList().stream().sorted((a,b)-> bikeFrameSizeComparator.compare(a,b));	}
		createBicyclesList().stream().sorted(bikeFrameSizeComparator::compare);

		// method ref to a static method of class
		 
//		BiFunction<Integer,Integer,Integer> product = Multiplication::multiply;
//		int pr =product.apply(5,6);
//		System.out.println("Product of given numbers is: "+pr);
		
		//method ref to an instance method of an arbitary obj of particular type
		String[] stringArray = {"Steve","Rick","Adithya","Negam","Lucy","Sansa","Jon"};
		
		// method ref  to an instance method of an arbitary obj of a particular type
		
		Arrays.sort(stringArray,String::compareToIgnoreCase);
		for(String str:stringArray) {
			System.out.println(str);
		}
		
		List<Integer> numbers =Arrays.asList(5,30,50,24,40,2,9,18);
		numbers.sort((a,b)->a.compareTo(b));
		numbers.sort(Integer::compareTo);
		
		// methos ref to a constructor
		
		HelloInterface ref1=Hello::new;
		ref1.display("hello");
		
	}
}
class Bicycle{
	private String brand;
	private Integer frameSize;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getFrameSize() {
		return frameSize;
	}
	public void setFrameSize(Integer frameSize) {
		this.frameSize = frameSize;
	}
	
	
}

class BicycleComparator implements Comparator<Bicycle>{

	@Override
	public int compare(Bicycle o1, Bicycle o2) {
		// TODO Auto-generated method stub
		return o1.getFrameSize().compareTo(o2.getFrameSize());
	}
}
	

//people
package com.dnapass.java.training.lambda;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class People {

	public enum Sex{
		MALE,FEMALE
	}
	
	String name;
	LocalDate birthdate;
	Sex gender;
	String emailAddress;
	
	People(String nameArg,LocalDate birthdayArg,Sex genderArg,String emailAddressArg){
		this.name= nameArg;
		this.birthdate=birthdayArg;
		this.gender=genderArg;
		this.emailAddress=emailAddressArg;
	}
	
	public int getAge() {
		return  birthdate.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return	birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public static int compareByAge(People a, People b) {
		return a.birthdate.compareTo(b.birthdate);
	}
	
	public static List<People> createRoster(){
		List<People> roster = new ArrayList<>();
		roster.add(new People("fred",IsoChronology.INSTANCE.date(1980,6,20),People.Sex.MALE,"fred@example.com"));
		roster.add(new People("jane",IsoChronology.INSTANCE.date(1990,7,15),People.Sex.FEMALE,"jane@example.com"));
		roster.add(new People("george",IsoChronology.INSTANCE.date(1901,8,13),People.Sex.MALE,"george@example.com"));
		roster.add(new People("bob",IsoChronology.INSTANCE.date(2000,9,12),People.Sex.MALE,"bob@example.com"));

		return roster;
	}
	
	public String printPeople() {
		return "People [ name = "+name+" bithdate = "+birthdate +" gender = "+gender+" emailAddress = "+emailAddress+"]";
	}
}


