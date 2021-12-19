package com.dnapass.java.training.threads;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountThreadDemo {
	public static void main(String[] args) {
		BankAccount account=new BankAccount();
		final double AMOUNT=100;
		final int REPITITIONS=10;
		
		DepositRunnable d=new DepositRunnable(account,AMOUNT,REPITITIONS);
		WithdrawRunnable w=new WithdrawRunnable(account,AMOUNT,REPITITIONS);
		
		Thread t1=new Thread(d);
		Thread t2=new Thread(w);
		
		t1.start();
		t2.start();
		
		
	}
	
}

class DepositRunnable implements Runnable{
	private static final int DELAY=1;
	private BankAccount account;
	private double amount;
	private int count;
	public DepositRunnable(BankAccount anAccount, double anAmount, int aCount) {
	     account =anAccount;
		 amount = anAmount;
	     count = aCount;
	}
	public void run() {
		try {
			for(int i=1;i<=count;i++) {
				account.deposit(amount);
				Thread.sleep(DELAY);
			}
		}catch (InterruptedException exception) {
	}
	
}
}

class WithdrawRunnable implements Runnable {
	private static final int DELAY=1;
	private BankAccount account;
	private double amount;
	private int count;
	public WithdrawRunnable(BankAccount anAccount, double anAmount, int aCount) {
		account = anAccount;
		amount = anAmount;
		count = aCount;
	}
	public void run() {
		try {
			for(int i=1;i<=count;i++) {
				account.withdraw(amount);
				Thread.sleep(DELAY);
			}
		}catch (InterruptedException exception) {
	}
}
}

class BankAccount {
	private double balance;
	public BankAccount() {
		balance=0;
	}
 public void deposit(double amount) {
	 System.out.println("Depositing "+amount);
	 double newBalance=balance+amount;
	 System.out.println("new balance is"+newBalance);
	 balance=newBalance;	 
 }
 public double getBalance() {
	 return balance;
 }
 public void withdraw(double amount) {
	 System.out.println("withdrawing"+amount);
	 double newBalance=balance-amount;
	 System.out.println("new balance is:"+newBalance);
	 balance=newBalance;
	 
 }
 public double getBalance1() {
	 return balance;
 }
}



class BankAccount1 {
	private double balance;
	private Lock balanceChangeLock;
	
	public BankAccount1() {
		balance=0;
		balanceChangeLock=new ReentrantLock();
	}
	public void deposit(double amount) {
		balanceChangeLock.lock();
		try {
			System.out.println("Depositing"+amount);
			double newBalance=balance+amount;
			System.out.println("new balance is"+newBalance);
			balance=newBalance;
		}finally {
			balanceChangeLock.unlock(); 
		}
	}
}

class BankAccount2 {
	private double balance;
	private Lock balanceChangeLock;
	private Condition sufficientFundsCondition;
	public BankAccount2() {
		balance=0;
		balanceChangeLock=new ReentrantLock();
		sufficientFundsCondition=balanceChangeLock.newCondition();
	}
	public void deposit(double amount) {
		balanceChangeLock.lock();
		try {
			System.out.println("Depositing"+amount);
			double newBalance=balance+amount;
		    System.out.println(",new balance is"+newBalance);
		    balance=newBalance;
		    sufficientFundsCondition.signalAll();	    
		}finally {
			balanceChangeLock.unlock();
		}
		
	}
	public void withdraw(double amount) {
		balanceChangeLock.lock();
		try {
			while(balance<amount)
				  sufficientFundsCondition.await();
			System.out.println("withdrawing"+amount);
			double newBalance=balance-amount;
			System.out.println(",new balance is"+newBalance);
			balance=newBalance;
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			balanceChangeLock.unlock();
		}
	}

}
//deadlockdemo
package com.dnapass.java.training.threads;

public class DeadLockDemo {
	  static class Friend {
   	   private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
   	   public synchronized void bow(Friend bower) {
   		   System.out.format("%s:,%s"+"has bowed me!%n",this.name,bower.getName());
   		   bower.bowBack(this);
   	   }
   	   public synchronized void bowBack(Friend bower) {
   		   System.out.format("%s:,%s"+"has bowed me!%n",this.name,bower.getName());
   	   }
      }
	public static void main(String[] args) {
		final Friend alphonse=new Friend("Alphonse");
		final Friend gaston=new Friend("Gaston");
		new Thread(new Runnable(){
			public void run() {
				alphonse.bow(gaston);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				gaston.bow(alphonse);
			}
		}).start();

	}

}
//factorialtask
package com.dnapass.java.training.threads;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class FactorialTaskDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		FactorialTask task = new FactorialTask(5);
		System.out.println(task.call());
	}

}

