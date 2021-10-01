package com.tweaker.handler.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 6709980448262375845L;
	private String message;

}
