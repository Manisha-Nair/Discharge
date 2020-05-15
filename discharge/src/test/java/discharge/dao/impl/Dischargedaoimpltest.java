package discharge.dao.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.HttpURLConnection;

import java.net.URL;

import java.net.URLConnection;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.core.JsonParser.Feature;

import com.fasterxml.jackson.databind.ObjectMapper;

import discharge.dao.DischargeDao;
import discharge.dao.entity.DischargeEntity;
import discharge.dto.Dischargedto;

import discharge.response.DischargeResponse;

@RunWith(MockitoJUnitRunner.class)

public class Dischargedaoimpltest {

	@Mock
	DischargeDao impl;

	@Test
	public void testgetDischargeById() {

		Dischargedto patient = new Dischargedto();

		patient.setPatient_name("David");

		Mockito.when(impl.getDischargeById("1")).thenReturn(patient);

		String actual = impl.getDischargeById("1").getPatient_name();

		assertEquals("David", actual);

	}

	@Test
	public void testnegativegetDischargeById() {

		Dischargedto patient = new Dischargedto();

		Mockito.when(impl.getDischargeById("50")).thenReturn(patient);

		String actual = impl.getDischargeById("50").getPatient_name();

		assertEquals(null, actual);

	}

	@Test
	public void testsavePatient() {

		Dischargedto patientdto = new Dischargedto();

		DischargeEntity patientEntity = new DischargeEntity();

		Dischargedto savedPatient = new Dischargedto();

		BeanUtils.copyProperties(patientdto, patientEntity);

		BeanUtils.copyProperties(patientEntity, savedPatient);

		Mockito.when(impl.savePatient(patientdto)).thenReturn(savedPatient);

		Dischargedto actual = impl.savePatient(patientdto);

		assertEquals(savedPatient, actual);

	}

}