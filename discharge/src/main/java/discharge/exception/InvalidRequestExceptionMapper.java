package discharge.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import discharge.response.ErrorMessages;
import discharge.response.ErrorResponse;

@Provider
public class InvalidRequestExceptionMapper implements ExceptionMapper<InvalidRequestException> {

	@Override
	public Response toResponse(InvalidRequestException exception) {
		
		ErrorResponse error = new ErrorResponse(exception.getMessage(),

				ErrorMessages.INVALID_FIELD.name(), "http://documentation.errordetials.com");

		return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
	}

}
