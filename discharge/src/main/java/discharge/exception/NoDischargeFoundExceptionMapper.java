package discharge.exception;

import discharge.response.ErrorMessages;
import discharge.response.ErrorResponse;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NoDischargeFoundExceptionMapper implements ExceptionMapper<NoDischargeFoundException> {

	@Override
	@Produces(MediaType.APPLICATION_XML)

	public Response toResponse(NoDischargeFoundException exception) {

		ErrorResponse error = new ErrorResponse(exception.getMessage(),

				ErrorMessages.NO_PATIENT_FOUND.name(), "http://documentation.errordetials.com");

		return Response.status(Response.Status.BAD_REQUEST).entity(error).build();

	}

}
