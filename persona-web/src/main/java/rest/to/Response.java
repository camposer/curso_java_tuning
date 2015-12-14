package rest.to;

public abstract class Response {
	private Status status;
	private Object data;

	public static enum Status {
		SUCCESS, ERROR;
	}
	
	public Response(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
