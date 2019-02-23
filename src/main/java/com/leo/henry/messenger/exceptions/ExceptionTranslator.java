package com.leo.henry.messenger.exceptions;


import com.leo.henry.messenger.model.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

/**"
 * Controller advice to translate the server side exceptions to client-friendly json structures.
 */
@Slf4j
//@Provider
//@ControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ValidationException.class)
	public @ResponseBody Object handleCustomException(ValidationException ve, HttpServletRequest request) {
		log.info("...caught validation exception...");

		return new ErrorMessage(ve.getMessage(), 400, "");

	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptionMethod(Exception ex, WebRequest requset) {

		ErrorMessage errorMessage = new ErrorMessage();

		// Handle All Field Validation Errors
		if(ex instanceof MethodArgumentNotValidException) {
			StringBuilder sb = new StringBuilder();
			List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
			for(FieldError fieldError: fieldErrors){
				sb.append(fieldError.getDefaultMessage());
				sb.append(";");
			}
			errorMessage.setErrorMessage(sb.toString());
		}else{
			errorMessage.setErrorMessage(ex.getLocalizedMessage());
		}

		errorMessage.setError(ex.getClass().getCanonicalName());
		errorMessage.setPath(((ServletWebRequest) requset).getRequest().getServletPath());

		// return exceptionMessageObj;
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
//	@ExceptionHandler(Exception.class)
//	public @ResponseBody Object handleGeneralException(HttpServletRequest request, Exception e) throws Exception {
//		log.error("Error thrown {} ",e);
//		return new ErrorMessage(e.getMessage(), 404,"");
//	}

    @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getDefaultMessage());
		}

		ErrorMessage errorDetails = new ErrorMessage(ex.getMessage(), 400,"Validation Failed");
		errorDetails.setErrors(errors);
		return ResponseEntity.status(400).body(errorDetails);
	}


}
