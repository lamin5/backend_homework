package workshop.bank.entity;

public class SavingAccount extends Account{
	private double interestRate;
	
	public SavingAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
		super(accountNumber, ownerName, initialBalance);
		setInterestRate(interestRate);
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public void applyInterest() {
        double interest = getInitialBalance() * interestRate / 100;
        deposit(interest);
    }
	
	@Override
	public String toString() {
		return "계좌번호: " + getAccountNumber() + ", 소유자: " + getOwnerName() + ", 잔액: " + getInitialBalance() + ", 이자율: " + getInterestRate() + "%";
	}

}
