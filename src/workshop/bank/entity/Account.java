package workshop.bank.entity;

import workshop.bank.exception.InsufficientBalanceException;
import workshop.bank.exception.WithdrawalLimitExceededException;
import workshop.bank.entity.*;

public class Account {
	private String accountNumber;
	private String ownerName;
	private double initialBalance;
	
	public Account(String accountNumber, String ownerName, double initialBalance) {
		super();
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.initialBalance = initialBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
		
	}

	public double getInitialBalance() {
		return initialBalance;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public void deposit(double amount) {
		this.initialBalance += amount;	
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException{
		if(amount > getInitialBalance()) {
			String sufMessage = String.format("잔액이 부족합니다. (요청 금액 : %.1f 현재 잔액 : %.1f)", amount, getInitialBalance());
			throw new InsufficientBalanceException(sufMessage);
		}else {
			setInitialBalance(getInitialBalance() - amount);
		}
	}

	public void applyInterest() {
		// TODO Auto-generated method stub
	}
	
	
}
