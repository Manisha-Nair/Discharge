package discharge.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class DischargedtoTest {

	@Test
	public void test() {
		Dischargedto discharge = new Dischargedto(20,"Amy","ecg","yes","no","no");
		assertEquals(20,discharge.getId());
		assertEquals("Amy",discharge.getPatient_name());
		assertEquals("ecg",discharge.getTreatment());
		assertEquals("yes",discharge.getTransportation());
		assertEquals("no",discharge.getHomecare());
		assertEquals("no",discharge.getClinicalequipment());
	}

}
