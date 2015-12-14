package rest.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorControllerAdvise {
	@ExceptionHandler(value = Exception.class)
	public @ResponseBody ErrorResponse handler(Exception e) {
		return new ErrorResponse(e.getMessage());
	}
}
