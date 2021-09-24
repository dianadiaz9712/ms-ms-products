package com.prototype.product.exeption;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {

	private HttpStatus status;

	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("timestamp")
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	private List<String> subErrors;

	private ApiError() {
		timestamp = LocalDateTime.now();
	}

	public ApiError(HttpStatus status) {
		this();
		this.status = status;
	}

	public ApiError(HttpStatus status, String message, List<String> errors) {
		this();
		this.status = status;
		this.message = message;
		this.subErrors = errors;
	}

	public ApiError(HttpStatus status, String message, String error) {
		this();
		this.status = status;
		this.message = message;
		subErrors = Arrays.asList(error);
	}

}
