package discharge.exception;

public class NoDischargeFoundException extends RuntimeException {

	private static final long serialVersionUID = -2856989992294756441L;

	public NoDischargeFoundException(String message) {

		super(message);

	}

}