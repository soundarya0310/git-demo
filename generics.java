package com.dnapass.java.training.generics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericDemo {
	class Box{
		private Object object;
		public void set(Object object) {
			this.object=object;
		}
		public Object get() {
			return object;
		}
	}
	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("Hello");
		String s=(String)list.get(0);
		
		List<String> list1=new ArrayList<String>();
		list1.add("hello");
		s=list1.get(0);  //no cast
		
		GenericBox<Integer> integerBox;
		integerBox=new GenericBox<Integer>();
		
		GenericBox<Integer> integerBox1=new GenericBox<>();
		
		Pair<String,Integer> p1=new OrderedPair<>("Even",8);
		Pair<String,String> p2=new OrderedPair<>("hello","world");
		
		OrderedPair<String,GenericBox<Integer>> p=new OrderedPair<>("prime",new GenericBox<>());
		
		GenericBox rawBox=new GenericBox();
		
		rawBox=integerBox1;
		
		integerBox1=rawBox;
		rawBox.set(8);
		
		Pair<Integer,String> p3=new OrderedPair<>(1,"apple");
		Pair<Integer,String> p4=new OrderedPair<>(2,"pear");
		boolean same=Util.<Integer,String>compare(p3,p4);
		
		same=Util.compare(p3,p4);
		
		Pair<String,Integer> p5=new OrderedPair<>("abc",1);
		Pair<String,Integer> p6=new OrderedPair<>("xyz",2);
		same=Util.<String,Integer>compare(p5,p6);
		same=Util.compare(p5,p6);
		
		integerBox=new GenericBox<Integer>();
		integerBox.set(new Integer(10));
		integerBox.inspect("some text");
		integerBox.inspect(20);
		
		integerBox.inspect1(20);
		//integerBox.inspect("some text")//error:this is still string!
		
		Integer[] array= {new Integer(10),new Integer(20)};
		
		GenericDemo.<Integer>counterGreaterThanBounded(array,new Integer(10));
		Object someObject=new Object();
		Integer someInteger=new Integer(10);
		someObject=someInteger;//ok

		someInteger=(Integer)someObject;
		
		GenericBox<Number> box=new GenericBox<Number>();
		box.add(new Integer(10));
		box.add(new Double(10.1));
		
		GenericBox<Number> boxInteger=new GenericBox<Number>();
		//boxInteger.boxTest(new GenericBox<Integer>);
		boxInteger.boxTest(new GenericBox<Number>());
		
		java.util.ArrayList<GenericBox<Integer>> listOfIntegerBoxes=new java.util.ArrayList<>();
		GenericDemo.<Integer>addBox(Integer.valueOf(10),listOfIntegerBoxes);
		addBox(Integer.valueOf(20),listOfIntegerBoxes);
		addBox(Integer.valueOf(30),listOfIntegerBoxes);
		outputBoxes(listOfIntegerBoxes);
		
		List<Integer> li=Arrays.asList(1,2,3);
		System.out.println("sum="+sumOfList(li));
		
		List<Double> ld=Arrays.asList(1.2,2.2,3.2);
		System.out.println("sum="+sumOfList(ld));
		
		List<Integer> li1=Arrays.asList(1,2,3);
		List<String> ls=Arrays.asList("one","two","three");
		//GenericDemo.printlist(li);
		//GenericDemo.printlist(ls);
		
		GenericDemo.printList1(li1);
		GenericDemo.printList1(ls);
		
		List<Integer> intList=new ArrayList<>();
		//List<Number> numList=new intList;//compiler error
		
		List<? extends Integer> intList1=new ArrayList<>();
		List<? extends Number> numList1=intList1;//ok.List<? extends Integer> is a //subtype of List<? extends //Number>
		
		
	}
	public static void addNumbers(List<? super Integer> list) {
		for(int i=1;i<=10;i++) {
			list.add(i);
		}
	}
	public static void printList(List<Object>list) {
		for(Object elem:list)
			System.out.println(elem+" ");
		System.out.println();
	}
	public static void printList1(List<?>list) {
		for(Object elem:list)
			System.out.println(elem+" ");
		System.out.println();
	}
	public  static double sumOfList(List<? extends Number>list) {
		double s=0.0;
		for(Number n:list)
			s+=n.doubleValue();
		return s;
	}
	public static<T>int counterGreaterThan(T[] anArray,T elem){
		int count=0;
		for(T e:anArray)
			//if(e>elem)//compile error
			++count;
		return count;
	}
	public static<T extends Comparable<T>>int counterGreaterThanBounded(T[] anArray,T elem){
		int count=0;
		for(T e:anArray)
			if(e.compareTo(elem)>0)
				++count;
		return count;
	}
	public static <U> void addBox(U u,java.util.List<GenericBox<U>>boxes) {
		GenericBox<U> box=new GenericBox<>();
		box.set(u);
		boxes.add(box);
	  }
	public static <U> void outputBoxes(java.util.List<GenericBox<U>>boxes) {
		int counter=0;
		for(GenericBox<U>box:boxes) {
			U boxContents=box.get();
		System.out.println("Box #"+counter+"contains["+boxContents.toString()+"]");
		counter++;
	}
 }

}

class GenericBox<T>{
	// T stands for "Type"
	private T t;
	public void set(T t) {
		this.t=t;
	}
	public void add(T t) {
		//this.t+=t;
	}
	public void boxTest(GenericBox<Number> n) {
		
		
	}
		public T get() {
			return t;
		}
		public <U extends Number> void inspect1(U u) {
			System.out.println("T:"+t.getClass().getName());
			System.out.println("U:"+u.getClass().getName());
		}
	public <U> void inspect(U u) {
		System.out.println("T:"+t.getClass().getName());
		System.out.println("U:"+u.getClass().getName());
	}
}

interface Pair<K,V>{
	public K getKey();
	public V getValue();
	
}
class OrderedPair<K,V> implements Pair<K,V>{
	private K key;
	private V value;
	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}	
}
class Util{
	public static<K,V> boolean compare(Pair<K,V>p1,Pair<K,V>p2) {
		return p1.getKey().equals(p2.getKey())&& p1.getValue().equals(p2.getValue());	
	}
}
class NaturalNumber<T extends Integer>{
	private T n;
	public NaturalNumber(T n) {
		this.n=n;
	}
	public boolean isEven() {
	return n.intValue()%2==0;
	
	}

}
