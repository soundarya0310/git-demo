package com.dnapass.java.training.collections;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> colors=new ArrayList<String>();
		//add elements to the arraylist
		colors.add("Blue");
		colors.add("Red");
		colors.add("Green");
		colors.add("Yellow");
		colors.add("Black");
		colors.add(0, "White");
		
		//prints arraylist
		System.out.println(colors);
		
		//using iterator to print array list
		Iterator clrIter = colors.iterator();
		while(clrIter.hasNext())
			System.out.print(clrIter.next() + " ");
		
		//print single element of given index
		System.out.println("\n"+colors.get(1));
		colors.add("brown");
		System.out.println(colors);
		colors.set(6,"Brown");
		System.out.println(colors);
		//colors.remove(1);
		
		ArrayList<String> colors1=new ArrayList<String>();
		colors1.addAll(colors);
		colors.removeAll(colors1);
		System.out.println(colors+" "+colors1);
		Collections.sort(colors1);
		System.out.println(colors1);
		Collections.copy(colors1, colors);
		System.out.println(colors);
		Collections.shuffle(colors1);
		System.out.println(colors1);
		Collections.swap(colors1,0,1);
		System.out.println(colors1);
		
		
		Set<String> hset1=new HashSet<String>(colors1);
		System.out.println("Hset "+hset1);
		
		Set<String> tset1=new TreeSet<String>(colors1);
		System.out.println("tset "+tset1);
		
		LinkedList<String> ll1= new LinkedList<String>(colors1);
		System.out.println("Liked list :"+ll1);
		
		ArrayList<String> c1=(ArrayList<String>) colors1.clone();
		c1.ensureCapacity(10); // capacity increased to 10
		
	}


}
//dataloader
package com.dnapass.java.training.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dnapass.java.training.streams.Person;

public class DataLoader {
	public static List<Transaction> newTransactions() {
		List<Transaction> Transactions = new ArrayList<Transaction>();
		Transactions.add(new Transaction(123,ProductType.FUEL,33.33,"LONDON","GBP"));
		Transactions.add(new Transaction(124,ProductType.ELECTRIC,100.0,"BANGALORE","INR"));
		Transactions.add(new Transaction(125,ProductType.GROCERIES,50.5,"CHENNAI","INR"));
		return Transactions;
	}
	public static List<Person> newPersons(){
		return Arrays.asList(new Person("ted","neward",42),new Person("charlotte","neward",39)
				,new Person("michal","neward",19),new Person("mathew","newton",13),new Person("naal","ford",45),
				new Person("candy","ford",39),new Person("jeff","brown",43),new Person("betsy","brown",39));
	}
}
//frequencymap
package com.dnapass.java.training.collections;

import java.util.HashMap;
import java.util.Map;

public class FrequencyMap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"hi","bye","hello","welcome"};
		Map<String,Integer> n= new HashMap<String , Integer>();
		for(String s:words) {
			Integer temp= n.get(s);
			n.put(s, (temp==null)?1:temp+1);
		}
		System.out.println(n+" "+n.size());
		for(String s:words) {
			Integer temp= n.get(s);
			n.put(s, (temp==null)?1:temp+1);
		}
		System.out.println(n+" "+n.size());
		
		for(String s:words) {
			Integer temp= n.get(s);
			n.put(s, (temp==null)?1:temp+1);
		}
		System.out.println(n+" "+n.size());
		
	}

}
//hashmap
package com.dnapass.java.training.collections;

