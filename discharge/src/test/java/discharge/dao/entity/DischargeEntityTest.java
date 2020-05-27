package discharge.dao.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class DischargeEntityTest {

	@Test
	public void test() {
		DischargeEntity discharge = new DischargeEntity(20,"Amy","ecg","yes","no","no");
		assertEquals(20,discharge.getId());
		assertEquals("Amy",discharge.getPatient_name());
		assertEquals("ecg",discharge.getTreatment());
		assertEquals("yes",discharge.getTransportation());
		assertEquals("no",discharge.getHomecare());
		assertEquals("no",discharge.getClinicalequipment());
	}


}
