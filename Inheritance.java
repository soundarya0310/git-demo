package com.dnapass.java.training.ineritance1;

public class Account {
private int accountNumber;
private double accountBalance;
private static int LastAssignedNumber= 0;

public Account(int accountNumber,double accountBalance) {
	this.accountNumber = accountNumber;
	this.accountBalance = accountBalance;
}

public Account() {
	LastAssignedNumber++;
	accountNumber = LastAssignedNumber;
}

public Account(double accountBalance) {
	LastAssignedNumber++; 
	accountNumber = LastAssignedNumber;
	this.accountBalance = accountBalance;
}

public void showdata() { 
	System.out.println("Account Number" + accountNumber);
	System.out.println("Account Balance" + accountBalance);
}
public void deposit(double a) {
	System.out.println("account deposit called");
	if(a<0) {
		
	}else
		accountBalance = accountBalance + a;
}
public void withdraw(double a) {
	if(accountBalance < a) {
}else
	accountBalance = accountBalance - a;

}
public void transfer(double amount,Account other) {
	withdraw(amount);
	other.deposit(amount);
	other = new Account(10,amount);
}

public int getAccountNumber() {
	return accountNumber;
	
}
public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}
public double getAccountBalance() {
	return accountBalance;
}
public void setAccountBalance(double accountBalance) {
	this.accountBalance = accountBalance;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp=Double.doubleToLongBits(accountBalance);
	result = prime * result + (int) (temp^ (temp>>> 32));
	result = prime * result + accountNumber;
	return result;
}



@Override
public boolean equals(Object obj) {
	if (this ==obj) {
		return true;
	}
	if(obj==null) {
		return false;
	}
	Account other = (Account) obj;
	if (Double.doubleToLongBits(accountBalance) !=Double.doubleToLongBits(other.accountBalance)) {
		return false;
	}
	if (accountNumber !=other.accountNumber ) {
		return false;
	}
	return true;
}


@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + "]";
	
	
}
}
//accounttest
package com.dnapass.java.training.ineritance1;

public class AccountTest {
	public static void main(String[]args) {
		SavingsAccount account1 = new SavingsAccount(1,1000,0.5);
		
		CurrentAccount account2 = new CurrentAccount(2,2000);
		
		account1.deposit(10000);
		account1.transfer(2000,account2);
		account2.withdraw(1500);
		account2.withdraw(80);
		
		account1.transfer(1000, account2);
		account2.withdraw(400);
		
		account1.addInterest();
		account2.deductFees();
		
		System.out.println("account1 savings balance = " + account1.getAccountBalance());
		System.out.println("account2 checking balance = " + account2.getAccountBalance());
	}
}
//currentaccount
package com.dnapass.java.training.ineritance1;

public class CurrentAccount extends Account{
	private static final int FREE_TRANSACTIONS=3;
	private static final double TRANSACTION_FEE =2.0;
	
	private double transactionCount;
	public CurrentAccount(int accountNumber,double initialBalance)
	{
		
		super(accountNumber,initialBalance);
		transactionCount=0;

	}
	
	
	public void deposit(double amount) {
		System.out.println("current account deposit called");
		transactionCount++;
		super.deposit(amount);
	}



	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		transactionCount++;
		super.withdraw(amount);
	}

	
	public void deductFees() {
		// TODO Auto-generated method stub
		if(transactionCount > FREE_TRANSACTIONS) {
			double fees = TRANSACTION_FEE * (transactionCount - FREE_TRANSACTIONS);
		
		super.withdraw(fees);
		}
		transactionCount =0;
	}


	


	
}
//privelegedaccount
package com.dnapass.java.training.ineritance1;

public class PrivelegedAccount extends Account {
public void withdraw(double amount ) {
		
		super.setAccountBalance(super.getAccountBalance()-amount);
	}

}
//savingsaccount
package com.dnapass.java.training.ineritance1;

public class SavingsAccount extends Account {

	private double interestRate;
	
	public SavingsAccount(int accountNumber, double initialBalance, double rate) {
		super(accountNumber, initialBalance);
		interestRate = rate;
		
	}
	
	public void addInterest() {
		double interest = getAccountBalance() * interestRate / 100;
		deposit(interest);
	}

	
 
	
	
}