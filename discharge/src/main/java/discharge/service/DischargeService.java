package discharge.service;

import discharge.dto.Dischargedto;
import discharge.exception.InvalidRequestException;
import discharge.exception.NoDischargeFoundException;

public interface DischargeService {
	
	public Dischargedto getDischargeByDischargeId(String patient_id) throws NoDischargeFoundException;
	
	public Dischargedto createPatient(Dischargedto patientdto) throws InvalidRequestException;

}
	