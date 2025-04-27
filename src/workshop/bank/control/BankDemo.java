package workshop.bank.control;
import workshop.bank.entity.*;
import workshop.bank.exception.*;
import workshop.bank.control.*;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		System.out.println("== ���� ���� ==");
		bank.createSavingsAccount("ȫ�浿", 10000, 3);
		bank.createCheckingAccount("��ö��", 20000, 5000);
		bank.createSavingsAccount("�̿���", 30000, 2);
		System.out.println();
		
		System.out.println("== ��� ���� ��� ==");
		bank.printAllAccounts();
		System.out.println("============");
		System.out.println();
		
		System.out.println("== �Ա�/��� �׽�Ʈ ==");
		bank.deposit("AC1000", 5000);
		bank.withdraw("AC1002", 3000);
		System.out.println();
		
		System.out.println("== ���� ���� �׽�Ʈ ==");
		bank.applyInterestToAccount("AC1000");
		System.out.println();
		
		
		System.out.println("== ������ü �׽�Ʈ ==");
		bank.transfer("AC1002", "AC1001", 5000);
		System.out.println();
		
		System.out.println("== ��� ���� ��� �׽�Ʈ ==");
		bank.printAllAccounts();
		System.out.println("============");
	}

}
