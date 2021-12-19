package com.dnapass.java.training.transactionwithstream;

import com.dnapass.java.training.collections.ProductType;
import  com.dnapass.java.training.collections.Transaction;

public class MainTransStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction t1 = new Transaction(126, ProductType.GROCERIES, 100.33, "USA", "DOLLARS");
		TransactionStream ts = new TransactionStream();
		ts.create(t1);
		System.out.println("Find t1 : " + ts.find(t1));
		Transaction t2 = new Transaction(127, ProductType.ELECTRIC, 159.44, "UK", "GBP");
		System.out.println("Find t2 : " + ts.find(t2));
		System.out.println("Before Update");
		ts.ShowTransactions();
		Transaction t3 = new Transaction(126, ProductType.FUEL, 100.33, "USA", "DOLLARS");
		ts.update(t3);
		System.out.println("After Update");
		ts.ShowTransactions();
		ts.sortByAmount();
		System.out.println("After sort by amount");
		ts.ShowTransactions();
		System.out.println("Find by id and type:");
		ts.findByIdAndProductType(126, ProductType.FUEL);

	}

}
//transactionstream
package com.dnapass.java.training.transactionwithstream;

import java.util.*;
import java.util.stream.Collectors;

import com.dnapass.java.training.collections.DataLoader;
import com.dnapass.java.training.collections.ProductType;
import com.dnapass.java.training.collections.Transaction;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class TransactionStream {
	public static List<Transaction> TransactionsStream = new ArrayList<Transaction>();
	static {
		TransactionsStream = DataLoader.newTransactions();

	}

	public void create(Transaction tran) {

		TransactionsStream.add(tran);
	}

	public void delete(Transaction tran) {
		TransactionsStream.remove(tran);
	}

	public boolean find(Transaction tran) {

		return TransactionsStream.stream().anyMatch(n -> n.getId() == tran.getId());
	}

	public boolean update(Transaction tran) {
		TransactionsStream.stream().filter(t -> t.getId() == tran.getId()).forEach(t -> {
			t.setId(tran.getId());
			t.setAmount(tran.getAmount());
			t.setCity(tran.getCity());
			t.setCurrency(tran.getCurrency());
			t.setType(tran.getType());
		});
		return true;
	}

	public void ShowTransactions() {
		TransactionsStream.stream().forEach(t -> {
			System.out.println(
					t.getId() + " " + t.getAmount() + " " + t.getCity() + " " + t.getCurrency() + " " + t.getType());
		});
	}

	public boolean removeDuplicate() {
		TransactionsStream.stream().forEach(t -> {
			int temp;
			temp = t.getId();

		});
		return true;
	}

	public boolean swapTransactions(Integer initial, Integer Final) {
		// TransactionsStream.stream().filter(t->t.getId()==intial)

		return true;
	}

	public void findById(Integer id) {

		TransactionsStream.stream().filter(t -> t.getId() == id).forEach(t -> {
			System.out.println(
					t.getId() + " " + t.getAmount() + " " + t.getCity() + " " + t.getCurrency() + " " + t.getType());
		});
	}

//	public boolean newTransaction(Integer initial, Integer Final) {
//		
//		return true;
//	}

	public boolean replaceProductType(ProductType prod, ProductType prod1) {
		TransactionsStream.stream().filter(t -> t.getType() == prod).forEach(t -> {
			t.setType(prod1);
		});
		return true;
	}

	public boolean sortByAmount() {
		// TransactionsStream.stream().filter(t->t.getAmount()).collect(Collectors.)
		TransactionsStream = TransactionsStream.stream().sorted(comparing(t -> t.getAmount())).collect(toList());
		return true;
	}

	public boolean sortByCity() {
		TransactionsStream = TransactionsStream.stream().sorted(comparing(t -> t.getCity())).collect(toList());
		return true;
	}

	public List<Transaction> findByProductType(ProductType prod) {

		TransactionsStream.stream().filter(t -> t.getType() == prod).forEach(t -> {
			System.out.println(
					t.getId() + " " + t.getAmount() + " " + t.getCity() + " " + t.getCurrency() + " " + t.getType());
		});
		return null;
	}

	public List<Transaction> findByIdAndProductType(Integer id, ProductType prod) {
		TransactionsStream.stream().filter(t -> t.getId() == id).filter(t -> t.getType() == prod).forEach(t -> {
			System.out.println(
					t.getId() + " " + t.getAmount() + " " + t.getCity() + " " + t.getCurrency() + " " + t.getType());
		});
		return null;
	}

//	
//	public enum ProductType{
//		FRUITS,GROCERIES,FUEL,ELECTRIC
//	}

}
