package rest.error;

import rest.to.Response;

public class ErrorResponse extends Response {
	
	public ErrorResponse(String message) {
		super(Response.Status.ERROR);
		super.setData(message);
	}
}