class FactorialTask implements Callable<Integer>{
	int number;
	public FactorialTask(int number) {
		super();
		this.number=number;
	}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int fact = 0;
		for(int count=number;count>1;count--) {
			fact=fact*count;
		}
		return fact;
	}
}
class EventLoggingTask implements Runnable{
	static final Logger logger=Logger.getLogger(EventLoggingTask.class.getName());
	@Override
	public void run() {
		// TODO Auto-generated method stub
		logger.info("Message");
		
	}
	
}
//greetingrunnable
package com.dnapass.java.training.threads;

import java.util.Date;



class GreetingRunnable implements Runnable, ThreadDelay{

	private String greeting;
	private static final int REPETITION =10;
	//private static final int DELAY =1000;
	
	public GreetingRunnable(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=1;i<=REPETITION;i++) {
				Date now = new Date();
				System.out.println(now+ " "+ greeting);
				Thread.sleep(ThreadDelay.DELAY);
			}
		}
		catch(InterruptedException e){
			
		}
	}
	
}
public class GreetingRunnableDemo { 
public static void main(String[] args) {
	// TODO Auto-generated method stub
	GreetingRunnable r1= new GreetingRunnable("Hello world");
	GreetingRunnable r2= new GreetingRunnable("Good Bye.");
	Thread t1 = new Thread(r1);
	Thread t2 = new Thread(r2);
	t1.start();
	t2.start();
}

}

//threaddelay
package com.dnapass.java.training.threads;

interface ThreadDelay {
	static final int DELAY =1000;
}
//threaddemo
package com.dnapass.java.training.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		(new Thread(new HelloRunnable())).start();
		(new HelloThread()).start();
		
	     String importantInfo[] = {"Mares eats oats","Does eats oats","little lamb eat ivy"};
		for(int i=0;i<importantInfo.length;i++) {
			Thread.sleep(4000);
			System.out.println(importantInfo[i]);	
		}
		for(int i=0;i<importantInfo.length;i++) {
			try {
				Thread.sleep(4000);
				
			}catch (InterruptedException e) {
				return;
			}
			System.out.println(importantInfo[i]);
		}

	for(int i=0;i<importantInfo.length;i++) {
		heavyCrunch(importantInfo[i]);
		if(Thread.interrupted()) {
			return;
		}
		if(Thread.interrupted()) {
			throw new InterruptedException();
		}
	}
	}
 public static void heavyCrunch(String string) {
	 
 }
}

class HelloRunnable implements Runnable{
	public void run() {
		System.out.println("Hello from a thread");
	}
}

class HelloThread extends Thread{
	public void run() {
		System.out.println("Hello from a thread");
	}
}

class counter{
	private int c=0;
	public void increment() {
		c++;
	}
	public void decrement() {
		c--;
	}
	public int value() {
		return c;
	}
}


class Synchronizedcounter{
	private int c=0;
	private String lastName;
	private List<String> nameList=new ArrayList();
	public synchronized void increment() {
		c++;
	}
	public synchronized void decrement() {
		c--;
	}
	public  synchronized int value() {
		return c;
	}
	public void addName(String name) {
		synchronized(this) {
			lastName=name;
			c++;
		}
		nameList.add(name);
	}
}


class MsLunch{
	private long c1=0;
	private long c2=0;
	private Object lock1=new Object();
	private Object lock2=new Object();
	
	public void inc1() {
		synchronized(lock1) {
			c1++;
		}
	}
	public void inc2() {
		synchronized(lock2) {
			c2++;
		}
	}
	

}
//threadisalive
package com.dnapass.java.training.threads;

public class ThreadIsAlive extends Thread{
	public static int amount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadIsAlive thread = new ThreadIsAlive();
		thread.start();
		while(thread.isAlive()) {
			System.out.println("Waiting..");
		}
		System.out.println("Main : "+amount );
		amount++;
		System.out.println("Main : "+amount );

	}
	public void run() {
		amount++;
	}

}
