package discharge.response;

public enum ErrorMessages {

	NO_PATIENT_FOUND("Patient with entered Id is not present"),
	
	INVALID_FIELD("Invalid field value. Please check documentation"),

	INTERNAL_SERVER_ERROR("Internal Server error");

	private String errormessage;

	private ErrorMessages(String errormessage) {

		this.errormessage = errormessage;

	}

	public String getErrormessage() {

		return errormessage;

	}

	public void setErrormessage(String errormessage) {

		this.errormessage = errormessage;

	}
}
