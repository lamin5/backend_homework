package workshop.bank.entity;

import java.util.ArrayList;
import java.util.List;

import workshop.bank.entity.*;
import workshop.bank.exception.AccountNotFoundException;
import workshop.bank.exception.InsufficientBalanceException;

public class Bank {
	private List<Account> bank = new ArrayList<>();
	private int nextAccountNumber = 1000;
	
	public Bank() {
		
	}
	
	private String generateAccountNumber() {
        return "AC" + nextAccountNumber++;
    }
	
	public void createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = generateAccountNumber();
        SavingAccount newAccount = new SavingAccount(accountNumber, ownerName, initialBalance, interestRate);
        bank.add(newAccount);
        System.out.println("저축 계좌가 생성되었습니다: " + newAccount.toString());
    }
	
	public void createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = generateAccountNumber();
        CheckingAccount newAccount = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        bank.add(newAccount);
        System.out.println("체킹 계좌가 생성되었습니다: " + newAccount.toString());
    }
	
	public Account findAccount(String accountNumber) {
		for(Account account : bank) {
			if(account.getAccountNumber().contentEquals(accountNumber)) {
				return account;
			}
		}
		return null;
	}
	
	public void deposit(String accountNumber, double amount) {
	    if (amount <= 0) {
	        throw new IllegalArgumentException("입금액은 0보다 커야 합니다");
	    }

	    Account targetAccount = null;
	    for (Account account : bank) {
	        if (account.getAccountNumber().equals(accountNumber)) {
	            targetAccount = account;
	            break;
	        }
	    }

	    if (targetAccount == null) {
	        throw new AccountNotFoundException("계좌를 찾을 수 없습니다");
	    }

	    targetAccount.deposit(amount);
	    System.out.printf("%.1f원 입금되었습니다. 현재 잔액: %.1f원%n",
	    		amount, targetAccount.getInitialBalance());
	}
	
	public void withdraw(String accountNumber, double amount) {
		if (amount <= 0) {
	        throw new IllegalArgumentException("출금액은 0보다 커야 합니다");
	    }

	    Account targetAccount = null;
	    for (Account account : bank) {
	        if (account.getAccountNumber().equals(accountNumber)) {
	            targetAccount = account;
	            break;
	        }
	    }

	    if (targetAccount == null) {
	        throw new AccountNotFoundException("계좌를 찾을 수 없습니다");
	    }

	    targetAccount.withdraw(amount);
	    System.out.printf("%.1f원 출금되었습니다. 현재 잔액: %.1f원%n",
	    		amount, targetAccount.getInitialBalance());
	}
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
	    if (amount <= 0) {
	        throw new IllegalArgumentException("이체 금액은 0보다 커야 합니다: " + amount);
	    }

	    if (fromAccountNumber.equals(toAccountNumber)) {
	        throw new IllegalArgumentException("출금계좌와 입금계좌가 동일합니다");
	    }

	    Account fromAccount = null;
	    Account toAccount = null;


	    for (Account account : bank) {
	        if (account.getAccountNumber().equals(fromAccountNumber)) {
	            fromAccount = account;
	        }
	        if (account.getAccountNumber().equals(toAccountNumber)) {
	            toAccount = account;
	        }
	        if (fromAccount != null && toAccount != null) {
	            break;
	        }
	    }

	    if (fromAccount == null) {
	        throw new AccountNotFoundException("출금 계좌를 찾을 수 없습니다");
	    }
	    if (toAccount == null) {
	        throw new AccountNotFoundException("입금 계좌를 찾을 수 없습니다");
	    }

	    if (fromAccount.getInitialBalance() < amount) {
	        throw new InsufficientBalanceException(
	            String.format("이체 실패했습니다 잔액이 부족합니다)",
	                          fromAccountNumber, amount, fromAccount.getInitialBalance()));
	    }

	    fromAccount.withdraw(amount);
	    toAccount.deposit(amount);
	    System.out.printf("%.1f원이 출금되었습니다. 계좌%s의 현재 잔액: %.1f%n", amount, fromAccount, fromAccount.getInitialBalance());
	    System.out.printf("%.1f원이 입금되었습니다. 계좌%s의 현재 잔액: %.1f%n", amount, toAccount, toAccount.getInitialBalance());
	    System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.%n", 
	    		amount,fromAccountNumber, toAccountNumber);
	}
	
	public void applyInterestToAccount(String accountNumber) {
	    Account account = findAccount(accountNumber);
	    
	    if (account == null) {
	        throw new IllegalArgumentException("계좌를 찾을 수 없습니다: " + accountNumber);
	    }
	    
	    if (!(account instanceof SavingAccount)) {
	        throw new IllegalArgumentException("적금 계좌가 아닙니다: " + accountNumber);
	    }
	    
	    // 이자 지급 실행
	    SavingAccount savingsAccount = (SavingAccount) account;
	    savingsAccount.applyInterest();
	    
	    System.out.printf("%s계좌에 %.1f원이 입금되었습니다. 현재 잔액: %.1f원\n",
	                    accountNumber,
	                    savingsAccount.getInitialBalance() * savingsAccount.getInterestRate() / 100,
	                    savingsAccount.getInitialBalance());
	    System.out.printf("%s계좌에 이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원\n",
                accountNumber,
                savingsAccount.getInitialBalance() * savingsAccount.getInterestRate() / 100,
                savingsAccount.getInitialBalance());
	}
	
	public void printAllAccounts() {
		List<Account> AllAccount = new ArrayList<>();
	    for (Account account : bank) {
	        AllAccount.add(account);
	        System.out.println(account.toString());
	    }
	}
	
}
