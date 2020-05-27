package discharge.response;

import static org.junit.Assert.*;

import org.junit.Test;

public class ErrorResponseTest {

	@Test
	public void test() {
		ErrorResponse err = new ErrorResponse("Patient with entered Id is not present","NO_PATIENT_FOUND","http://documentation.errordetials.com");
		assertEquals("Patient with entered Id is not present",err.getErrorMessage());
		assertEquals("NO_PATIENT_FOUND",err.getErrorMessageCode());
		assertEquals("http://documentation.errordetials.com",err.getHref());
	}
	
	@Test
	public void test2(){
		ErrorResponse err = new ErrorResponse("Patient with entered Id is not present","NO_PATIENT_FOUND","http://documentation.errordetials.com");
		err.setErrorMessage("Patient with entered Id is not present");
		err.setErrorMessageCode("NO_PATIENT_FOUND");
		err.setHref("http://documentation.errordetials.com");
		assertEquals("Patient with entered Id is not present",err.getErrorMessage());
		assertEquals("NO_PATIENT_FOUND",err.getErrorMessageCode());
		assertEquals("http://documentation.errordetials.com",err.getHref());
	}

}
