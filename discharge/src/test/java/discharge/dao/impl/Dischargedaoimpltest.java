package discharge.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import discharge.dao.DischargeDao;
import discharge.dto.Dischargedto;

public class Dischargedaoimpltest {

	private static DischargeDao impl = new Dischargedaoimpl();

	@BeforeClass
	public static void runBefore() {

		impl.openConnection();

	}

	@AfterClass
	public static void runAfter() {

		impl.closeConnection();

	}

	@Test
	public void testgetDischargeById() {

		Dischargedto patient = impl.getDischargeById("1");

		assertEquals("ecg", patient.getTreatment());

	}

	@Test
	public void testnegativegetPatientById() {

		Dischargedto patient = impl.getDischargeById("50");

		assertEquals(null, patient);

	}

	@Test
	public void testsavePatient() {

		Dischargedto patient = new Dischargedto();

		patient.setPatient_name("David");

		patient.setTreatment("ecg");

		patient.setTransportation("yes");

		patient.setHomecare("no");

		patient.setClinicalequipment("no");

		Dischargedto actual = impl.savePatient(patient);

		assertEquals(patient.getClinicalequipment(), actual.getClinicalequipment());

	}
}