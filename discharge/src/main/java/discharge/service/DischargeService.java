package discharge.service;

import discharge.dto.Dischargedto;
import discharge.exception.InvalidRequestException;

public interface DischargeService {
	
	public Dischargedto getDischargeByDischargeId(String patient_id);
	
	public Dischargedto createPatient(Dischargedto patientdto) throws InvalidRequestException;

}
	