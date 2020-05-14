package discharge.resources;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import discharge.dto.Dischargedto;
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

}
