package com.tweaker.handler.exception;

import com.tweaker.model.response.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Ankit Khatri
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 6709980448262375845L;
	private ResponseMessage responseMsg;
	private String message;

}
