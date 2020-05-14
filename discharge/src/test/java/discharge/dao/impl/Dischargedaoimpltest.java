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

import com.fasterxml.jackson.core.JsonParser.Feature;

import com.fasterxml.jackson.databind.ObjectMapper;

import discharge.dao.DischargeDao;

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

}