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

}