import java.util.*;
import java.util.Map.Entry;
public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> hmap= new HashMap<Integer,String>();
		hmap.put(0,"Hello");
		hmap.put(1, "There");
		hmap.put(2, "How");
		hmap.put(3, "Are");
		hmap.put(4, "You");
		hmap.put(5, "Mate");
		hmap.put(6, "Seems");
		hmap.put(6, "Fine"); //overrides the previous value
		
		for(Entry <Integer,String> e:hmap.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
		
		HashMap<Integer,String> hmap1=new HashMap<Integer,String>(hmap);
		hmap1.put(7, "boss");
		System.out.println(hmap1);
		
		HashMap<Integer,String> hmap2=new HashMap<Integer,String>();
		hmap2.putAll(hmap1);
		hmap2.put(8, "Good Morning");
		System.out.println(hmap2);
		
		HashMap<Integer,String> hmap3=new HashMap<Integer,String>(hmap);
		hmap3=(HashMap<Integer,String>)hmap2.clone();
		System.out.println(hmap3);
		
		System.out.println("Conrains key : " + hmap2.containsKey(7)+hmap2.containsValue("seems"));
		System.out.println(hmap2.entrySet()+hmap2.get(0));
		
		//generic set
		Set s=hmap.entrySet();
		System.out.println("Set :"+s);
	}

}
//hashset
package com.dnapass.java.training.collections;


 import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// Create a empty hash set
		HashSet<String> colors = new HashSet<String>();
		// use add() method to add values in the hash set
		colors.add("Red");
		colors.add("Green");
		colors.add("Black");
		colors.add("White");
		colors.add("Pink");
		colors.add("Yellow");
		// print the hash set
		System.out.println("The Hash Set: "+ colors);



		//set Iterator
		Iterator<String> p = colors.iterator();



		// Iterate the hash set
		while (p.hasNext())
		{
		System.out.println(p.next());
		}
		System.out.println("Size of the Hash Set:"+ colors.size());
		System.out.println("Checking the above array list is empty or not! "+colors.isEmpty());



		//Remove all elements
		colors.removeAll(colors);



		System.out.println("Hash Set after removing all the elements "+colors);



		System.out.println("Checking the above array list is empty or not! "+colors.isEmpty());
		HashSet<String> new_h_set = new HashSet <String>() ;
		new_h_set = (HashSet)colors;
		System.out.println("Cloned Hash Set: " + new_h_set);



		//Creating an Array
		String[] new_array = new String[colors.size()];
		colors.toArray(new_array);




		// Displaying Array elements
		System.out.println("Array elements: ");
		for(String element : new_array)
		{
		System.out.println(element);
		}



		//Create a TreeSet of HashSet elements
		Set<String> tree_set = new TreeSet<String> (colors);



		// Display TreeSet elements
		System.out.println("TreeSet elements: ");
		for(String element : tree_set)
		{
		System.out.println(element);
		}




		//Create a List from HashSet elements
		List<String> list = new ArrayList<String>(colors);



		//Display ArrayList elements
		System.out.println("ArrayList contains: "+ list);
		HashSet<String>h_set2 = new HashSet<String>();
		h_set2.add("Red");
		h_set2.add("Pink");
		h_set2.add("Black");
		h_set2.add("Orange");
		System.out.println("Second HashSet content: "+h_set2);
		colors. retainAll(h_set2);
		System.out.println("HashSet content: ");
		System.out.println(colors);
		colors.removeAll(h_set2);



		// clear() method removes all the elements from a hash set
		//_and the set becomes empty
		colors.clear();



		//Display original hash set content again
		System.out.println("HashSet content: "+colors);
		HashSet<String> uniques = new HashSet<String>();
		HashSet<String> dups = new HashSet<String>();
		for (String a : args)
		if (!uniques.add(a))
		dups.add(a);



		// Destructive set-différence
		uniques.removeAll(dups);
		System.out.println("Unique words: " + uniques);
		System.out.println("Duplicate words: " + dups);
		Set<String> s = new HashSet<String>();
		for (String a : args)
		s.add(a);
		System.out.println(s.size() + " distinct words: " + s);

	}

}
//linkedlist
package com.dnapass.java.training.collections;

