package com.dnapass.java.training.streams;

public class Person {
		protected String firstName;
		protected String lastName;
		protected Integer age;
		public Person(String firstName, String lastName, Integer age) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}

		}

//streamdemo
package com.dnapass.java.training.streams;



import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.dnapass.java.training.collections.DataLoader;
import com.dnapass.java.training.collections.ProductType;
import com.dnapass.java.training.collections.Transaction;



public class StreamDemo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		StreamDemo streamDemo = new StreamDemo();
		streamDemo.demo();

	}

	private void demo() throws IOException {
		// TODO Auto-generated method stub
		Stream<Integer> numbersFromValue = Stream.of(1,2,3,4);
		System.out.println(numbersFromValue);
		
		int[] numbersArray = {1,2,3,4};
		IntStream numbersFromArray =Arrays.stream(numbersArray);
		System.out.println(numbersFromArray);
		
		Stream<String> lines = Files.lines(Paths.get("C:\\Users\\subas\\OneDrive\\Desktop\\sample.txt"),Charset.defaultCharset());
		long numberOfLines = lines.count();
		System.out.println(numberOfLines);
	
		Stream<Integer> intNumbers= Stream.iterate(0, n->n+10);
		intNumbers.limit(5).forEach(System.out::println);
		
		//referencing a stream
		
		Stream<String> stream = Stream.of("a","b","c").filter(element -> element.contains("b"));
		Optional<String> anyElement = stream.findAny();
		//Optional<String> firstElement = stream.findFirst();
		
		List<String> elements = Stream.of("a","b","c").filter(element -> element.contains("b")).collect(Collectors.toList());
		anyElement = elements.stream().findAny();
	//	firstElement = elements.stream().findFirst();
		List<String> list = Arrays.asList("abc1","abc2","abc3");
		Stream stream1 = list.stream().filter(element ->{
			System.out.println("filter() was called");
			return element.contains("2");
		}).map(element ->{
			System.out.println("Map() was called");
			return element.toUpperCase();});
				
		
		Optional<String> string = list.stream().filter(element ->{
			System.out.println("filter() was called");
			return element.contains("2");
		}).map(element ->{
			System.out.println("Map() was called");
			return element.toUpperCase();}).findFirst();
		
		
		long size = list.stream().map(element ->{
			System.out.println("Map() was called");
			return element.substring(0, 3);}).skip(2).count();
		
		size =list.stream().skip(2).map(element ->{
			System.out.println("Map() was called");
			return  element.substring(0, 3);}).count();
		
		
		List<Transaction> transactions = DataLoader.newTransactions();
		
		List<Integer> transactionIds = new ArrayList<>();
		
		List<Transaction> groceryTransactions = new ArrayList<>();
		for(Transaction t:transactions) {
			if(t.getType()==ProductType.GROCERIES) {
				groceryTransactions.add(t);
			}
		}
		Collections.sort(groceryTransactions,new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
				// TODO Auto-generated method stub
				return o1.getAmount().compareTo(o1.getAmount());
			}		
		});
		
		for(Transaction t:groceryTransactions) {
			transactionIds.add(t.getId());
		}
		System.out.println(transactionIds);
	
		transactionIds = transactions.stream().filter(t -> t.getType()==ProductType.GROCERIES).sorted(comparing(Transaction::getAmount).reversed()).map(Transaction::getId).collect(toList());
		
		System.out.println(transactionIds);
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		List<Integer> twoEvenSquare = null;
		twoEvenSquare = numbers.stream().filter(n -> {
			System.out.println("Filtering "+n);
			return n%2==0;
		}).map(n->{
			System.out.println("mapping " + n);
			return n*n;
		}).limit(2).collect(toList());
		
		System.out.println(twoEvenSquare);
		
		
		boolean expensive = transactions.stream().allMatch(t -> t.getAmount()>100);
		System.out.println(expensive);
		
		Optional<Transaction> gtran = transactions.stream().filter(t -> t.getType()==ProductType.GROCERIES).findAny();
		System.out.println(gtran);
		
		transactions.stream().filter(t -> t.getType()==ProductType.GROCERIES).findAny().ifPresent(System.out::println);
		
		List<String> words = Arrays.asList("Oracle","Java","Magazine");
		List<Integer> wordLengths =words.stream().map(String::length).collect(toList());
		System.out.println(wordLengths);
		
		int sum = numbers.stream().reduce(0, (a,b) -> a+b);
		System.out.println(sum);
		
		int product = numbers.stream().reduce(0, (a,b) -> a*b);
		System.out.println(product);
		
		int max = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
		System.out.println(max);
		
		double statementSum = transactions.stream().mapToDouble(Transaction::getAmount).sum();
		System.out.println(statementSum);

		IntStream oddNumbers = IntStream.rangeClosed(10, 30).filter(n -> n%2 ==1);
		System.out.println(oddNumbers);
		
		Stream<String> wordsStream = Stream.of("Java","Magazine","is","the","best");
		
		Map<String,Long> letterToCount = wordsStream.map(w -> w.split("")).flatMap(Arrays::stream).collect(groupingBy(identity(),counting()));
		System.out.println(letterToCount);
		
		String[] arrayOfWords = {"Java abstraction inheritance encapsulation functional","Jjva abstraction inheritance encapsulation functional"};
		Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
		
		streamOfWords.map(line -> line.split("\\s+")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
		
		List<Integer> expensiveTransactionIds =transactions.stream().filter(t -> t.getAmount() >1000).map(Transaction::getId).collect(toList());
		System.out.println(expensiveTransactionIds);
		
		Set<String> cities = transactions.stream().filter(t -> t.getAmount() >1000).map(Transaction::getCity).collect(toSet());
		System.out.println(cities);
		
		cities = transactions.stream().filter(t -> t.getAmount() >1000).map(Transaction::getCity).collect(toCollection(HashSet::new));
		System.out.println(cities);
		
		long howManyTransactions = transactions.stream().collect(counting());
		System.out.println(howManyTransactions);
		
		double totalValue = transactions.stream().collect(summingDouble(Transaction::getAmount));
		System.out.println(totalValue);
		
		Optional<Transaction> highestTransaction = transactions.stream().collect(maxBy(comparing(Transaction::getAmount)));
		highestTransaction.ifPresent(System.out::println);
		
		totalValue =  transactions.stream().collect(reducing(0.0,Transaction::getAmount,Double::sum));
		System.out.println(totalValue);
		
		//grouping
		Map<String,List<Transaction>> transactionByCurrencies = transactions.stream().collect(groupingBy(Transaction::getCurrency));
		System.out.println(transactionByCurrencies);
		
		Map<Boolean,List<Transaction>> partitionedTransactions = transactions.stream().collect(partitioningBy(t->t.getAmount()>1000));
		System.out.println(partitionedTransactions);
		
		Map<String,Double> cityToSum = transactions.stream().collect(groupingBy(Transaction::getCity,summingDouble(Transaction::getAmount)));
		System.out.println(cityToSum);
		
		Map<String,Optional<Transaction>> cityToHighestTransaction = transactions.stream().collect(groupingBy(Transaction::getCity,maxBy(comparing(Transaction::getAmount))));
		System.out.println(cityToSum);
		
	//	Map<String,Double> cityToCurrencyToAverage = transactions.stream().collect(groupingBy(Transaction::getCity,groupingBy(Transaction::getCurrency,averagingDouble(Transaction::getAmount))));

		List<Person> people = DataLoader.newPersons();
		
		people.stream().filter(t -> t.getAge()>=21);
		people.stream().filter(t -> t.getAge()>=21).forEach(t -> System.out.println(" "+t.getFirstName()));
		
		Predicate<Person> drinkingAge=(t)-> t.getAge()>=21;
		Predicate<Person> brown=(t)-> t.getLastName().equals("brown");
		people.stream().filter(drinkingAge.and(brown)).forEach((it) -> System.out.println(" "+it.getFirstName()));
		
		IntStream ages = people.stream().mapToInt((it) ->it.getAge());
		
		sum = people.stream().mapToInt(Person::getAge).sum();
		
		people.parallelStream().filter((it) -> it.getAge()>=21).forEach((it) -> System.out.println(" "+it.getFirstName()+Thread.currentThread()));
	
		List<Integer> listOfNumbers = Arrays.asList(1,2,3,4);
		listOfNumbers.parallelStream().forEach(number -> System.out.println(number + " "+Thread.currentThread().getName()));
		
		listOfNumbers = Arrays.asList(1,2,3,4);
		sum = listOfNumbers.parallelStream().reduce(0, Integer::sum)+5;
		
		IntStream.rangeClosed(1, 100).reduce(0, Integer::sum);
		IntStream.rangeClosed(1, 100).parallel().reduce(0, Integer::sum);
		
		List<Integer> arrayListOfNumbers =  new ArrayList();
		List<Integer> linkedListOfNumbers =  new LinkedList();
		
		IntStream.rangeClosed(1, 1_000_000).forEach(i->{
			arrayListOfNumbers.add(i);
			linkedListOfNumbers.add(i);
		});
		arrayListOfNumbers.stream().reduce(0, Integer::sum);
		arrayListOfNumbers.parallelStream().reduce(0, Integer::sum);
		linkedListOfNumbers.stream().reduce(0, Integer::sum);
		linkedListOfNumbers.parallelStream().reduce(0, Integer::sum);
		
	
	
	
	}
	

}

//streamdemotest
package com.dnapass.java.training.streams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StreamDemoTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
