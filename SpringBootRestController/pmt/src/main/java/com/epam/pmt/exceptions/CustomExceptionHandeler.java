package com.epam.pmt.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.epam.pmt.entity.ExceptionResponse;

@RestControllerAdvice
public class CustomExceptionHandeler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException message,
			WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		message.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message1 = error.getDefaultMessage();
			errors.put(fieldName, message1);
		});
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), errors.toString(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AccountDoesNotExistException.class)
	public ResponseEntity<ExceptionResponse> handleAccountDoesNotExistException(AccountDoesNotExistException message,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidUserName.class)
	public ResponseEntity<ExceptionResponse> handleInvalidUserName(InvalidUserName message, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MasterUsersDoesNotExistException.class)
	public ResponseEntity<ExceptionResponse> handleMasterUsersDoesNotExistException(
			MasterUsersDoesNotExistException message, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidUrlException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidUrlException(InvalidUrlException message,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidLoginDetail.class)
	public ResponseEntity<ExceptionResponse> handleInvalidLoginDetail(InvalidLoginDetail message, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MasterUserAlreadyExistsException.class)
	public ResponseEntity<ExceptionResponse> handleMasterUserAlreadyExistsException(
			MasterUserAlreadyExistsException message, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LoginFirstException.class)
	public ResponseEntity<ExceptionResponse> handleLoginFirstException(LoginFirstException message,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoGroupFoundForAccount.class)
	public ResponseEntity<ExceptionResponse> handleNoGroupFoundForAccount(NoGroupFoundForAccount message,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoRecordFoundForGroup.class)
	public ResponseEntity<ExceptionResponse> handleNoRecordFoundForGroup(NoRecordFoundForGroup message,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<ExceptionResponse> handlePasswordMismatchException(PasswordMismatchException message,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(WrongPasswordException.class)
	public ResponseEntity<ExceptionResponse> handleWrongPasswordException(WrongPasswordException message,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> globalExceptionHandling(Exception exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
