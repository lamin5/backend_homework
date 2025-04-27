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
        System.out.println("���� ���°� �����Ǿ����ϴ�: " + newAccount.toString());
    }
	
	public void createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = generateAccountNumber();
        CheckingAccount newAccount = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        bank.add(newAccount);
        System.out.println("üŷ ���°� �����Ǿ����ϴ�: " + newAccount.toString());
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
	        throw new IllegalArgumentException("�Աݾ��� 0���� Ŀ�� �մϴ�");
	    }

	    Account targetAccount = null;
	    for (Account account : bank) {
	        if (account.getAccountNumber().equals(accountNumber)) {
	            targetAccount = account;
	            break;
	        }
	    }

	    if (targetAccount == null) {
	        throw new AccountNotFoundException("���¸� ã�� �� �����ϴ�");
	    }

	    targetAccount.deposit(amount);
	    System.out.printf("%.1f�� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��%n",
	    		amount, targetAccount.getInitialBalance());
	}
	
	public void withdraw(String accountNumber, double amount) {
		if (amount <= 0) {
	        throw new IllegalArgumentException("��ݾ��� 0���� Ŀ�� �մϴ�");
	    }

	    Account targetAccount = null;
	    for (Account account : bank) {
	        if (account.getAccountNumber().equals(accountNumber)) {
	            targetAccount = account;
	            break;
	        }
	    }

	    if (targetAccount == null) {
	        throw new AccountNotFoundException("���¸� ã�� �� �����ϴ�");
	    }

	    targetAccount.withdraw(amount);
	    System.out.printf("%.1f�� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��%n",
	    		amount, targetAccount.getInitialBalance());
	}
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
	    if (amount <= 0) {
	        throw new IllegalArgumentException("��ü �ݾ��� 0���� Ŀ�� �մϴ�: " + amount);
	    }

	    if (fromAccountNumber.equals(toAccountNumber)) {
	        throw new IllegalArgumentException("��ݰ��¿� �Աݰ��°� �����մϴ�");
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
	        throw new AccountNotFoundException("��� ���¸� ã�� �� �����ϴ�");
	    }
	    if (toAccount == null) {
	        throw new AccountNotFoundException("�Ա� ���¸� ã�� �� �����ϴ�");
	    }

	    if (fromAccount.getInitialBalance() < amount) {
	        throw new InsufficientBalanceException(
	            String.format("��ü �����߽��ϴ� �ܾ��� �����մϴ�)",
	                          fromAccountNumber, amount, fromAccount.getInitialBalance()));
	    }

	    fromAccount.withdraw(amount);
	    toAccount.deposit(amount);
	    System.out.printf("%.1f���� ��ݵǾ����ϴ�. ����%s�� ���� �ܾ�: %.1f%n", amount, fromAccount, fromAccount.getInitialBalance());
	    System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ����%s�� ���� �ܾ�: %.1f%n", amount, toAccount, toAccount.getInitialBalance());
	    System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.%n", 
	    		amount,fromAccountNumber, toAccountNumber);
	}
	
	public void applyInterestToAccount(String accountNumber) {
	    Account account = findAccount(accountNumber);
	    
	    if (account == null) {
	        throw new IllegalArgumentException("���¸� ã�� �� �����ϴ�: " + accountNumber);
	    }
	    
	    if (!(account instanceof SavingAccount)) {
	        throw new IllegalArgumentException("���� ���°� �ƴմϴ�: " + accountNumber);
	    }
	    
	    // ���� ���� ����
	    SavingAccount savingsAccount = (SavingAccount) account;
	    savingsAccount.applyInterest();
	    
	    System.out.printf("%s���¿� %.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��\n",
	                    accountNumber,
	                    savingsAccount.getInitialBalance() * savingsAccount.getInterestRate() / 100,
	                    savingsAccount.getInitialBalance());
	    System.out.printf("%s���¿� ���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��\n",
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
