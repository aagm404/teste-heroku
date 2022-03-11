package com.iot.impacta.exceptionhandler;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.iot.impacta.vo.ExceptionVO;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e, ServletWebRequest request) {
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		ExceptionVO exceptionResponse = new ExceptionVO();
		
		exceptionResponse.setTimestamp(OffsetDateTime.now());
		exceptionResponse.setDetail(e.getMessage());
		exceptionResponse.setType(request.getRequest().getRequestURI());
		
		return handleExceptionInternal(e, exceptionResponse, new HttpHeaders(), status, request);
	}

}
