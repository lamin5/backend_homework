package workshop.bank.exception;

public class WithdrawalLimitExceededException extends RuntimeException {

	public WithdrawalLimitExceededException(String message) {
		super(message);
	}
}
