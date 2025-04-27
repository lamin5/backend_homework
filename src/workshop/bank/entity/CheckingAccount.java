package workshop.bank.entity;

import workshop.bank.exception.InsufficientBalanceException;
import workshop.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account{
	private double withdrawalLimit;	
	
	public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
		super(accountNumber, ownerName, initialBalance);
		setWithdrawalLimit(withdrawalLimit);
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}

	public void setWithdrawalLimit(double withdrawalLimit) {
		this.withdrawalLimit = withdrawalLimit;
	}
	
	@Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(
                String.format("출금 한도 초과 (한도: %.1f, 요청액: %.1f)", 
                withdrawalLimit, amount)
            );
        }
        super.withdraw(amount); 
    }

	@Override
	public String toString() {
		return "계좌번호: " + getAccountNumber() + ", 소유자: " + getOwnerName() + ", 잔액: " + getInitialBalance() + ", 출금 한도: " + getWithdrawalLimit() + "원";
	}
	
}
