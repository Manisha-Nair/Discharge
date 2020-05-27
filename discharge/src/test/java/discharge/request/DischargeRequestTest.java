package discharge.request;

import static org.junit.Assert.*;

import org.junit.Test;

import discharge.dto.Dischargedto;

public class DischargeRequestTest {

	@Test
	public void test() {
		DischargeRequest discharge = new DischargeRequest("Amy","ecg","yes","no","no");
		assertEquals("Amy",discharge.getPatient_name());
		assertEquals("ecg",discharge.getTreatment());
		assertEquals("yes",discharge.getTransportation());
		assertEquals("no",discharge.getHomecare());
		assertEquals("no",discharge.getClinicalequipment());
	}

}
