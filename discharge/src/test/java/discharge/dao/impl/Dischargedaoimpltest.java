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

	@Test
	public void testforGET() throws IOException {

		URL url = new URL("http://localhost:8081/discharge/webapi/patient/1");

		String response = new String();

		HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();

		// urlConnect.setRequestProperty("Authorization","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJtZWRib29raW5nLmFwaSIsImlhdCI6MTU4OTI3MjM5Miwic3ViIjoiYXBwdXNlciIsInJvbGVzIjoidXNlciIsImlzcyI6Im1lZGJvb2tpbmciLCJleHAiOjE1ODkyNzU5OTJ9.JUWvJnuzzEHt2-Xqj2SHwHKOYNz_pdtBthl3uoBUrgA");

		//urlConnect.setRequestProperty("Accept", "application/json");

		InputStream is = urlConnect.getInputStream();

		int i = 0;

		while ((i = is.read()) != -1) {

			response = response + (char) i;

			System.out.print((char) i);

		}

		try {

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);

			DischargeResponse jsonMap = mapper.readValue(response, DischargeResponse.class);

			System.out.println(jsonMap.getId());

			assertEquals(1, jsonMap.getId());

		} finally {

			is.close();

		}

	}

	@Test
	public void  testforPOST() throws IOException {
        URL url = new URL("http://localhost:8081/discharge/webapi/patient" );
        String response= new String();
        HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
        urlConnect.setRequestMethod("POST");
        //urlConnect.setRequestProperty("Authorization","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJtZWRib29raW5nLmFwaSIsImlhdCI6MTU4OTI3MjM5Miwic3ViIjoiYXBwdXNlciIsInJvbGVzIjoidXNlciIsImlzcyI6Im1lZGJvb2tpbmciLCJleHAiOjE1ODkyNzU5OTJ9.JUWvJnuzzEHt2-Xqj2SHwHKOYNz_pdtBthl3uoBUrgA");
        urlConnect.setRequestProperty("Content-Type", "application/json");
        urlConnect.setRequestProperty("Accept", "application/json");
        urlConnect.setDoOutput(true);
        String jsonInputString = "{\r\n" +
                "    \r\n" +
                "    \"patient_name\":\"Feliza\",\r\n" +
                "    \"treatment\":\"typhoid\",\r\n" +
                "    \"transportation\":\"no\",\r\n" +
                "    \"homecare\":\"no\",\r\n" +
                "    \"clinicalequipment\":\"no\"\r\n" +
                "    \r\n" +
                "}\r\n";
        try(OutputStream os = urlConnect.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);          
        }
        InputStream is = urlConnect.getInputStream();
        int i = 0;
        while((i =  is.read()) != -1 ) {
            response=response+(char)i;
            System.out.print((char)i);
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
            DischargeResponse jsonMap = mapper.readValue(response, DischargeResponse.class);
            System.out.println(jsonMap.getId());
           assertEquals("no", jsonMap.getHomecare());
        } finally {
            is.close();
        }
    }

}