import java.util.*;
public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> ll1=new LinkedList<Integer>();
		ll1.add(1);
		ll1.add(2);
		ll1.add(4);
		ll1.add(8);
		ll1.add(2, 11);
		ll1.add(11);
		ll1.add(10);
		ll1.add(100);
		ll1.add(17);
		ll1.add(22);
		
		System.out.println(ll1.offer(9));
		
		System.out.println(ll1);
		Iterator llIter = ll1.descendingIterator();
		while(llIter.hasNext()) {
			System.out.println(llIter.next());
		}
		System.out.println("peek :"+ll1.peek());
		System.out.println("Sublist :"+ll1.subList(2, 5));
		
		Set<Integer> hset= new HashSet<Integer>(ll1);
		System.out.println(hset);
		Set<Integer> tset= new TreeSet<Integer>(ll1);
		System.out.println(tset);
		Iterator tsetIter= tset.iterator();
	}

}

//maintrans
package com.dnapass.java.training.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;

public class MainTrans extends TransactionService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction t1 = new Transaction(126, ProductType.GROCERIES, 100.33, "USA", "DOLLARS");
		Transaction t2 = new Transaction(127, ProductType.ELECTRIC, 159.44, "UK", "GBP");
		Transaction t3 = new Transaction(128, ProductType.FRUITS, 34.75, "USA", "DOLLARS");
		Transaction t4 = new Transaction(129, ProductType.FUEL, 94.15, "KERELA", "INR");
		Transaction t5 = new Transaction(130, ProductType.FRUITS, 489.98, "DELHI", "INR");
		Transaction t6 = new Transaction(131, ProductType.GROCERIES, 78.45, "USA", "DOLLARS");
		Transaction t7 = new Transaction(132, ProductType.ELECTRIC, 77.98, "LONDON", "GBP");

		TransactionService ts = new TransactionService();
		ts.create(t1);
		ts.create(t2);
		ts.create(t3);
		ts.create(t4);
		ts.create(t5);
		ts.create(t6);
		ts.create(t7);

		System.out.println("After Creating Transactions :");
		ts.ShowTransactions();
		ts.delete(t5);
		System.out.println("\nAfter Removing Transaction 5 :");
		ts.ShowTransactions();
		System.out.println("\nFind transaction 5 and 4 :" + ts.find(t5) + " " + ts.find(t4));
		Transaction t8 = new Transaction(128, ProductType.FRUITS, 100.15, "KERELA", "INR");
		ts.update(t8);
		System.out.println("\nAfter updating :");
		ts.ShowTransactions();
		System.out.println("\nfind by ID :");
		ts.findById(126);
		System.out.println("\nfind by ProductType :");
		System.out.println(ts.findByProductType(ProductType.FRUITS));

		// samples

		System.out.println("\nDelete by city :");
		ts.DeleteByCity("USA");
		ts.ShowTransactions();

		System.out.println("\nDelete Dublicates :");
		Transaction t9 = new Transaction(128, ProductType.FRUITS, 100.15, "KERELA", "INR");
		Transaction t10 = new Transaction(128, ProductType.FRUITS, 100.15, "KERELA", "INR");
		Transaction t11 = new Transaction(127, ProductType.ELECTRIC, 159.44, "UK", "GBP");
		ts.create(t9);
		ts.create(t10);
		ts.create(t11);
		System.out.println("\nbefore Delete Dublicates :");
		ts.ShowTransactions();
		ts.removeDuplicate();
		System.out.println("\nafter Delete Dublicates :");
		ts.ShowTransactions();

		System.out.println("\nSwap transaction :");
		System.out.println("\nbefore Swap transaction :");
		ts.ShowTransactions();
		ts.swapTransactions(1, 5);
		System.out.println("\nafter Swap transaction :");
		ts.ShowTransactions();

		System.out.println("\nReplace Product type :");
		ts.replaceProductType(ProductType.FUEL, ProductType.ELECTRIC);
		ts.ShowTransactions();

		System.out.println("\nNew Transactions :");
		ts.newTransaction(1, 5);
		// ts.ShowTransactions();

		// not working
		System.out.println("\nFind Transactions using binary search :");
		ts.ShowTransactions();
		ts.binarySearch(t2);

		System.out.println("\nSort Transactions :");
		ts.sortByAmount();
		System.out.println("\nAfter Sort Transactions by amount :");
		ts.ShowTransactions();

		ts.sortByCity();
		System.out.println("\nAfter Sort Transactions by City :");
		ts.ShowTransactions();
		//Generic
		//System.out.println("\nAfter Sort Transactions by City :");
		//Comparator<Transaction> cm = Comparator.comparing(Transaction::getCity,Comparator.nullsLast(String::compareTo));
		//Collections.sort(ts,comparing(Transaction::getCity));
		
	}


}
//priorityqueue
package com.dnapass.java.training.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> colors = new PriorityQueue<String>();
		colors.add("Blue");
		colors.add("Red");
		colors.add("Green");
		colors.add("Yellow");
		colors.add("Black");
		colors.add("White");
		colors.add("Grey");
		System.out.println(colors);
		System.out.println(colors.peek());
		
		PriorityQueue<String> colors1 = new PriorityQueue<String>(colors);
		System.out.println(colors1);
		
		Set<String> hset= new HashSet<String>(colors);
		System.out.println(hset);
		TreeSet<String> tset= new TreeSet<String>(colors);
		System.out.println(tset);
		// Iterator tsetIter=tset.descendingIterator();
		LinkedList<String> ll1= new LinkedList<String>(colors);
		System.out.println(ll1);
		
		ArrayList<String> Al= new ArrayList<String>(colors);
		System.out.println(Al);
		
		//Deque <String> dq = ((Deque <String>)colors).clone();
	}

}
//producttype
package com.dnapass.java.training.collections;

