package discharge.service.impl;

import discharge.dao.DischargeDao;
import discharge.dao.impl.Dischargedaoimpl;
import discharge.dto.Dischargedto;
import discharge.exception.InvalidRequestException;
import discharge.exception.NoDischargeFoundException;
import discharge.response.ErrorMessages;
import discharge.service.DischargeService;
import discharge.utils.DischargeUtils;

public class DischargeServiceImpl implements DischargeService {

	DischargeUtils utils = new DischargeUtils();
	// DischargeDao patientDao = new Dischargedaoimpl();

	private DischargeDao patientDao;

	public DischargeServiceImpl(DischargeDao patientDao) {

		super();

		this.patientDao = patientDao;

	}

	@Override
	public Dischargedto getDischargeByDischargeId(String patientId) throws NoDischargeFoundException {

		Dischargedto patientdto = getDischarge(patientId);
		if (patientdto == null) {

			throw new NoDischargeFoundException(ErrorMessages.NO_PATIENT_FOUND.getErrormessage());

		}
		return patientdto;
	}

	private Dischargedto getDischarge(String patientId) {

		Dischargedto patientdto;
		try {
			patientDao.openConnection();
			patientdto = patientDao.getDischargeById(patientId);
		} finally {
			patientDao.closeConnection();
		}

		return patientdto;
	}

	@Override
	public Dischargedto createPatient(Dischargedto patientdto) throws InvalidRequestException {

		Dischargedto patdto = new Dischargedto();

		utils.validatePatientRequest(patientdto);

		patdto = savePatient(patientdto);

		return patdto;

	}

	private Dischargedto savePatient(Dischargedto patientdto) {

		Dischargedto patdto;

		try {

			patientDao.openConnection();

			patdto = patientDao.savePatient(patientdto);

		}

		finally {

			patientDao.closeConnection();

		}

		return patdto;
	}
}