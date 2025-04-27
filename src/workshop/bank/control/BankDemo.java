package workshop.bank.control;
import workshop.bank.entity.*;
import workshop.bank.exception.*;
import workshop.bank.control.*;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		System.out.println("== 계좌 생성 ==");
		bank.createSavingsAccount("홍길동", 10000, 3);
		bank.createCheckingAccount("김철수", 20000, 5000);
		bank.createSavingsAccount("이영희", 30000, 2);
		System.out.println();
		
		System.out.println("== 모든 계좌 목록 ==");
		bank.printAllAccounts();
		System.out.println("============");
		System.out.println();
		
		System.out.println("== 입금/출금 테스트 ==");
		bank.deposit("AC1000", 5000);
		bank.withdraw("AC1002", 3000);
		System.out.println();
		
		System.out.println("== 이자 적용 테스트 ==");
		bank.applyInterestToAccount("AC1000");
		System.out.println();
		
		
		System.out.println("== 계좌이체 테스트 ==");
		bank.transfer("AC1002", "AC1001", 5000);
		System.out.println();
		
		System.out.println("== 모든 계좌 목록 테스트 ==");
		bank.printAllAccounts();
		System.out.println("============");
	}

}
