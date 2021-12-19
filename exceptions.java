package com.dnapass.java.training.exceptions;

public class Account {
private int accountnumber; 
private double accountbalance;


public Account (int accnum, double accbal) {

super();
this.accountnumber = accnum;
this.accountbalance = accbal;
}
public int getAccnum() {
return accountnumber;

}

public void setAccnum(int accnum) { 
	this. accountnumber= accnum;
}



public double getAccbal() { 
	return accountbalance; 
	}


public void setAccbal (double accbal) { 
	this.accountbalance = accbal; 
}



public void withdraw(double withdrawalAmt) {

if (accountbalance < withdrawalAmt) { 
	throw new IllegalArgumentException("amt exceed bal");
}else

accountbalance = accountbalance - withdrawalAmt;
}


public void withdrawl(double withdrawalAmt) {

if (accountbalance< withdrawalAmt) {

throw new InsuffientfundRunTimeException();

} else

accountbalance= accountbalance- withdrawalAmt;

}

public void withdraw2(double withdrawalAmt) throws InsuffientFundsException {

if (accountbalance< withdrawalAmt) {
throw new InsuffientFundsException();

} else

accountbalance = accountbalance - withdrawalAmt;
}

public enum ErrorCode {
	Er001, Er002

}

public void deposit(double amount) {
	// TODO Auto-generated method stub
	
}
public double getAccountBalance() {
	// TODO Auto-generated method stub
	return accountbalance ;
}
public int getAccountNumber() {
	// TODO Auto-generated method stub
	return 0;
}


}
//accountexception
package com.dnapass.java.training.exceptions;

public class AccountExceptionTest {

public static void main(String[] args) throws InsuffientFundsException { 

	Account acc =new Account (345789467, 1000);


try {

acc.withdraw(2000); 
} catch (Exception e) { 
	// TODO Auto-generated catch block 
	e.printStackTrace();
}

try {
acc.withdrawl(2000);
}catch (InsuffientfundRunTimeException e) {

 e.printStackTrace();
}
try {
acc.withdraw2(2000);

}catch (InsuffientFundsException e) { 
	// TODO Auto-generated catch block 
	e.printStackTrace();
}

}
}


//insufficientruntime
package com.dnapass.java.training.exceptions;

import java.util.List;

import com.dnapass.java.training.exceptions.InsuffientFundsException.ErrorCode;

public class InsuffientfundRunTimeException extends RuntimeException {
	private List<String> details; 
	private final ErrorCode code;

public List<String> getDetails() { 
	return details;

}

public void setDetails (List<String> details) { 
	this.details = details;
}


public ErrorCode getCode() { 
	return code;
}

public InsuffientfundRunTimeException() {

super();

this.code = null;
}


public InsuffientfundRunTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
super(message, cause, enableSuppression, writableStackTrace); 
this.code = null;
}


public InsuffientfundRunTimeException(String message, Throwable cause) {

super(message, cause);
this.code = null;
}
public InsuffientfundRunTimeException(String message) {

super(message);

this.code = null;

}

public InsuffientfundRunTimeException (Throwable cause) { 
	super(cause); 
	this.code = null;
}

//TODO Auto-generated constructor stub

public InsuffientfundRunTimeException(String string, ErrorCode er001) { 
	this.code = null;
}


}
//insufficientfundexcep
package com.dnapass.java.training.exceptions;

import java.util.List;



public class InsuffientFundsException extends Exception {

private List<String> details;
private ErrorCode code; 
 public InsuffientFundsException() {
super();

// TODO Auto-generated constructor stub
 }
 public InsuffientFundsException(String message, Throwable cause, boolean enablesuppression,
           boolean writableStackTrace) {
super (message, cause, enablesuppression, writableStackTrace);
 }




public InsuffientFundsException(String message, Throwable cause) {
	super (message, cause);
	// TODO Auto-generated constructor stub
}

public InsuffientFundsException(String message) { 
	super (message); 
	// TODO Auto-generated constructor stub
}

public InsuffientFundsException(Throwable cause) {

super(cause); 
//TODO Auto-generated constructor stub

}

public InsuffientFundsException(String string, ErrorCode er002) { 
	//TODO Auto-generated constructor stub
}

public List<String> getDetails() {

return details;
}


public void setDetails(List<String> details) {

this.details =details;
}
public ErrorCode getCode() {
     return code;
}
public void setCode(ErrorCode code) {
this.code=code;
}

public enum ErrorCode {

}

}