package discharge.dao;

import discharge.dto.Dischargedto;

public interface DischargeDao {
	
public void openConnection();
	
	public Dischargedto getDischargeById(String patient_id);

	public void closeConnection();

	public Dischargedto savePatient(Dischargedto dischargedto);


}