public enum ProductType {
	FRUITS,GROCERIES,FUEL,ELECTRIC
	

}
//shuffletransaction
package com.dnapass.java.training.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class ShuffleTransaction {
public static void main(String args[]) {
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
System.out.println("list before shuffling : " + numbers);
// shuffling the list
Collections.shuffle(numbers);
System.out.println("list after shuffling : " + numbers);
// You can even provide your own Random instance
// for randomizing data
Collections.shuffle(numbers, new Random(System.nanoTime()));
System.out.println("list after shuffling again : " + numbers);
}
}
//snippetrunner
package com.dnapass.java.training.collections;

import java.util.HashSet;
import java.util.Set;

public class SnippetRunner {
	public static void main(String[] args) {
		Set<String> colors = new HashSet<String>();
		// TODO Auto-generated method stub
		colors.add("Red");
		colors.add("Green");
		colors.add("Black");
		colors.add("White");
		colors.add("pink");
		colors.add("Yellow");
		
		String[] new_array = new String[colors.size()];
		colors.toArray(new_array);
		
		System.out.println("Array elements : ");
		for(String element : new_array) {
			System.out.println(element);
		}
	}
}
//swaptrans
package com.dnapass.java.training.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class SwapTransObjects {



public static void main(String[] args) {
// TODO Auto-generated method stub

//Create a list with items
List<Integer> list = Arrays.asList(44,55,99,77,88,66,33,22);
System.out.println("List before swapping: "+list);
Scanner sc = new Scanner(System.in);
System.out.print("Enter index i : ");
int i = sc.nextInt();
System.out.print("Enter index j : ");
int j = sc.nextInt();
Collections.swap(list, i, j);
System.out.println("List after swapping: "+list);
sc.close();
}



}
//treesetdemo
package com.dnapass.java.training.collections;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> tset1 = new TreeSet<String>();
		tset1.add("Blue");
		tset1.add("Red");
		tset1.add("Green");
		tset1.add("Yellow");
		tset1.add("Black");
		tset1.add("White");
		tset1.add("Grey");
		System.out.println(tset1);
		Iterator tset1Iter= tset1.iterator();
		while(tset1Iter.hasNext()) {
			System.out.print(tset1Iter.next()+" ");
		}
		System.out.println("\n");
		Iterator tset1desc= tset1.descendingIterator();
		while(tset1desc.hasNext()) {
			System.out.print(tset1desc.next()+" ");
		}
		System.out.println("\n");
		System.out.println("First :"+tset1.first());
		System.out.println("last :"+tset1.last());
		System.out.println("higher :"+tset1.higher("Red"));
		System.out.println("lower :"+tset1.lower("Green"));
		System.out.println("ceiling :"+tset1.ceiling("White"));
		System.out.println("floor :"+tset1.floor("White"));
		System.out.println("pollFirst :"+tset1.pollFirst());
		System.out.println("pollLast :"+tset1.pollLast());
		System.out.println("Subset :"+tset1.subSet("Blue", "Red"));
		System.out.println("tailset :"+tset1.tailSet("Grey"));
		System.out.println("headset :"+tset1.headSet("Grey"));
		System.out.println("Contains :"+tset1.contains("Red"));
		tset1.remove("Red");
		System.out.println(tset1);
		TreeSet<String> tset2 = new TreeSet<String>(tset1);
		
		tset2.add("Red");
		tset2.add("Violet");
		System.out.println(tset2);
	}

}
//transaction
package com.dnapass.java.training.collections;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;



	
class CityComparator  implements Comparator<Transaction>{
	
