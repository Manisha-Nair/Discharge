package discharge.service;

import discharge.dto.Dischargedto;

public interface DischargeService {

	public Dischargedto getDischargeByDischargeId(String patient_id);
}
