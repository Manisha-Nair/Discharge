package discharge.resources;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import discharge.dto.Dischargedto;
import discharge.request.DischargeRequest;
import discharge.response.DischargeResponse;
import discharge.service.DischargeService;

@RunWith(MockitoJUnitRunner.class)
public class DischargeResourceTest {

	@Mock
	DischargeService service;

	@InjectMocks
	DischargeResource resource = new DischargeResource();

	@Test
	public void testgetDischargeById() {

		Dischargedto discharge = new Dischargedto();

		discharge.setPatient_name("Albert");

		Mockito.when(service.getDischargeByDischargeId("Albert")).thenReturn(discharge);

		DischargeResponse response = resource.getDischargeById("Albert");

		assertEquals("Albert", response.getPatient_name());

	}
	
	@Test
	public void test2getDischargeById() {

		Dischargedto discharge = new Dischargedto();

		discharge.setTreatment("kideny stone");

		Mockito.when(service.getDischargeByDischargeId("kideny stone")).thenReturn(discharge);

		DischargeResponse response = resource.getDischargeById("kideny stone");

		assertEquals("kideny stone", response.getTreatment());

	}

	
	@Test
	public void test3getDischargeById() {

		Dischargedto discharge = new Dischargedto();

		discharge.setTransportation("no");

		Mockito.when(service.getDischargeByDischargeId("no")).thenReturn(discharge);

		DischargeResponse response = resource.getDischargeById("no");

		assertEquals("no", response.getTransportation());

	}

	@Test
	public void testaddPatientInfo() {

		DischargeRequest request = new DischargeRequest();

		request.setPatient_name("David");

		request.setTreatment("ecg");

		request.setTransportation("yes");

		request.setHomecare("no");

		request.setClinicalequipment("no");

		Dischargedto savedPatient = new Dischargedto();

		savedPatient.setId(40);

		savedPatient.setPatient_name("David");

		savedPatient.setTreatment("ecg");

		savedPatient.setTransportation("yes");

		savedPatient.setHomecare("no");

		savedPatient.setClinicalequipment("no");
		
		Mockito.when(service.createPatient(Mockito.any(Dischargedto.class))).thenReturn(savedPatient);

		DischargeResponse response = resource.addPatientInfo(request);

		assertEquals("no", response.getClinicalequipment());

	}
}
