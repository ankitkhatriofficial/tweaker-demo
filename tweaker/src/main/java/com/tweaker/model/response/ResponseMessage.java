package com.tweaker.model.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Ankit Khatri
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseMessage {

	private int statusCode;
	private HttpStatus status;
	private String message;
	private Date timestamp;

}
