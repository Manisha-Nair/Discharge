package discharge.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import discharge.response.ErrorMessages;
import discharge.response.ErrorResponse;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {

		ErrorResponse error = new ErrorResponse(exception.getMessage(),

				ErrorMessages.INTERNAL_SERVER_ERROR.name(), "http://documentation.errordetials.com");

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();

	}

}