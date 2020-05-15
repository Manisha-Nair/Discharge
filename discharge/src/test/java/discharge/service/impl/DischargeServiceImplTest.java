package discharge.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import discharge.dao.DischargeDao;
import discharge.dto.Dischargedto;
import discharge.exception.InvalidRequestException;
import discharge.exception.NoDischargeFoundException;

@RunWith(MockitoJUnitRunner.class)
public class DischargeServiceImplTest {

	@Mock
	DischargeDao dao;

	@InjectMocks
	DischargeServiceImpl impl = new DischargeServiceImpl(dao);

	@Test
	public void testgetDischargeById() {
		Dischargedto discharge = new Dischargedto();

		discharge.setPatient_name("Albert");

		Mockito.when(dao.getDischargeById("Albert")).thenReturn(discharge);

		Dischargedto actualbook = impl.getDischargeByDischargeId("Albert");

		assertEquals(discharge.getPatient_name(), actualbook.getPatient_name());

	}

	@Test(expected = NoDischargeFoundException.class)
	public void testnegativegetPatientById() {

		Mockito.when(dao.getDischargeById("9")).thenThrow(new NoDischargeFoundException("Error"));

		impl.getDischargeByDischargeId("9");

	}

	@Test
	public void testsavePatientPositive() {
		
		Dischargedto patient = new Dischargedto();

		patient.setId(1);

		patient.setPatient_name("David");

		patient.setTreatment("ecg");

		patient.setTransportation("yes");

		patient.setHomecare("no");

		patient.setClinicalequipment("no");

		Mockito.when(dao.savePatient(patient)).thenReturn(patient);

		Dischargedto actual = impl.createPatient(patient);

		assertEquals(actual, patient);

	}

	@Test(expected = InvalidRequestException.class)
	public void testnegativesavePatient() {

		Dischargedto patient = new Dischargedto();

		patient.setId(1);

		patient.setPatient_name("");

		patient.setTreatment("");

		patient.setTransportation("");

		patient.setHomecare("no");

		patient.setClinicalequipment("");

		Mockito.when(dao.savePatient(patient)).thenThrow(new InvalidRequestException("Error"));

		impl.createPatient(patient);

	}

}