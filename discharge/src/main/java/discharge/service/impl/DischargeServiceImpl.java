package discharge.service.impl;

import discharge.dao.DischargeDao;
import discharge.dao.impl.Dischargedaoimpl;
import discharge.dto.Dischargedto;
import discharge.service.DischargeService;

public class DischargeServiceImpl implements DischargeService {

	DischargeDao patientDao = new Dischargedaoimpl();

	@Override
	public Dischargedto getDischargeByDischargeId(String patientId) {
		// TODO Auto-generated method stub
		Dischargedto patientdto = getDischarge(patientId);
		return patientdto;
	}

	private Dischargedto getDischarge(String patientId) {
		// TODO Auto-generated method stub
		Dischargedto patientdto;
		try {
			patientDao.openConnection();

			patientdto = patientDao.getDischargeById(patientId);
		} finally {
			patientDao.closeConnection();
		}

		return patientdto;
	}

}
