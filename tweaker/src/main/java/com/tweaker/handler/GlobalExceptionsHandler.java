package com.tweaker.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.NoHandlerFoundException;

import com.tweaker.handler.exception.CustomException;
import com.tweaker.handler.exception.InvalidDataException;
import com.tweaker.model.response.ResponseMessage;

/**
 * @author Ankit Khatri
 */

@ControllerAdvice
public class GlobalExceptionsHandler {

	@ExceptionHandler(value = InvalidDataException.class)
	public ResponseEntity<ResponseMessage> exception(InvalidDataException exception, WebRequest request) {
		ResponseMessage errorMsg = new ResponseMessage(400, HttpStatus.BAD_REQUEST, exception.getMessage(), new Date());
		return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<ResponseMessage> exception(MissingServletRequestParameterException exception,
			WebRequest request) {
		ResponseMessage errorMsg = new ResponseMessage(400, HttpStatus.BAD_REQUEST, exception.getMessage(), new Date());
		return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<Object> exception(HttpRequestMethodNotSupportedException exception, WebRequest request) {
		ResponseMessage errorMsg = new ResponseMessage(405, HttpStatus.METHOD_NOT_ALLOWED, exception.getMessage(),
				new Date());
		return new ResponseEntity<>(errorMsg, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	public ResponseEntity<Object> exception2(HttpMessageNotReadableException exception, WebRequest request) {
		ResponseMessage errorMsg = new ResponseMessage(400, HttpStatus.BAD_REQUEST,
				exception.getLocalizedMessage().split(":")[0], new Date());
		return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<ResponseMessage> exception(CustomException exception, WebRequest request) {
		return new ResponseEntity<>(exception.getResponseMsg(), exception.getResponseMsg().getStatus());
	}

	@ExceptionHandler(value = { RuntimeException.class, Exception.class })
	public ResponseEntity<ResponseMessage> exception(Exception exception, WebRequest request) {
		ResponseMessage errorMsg = new ResponseMessage(500, HttpStatus.INTERNAL_SERVER_ERROR,
				"Some Error occured..! Please report to Admin", new Date());
		return new ResponseEntity<>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