	@Override
	public int compare(Transaction t1, Transaction t2) {
		// TODO Auto-generated method stub

		return t1.city.compareTo(t2.city);
	}
}
class AmountComparator  implements Comparator<Transaction>{
		
		@Override
		public int compare(Transaction t1, Transaction t2) {
			// TODO Auto-generated method stub

			if(t1.amount==t2.amount)  
				return 0;  
				else if(t1.amount>t2.amount)  
				return 1;  
				else  
				return -1;  
				}
		}
		
public class Transaction  implements Serializable,Cloneable,Comparable<Transaction>{
	protected Integer id;
	protected ProductType type;
	protected Double amount;
	protected String city;
	protected String currency;
	
	
	public Transaction() {
		super();
	}
	
	public Transaction(Integer id, ProductType type, Double amount, String city, String currency) {
		//super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.city = city;
		this.currency = currency;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	
	


	@Override
	public int hashCode() {
		return Objects.hash(amount, city, currency, id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(city, other.city)
				&& Objects.equals(currency, other.currency) && Objects.equals(id, other.id) && type == other.type;
	}

	@Override
	public int compareTo(Transaction o) {
		// TODO Auto-generated method stub
		if(id==o.id)  
			return 0;  
			else if(id>o.id)  
			return 1;  
			else  
			return -1;  
			} 
		
	}


//transactionservice
package com.dnapass.java.training.collections;



import java.util.*;
public class TransactionService {
	static List<Transaction> TRANSACTIONSDATABASE = new ArrayList<Transaction>();
	static {
		TRANSACTIONSDATABASE = DataLoader.newTransactions();

	}

	public void create(Transaction tran) {
		// System.out.println(tran.getId().TYPE+" "+tran.getType()+"
		// "+tran.getAmount().TYPE+" "+tran.getCity()+" "+tran.getCurrency());
		TRANSACTIONSDATABASE.add(tran);
	}

	public void delete(Transaction tran) {
		TRANSACTIONSDATABASE.remove(tran);
	}

	public boolean find(Transaction tran) {

		return TRANSACTIONSDATABASE.contains(tran);
	}

	public boolean update(Transaction tran) {
		int flag = 0;
		for (Transaction s : TRANSACTIONSDATABASE) {
			// System.out.print("Update id :"+tran.getId()+" " +s.getId()+" "
			// +((int)s.getId()==(int)tran.getId()));
			if ((int) s.getId() == (int) tran.getId()) {
				System.out.print("Update id :" + tran.getId() + s.getId());
				s.setType(tran.getType());
				s.setAmount(tran.getAmount());
				s.setCity(tran.getCity());
				s.setCurrency(tran.getCurrency());
				flag = 1;

			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}

	public void ShowTransactions() {
		for (Transaction e : TRANSACTIONSDATABASE) {
			System.out.println(e.id + " " + e.type + " " + e.amount + " " + e.city + " " + e.currency);
		}
	}

	public boolean removeDuplicate() {
		Set<Transaction> set = new HashSet<Transaction>(TRANSACTIONSDATABASE);
//		for(Transaction e:set) {
//			System.out.println(e.id+" "+e.type+" "+e.amount+" "+e.city+" "+e.currency);
//		}
		TRANSACTIONSDATABASE.clear();
		TRANSACTIONSDATABASE.addAll(set);
		return true;
	}

	public boolean swapTransactions(Integer initial, Integer Final) {
		Collections.swap(TRANSACTIONSDATABASE, initial, Final);
		return true;
	}

	public boolean findById(Integer id) {
		for (Transaction s : TRANSACTIONSDATABASE) {
			// System.out.print("Update id :"+tran.getId()+" " +s.getId()+" "
			// +((int)s.getId()==(int)tran.getId()));
			if ((int) s.getId() == (int) id) {
				System.out.println(s.id + " " + s.type + " " + s.amount + " " + s.city + " " + s.currency);
			}
		}
		return false;
	}

	public boolean newTransaction(Integer initial, Integer Final) {
		List<Transaction> newTransactiondb = new ArrayList<Transaction>();
		newTransactiondb.addAll(TRANSACTIONSDATABASE.subList(initial, Final + 1));
		for (Transaction e : newTransactiondb) {
			System.out.println(e.id + " " + e.type + " " + e.amount + " " + e.city + " " + e.currency);
		}
		return true;
	}

	public boolean replaceProductType(ProductType prod, ProductType prod1) {
		for (Transaction s : TRANSACTIONSDATABASE) {
			// System.out.print("Update id :"+tran.getId()+" " +s.getId()+" "
			// +((int)s.getId()==(int)tran.getId()));
			if ((ProductType) s.getType() == prod) {
				System.out.println("found");
				s.setType(prod1);
			}
		}
		return true;
	}

	public boolean DeleteByCity(String city) {
		TRANSACTIONSDATABASE.removeIf(s -> city == s.getCity());
		return false;
	}

	public boolean binarySearch(Transaction tran) {
		Collections.sort(TRANSACTIONSDATABASE);
		System.out.println(Collections.binarySearch(TRANSACTIONSDATABASE, tran));
		return true;
	}

	public boolean sortByAmount() {
		Collections.sort(TRANSACTIONSDATABASE,new AmountComparator());
		return true;
	}
	public boolean sortByCity() {
		Collections.sort(TRANSACTIONSDATABASE,new CityComparator());
		return true;
	}

	public List<Transaction> findByProductType(ProductType prod) {
		for (Transaction s : TRANSACTIONSDATABASE) {
			// System.out.print("Update id :"+tran.getId()+" " +s.getId()+" "
			// +((int)s.getId()==(int)tran.getId()));
			if ((ProductType) s.getType() == prod) {
				System.out
						.print("Update id :" + s.id + " " + s.type + " " + s.amount + " " + s.city + " " + s.currency);

			} else
				return null;
		}

		return null;
	}

	public List<Transaction> findByIdAndProductType(Integer id, ProductType prod, String city) {
		for (Transaction s : TRANSACTIONSDATABASE) {
			// System.out.print("Update id :"+tran.getId()+" " +s.getId()+" "
			// +((int)s.getId()==(int)tran.getId()));
			if (s.getType() == prod && (int) s.getId() == (int) id) {
				System.out
						.print("Update id :" + s.id + " " + s.type + " " + s.amount + " " + s.city + " " + s.currency);

			}
		}
		return null;
	}

}

