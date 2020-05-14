package discharge.resources;

import discharge.dao.DischargeDao;
import discharge.dao.impl.Dischargedaoimpl;
import discharge.dto.Dischargedto;
import discharge.request.DischargeRequest;
import discharge.response.DischargeResponse;
import discharge.service.DischargeService;
import discharge.service.impl.DischargeServiceImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import org.springframework.beans.BeanUtils;

import jakarta.ws.rs.PathParam;

@Path("/patient")
public class DischargeResource {

	@GET
	@Path("/{patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DischargeResponse getDischargeById(@PathParam("patient_id") String patient_id) {

		DischargeResponse response = new DischargeResponse();

		DischargeService dischargeService = new DischargeServiceImpl();

		Dischargedto dischargedto = dischargeService.getDischargeByDischargeId(patient_id);

		BeanUtils.copyProperties(dischargedto, response);

		return response;

	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DischargeResponse addPatientInfo(DischargeRequest request) {

		DischargeResponse response = new DischargeResponse();

		Dischargedto patientdto = new Dischargedto();
		BeanUtils.copyProperties(request, patientdto);


		DischargeService dischargeService = new DischargeServiceImpl();
		Dischargedto createdpatientdto = dischargeService.createPatient(patientdto);


		BeanUtils.copyProperties(createdpatientdto, response);

		return response;

	}

}
