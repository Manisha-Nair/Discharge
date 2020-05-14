package discharge.utils;

import discharge.dto.Dischargedto;
import discharge.exception.InvalidRequestException;
import discharge.response.ErrorMessages;

public class DischargeUtils {
	public void validatePatientRequest(Dischargedto patientdto) {

		// TODO Auto-generated method stub

		if (patientdto.getPatient_name() == null || patientdto.getPatient_name().isEmpty() ||

				patientdto.getTreatment() == null || patientdto.getTreatment().isEmpty() ||

				patientdto.getTransportation() == null || patientdto.getTransportation().isEmpty() ||

				patientdto.getHomecare() == null || patientdto.getHomecare().isEmpty() ||

				patientdto.getClinicalequipment() == null || patientdto.getClinicalequipment().isEmpty()) {

			throw new InvalidRequestException(ErrorMessages.INVALID_FIELD.getErrormessage());

		}

	}

}
